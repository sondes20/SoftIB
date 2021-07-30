package tn.banque.softib.services;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Credit;
import tn.banque.softib.entity.DemandeCredit;
import tn.banque.softib.entity.TMM;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.repository.IClientRepository;
import tn.banque.softib.repository.ICompteRepository;
import tn.banque.softib.repository.ICreditRepository;
import tn.banque.softib.repository.IDemandeCreditRepository;
import tn.banque.softib.repository.ITmmRepository;

@Service
public class CreditService implements ICreditService {
	private static final Logger l = LogManager.getLogger(CreditService.class);
	@Autowired
	ICreditRepository creditRepo;
	@Autowired
	ICompteRepository compteRepo;
	@Autowired
	IClientRepository clientRepo;
	@Autowired
	IDemandeCreditRepository demandeCreditRepo;
	@Autowired
	ITmmRepository TMMRepo;

	@Override
	public double SommeCreditClients(long id) {
		
		return creditRepo.findSumCreditClients(id);
	}

	@Override
	public void ajouterEtAffecterCreditAClient(long idDemandeCredit, Credit credit, boolean isAccepted) {
		DemandeCredit demande = demandeCreditRepo.findById(idDemandeCredit).get();
		Client c = clientRepo.findById(demande.getCin()).get();
		if(isAccepted){
			credit.setId(idDemandeCredit);
			credit.setClient(c);
			credit.setDateCredit(new Date());
			credit.setMontant(demande.getMaxMontant());
			credit.setType(demande.getTypeCredit());
			creditRepo.save(credit);
			l.info("Demande acceptée!");	
		}
		else{
			l.info("Demande refusée!"); 
		}
		
	}

	@Override
	public List<TMM> getTMM() {
		
		try {
			final Document document =Jsoup.connect("https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105").get();
			for(Element row:document.select("tbody.bct-htr-classic tr")){
				if(row.select("td(1)").text().equals("")){
					continue;
				}else{
					final String ticker = row.select("td(1)").text();
					System.out.println(ticker);
				}
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DemandeCredit ajouterDemandeCredit(TypeCompte type, DemandeCredit demandeCredit) {
		if(type.equals(TypeCompte.COURANT)){
		 demandeCreditRepo.save(demandeCredit);
		}else{
		 l.error("Demande innaccepte! Votre compte est epargne");	
		}
		return demandeCredit;
	}
		
		@SuppressWarnings("unused")
		@Override
		public TMM ajouterTMM() throws IOException {
			TMM tmm = new TMM();
			Document webPage = Jsoup.connect("https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105").get();
		    Element tbody = webPage.getElementById("bct-hdr-classic");
		    Elements rows = tbody.getElementsByTag("tr");
			for(Element row : rows){
				Elements tds = row.getElementsByTag("td");
				for(int i = 0 ; i<tds.size() ; i++){
					tmm.setMonth(tds.get(0).text());
				    tmm.setTmm(tds.get(i+1).text());
				    TMMRepo.save(tmm);
				    
				}
			}
			return tmm;
			
		}

}
