package tn.banque.softib;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Banque;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.EtatCivil;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeContratTravail;
import tn.banque.softib.entity.TypeCredit;
import tn.banque.softib.entity.TypeOperation;
import tn.banque.softib.services.IAgenceService;
import tn.banque.softib.services.IAgentService;
import tn.banque.softib.services.IBanqueServices;
import tn.banque.softib.services.IClientServices;
import tn.banque.softib.services.ICompteService;
import tn.banque.softib.services.ICreditService;
import tn.banque.softib.services.IOperationService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftIBApplicationTests {
	@Autowired
	IBanqueServices banqueService;
	@Autowired
	IAgenceService agenceService;
	@Autowired
	IClientServices clientServices;
	@Autowired
	IOperationService operationServices;
	@Autowired
	ICompteService compteService;
	@Autowired
	IAgentService agentService;
	@Autowired
	ICreditService creditService;

	private static final Logger l = LogManager.getLogger(SoftIBApplicationTests.class);

	@Test
	public void contextLoads() throws ParseException{
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = date.parse("2021-07-24");
		Date d2 = date.parse("2021-07-28");
		Date d3 = date.parse("1986-09-19");
		Date d4 = date.parse("1957-02-02");
		Date d5 = date.parse("1984-11-20");
		
		/*Banque b = new Banque("Banque d'habitat", "71778441", "Cité Mohamed El Khames, Tunis 1000");
		banqueService.ajouterBanque(b);
		
		Agence ag1 = new Agence("Agence BH Kef", "Cité Ahmed Amara, Kef 7100", "Darraji Feten", "78225114");
		Agence ag2 = new Agence("Agence BH Béja", "El Mzara, Béja 9000", "Lahouani Sondes", "78002336");
		Agence ag3 = new Agence("Agence BH Jandouba", "Cité Farhat Hached, Jandouba 8000", "Dardouri Zohra", "78226889");
		Agence ag4 = new Agence("Agence BH Seliana", "Cité Mokhtar Atia, Seliana 6000", "Ghribi Afef", "78224789");
		Agence ag5 = new Agence("Agence BH Bizerte", "Cité Habib Bourguiba, Bizerte 8100", "Ghribi Wided", "72586235");
		agenceService.ajouterAgence(ag1);
		agenceService.ajouterAgence(ag2);
		agenceService.ajouterAgence(ag3);
		agenceService.ajouterAgence(ag4);
		agenceService.ajouterAgence(ag5);*/                //confirmé
		
		/*agenceService.affecterBanqueAAgence(1, 1);
		agenceService.affecterBanqueAAgence(1, 2);
		agenceService.affecterBanqueAAgence(1, 3);
		agenceService.affecterBanqueAAgence(1, 4);
		agenceService.affecterBanqueAAgence(1, 5);*/       //confirmé
		
		/*Agent ag1 = new Agent("001", "Ghribi", "Afef");
		Agent ag2 = new Agent("002", "Darraji", "Feten");
		agentService.ajouterAgent(ag1);
		agentService.ajouterAgent(ag2);*/                   //confirmé
		
		/*clientServices.ajouterEtAffecterClientACompteEtAgent("18253669", "Lahouani", "Mohamed", d2, "Kef", "50178996", "lahouanimohamed@gmail.com", "Ouvrier", TypeClient.PHYSIQUE, "abc", TypeCompte.EPARGNE, 0, "001");
	    clientServices.ajouterEtAffecterClientACompteEtAgent("07225698", "Lahouani", "Ahmed", d1, "Kef", "52552222", "lahouaniahmed@gmail.com", "Ouvrier", TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, 0, "002");
		clientServices.ajouterEtAffecterClientACompteEtAgent("03052244", "Lahouani", "Sadok", d3, "Kef", "50225369", "lahouanisadok@gmail.com", "Ouvrier", TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, 0, "002");
		clientServices.ajouterEtAffecterClientACompteEtAgent("08071652", "Cherni", "Houssem", d4, "Kef", "98553057", "lahouanisadok@gmail.com", "Enseigant", TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, 0, "002");
		clientServices.ajouterEtAffecterClientACompteEtAgent("08061621", "Lahouani", "Sondes", d5, "Kef", "24071704", "lahouanisondes@gmail.com", "femme au foyer", TypeClient.PHYSIQUE, "abc", TypeCompte.EPARGNE, 300, "001");
		clientServices.ajouterEtAffecterClientACompteEtAgent("00022555", "salah", "Mohamed", d2, "Tunis", "55262626", "mohamedsalah@gmail.com", "Commerçant", TypeClient.MORALE, "abc", TypeCompte.EPARGNE, 0, "001");
		clientServices.ajouterEtAffecterClientACompteEtAgent("09226365", "Dardouri", "Zohra", d5, "Tunis", "95662362", "dardourizohra@gmail.com", "Docteur", TypeClient.PHYSIQUE, "abc", TypeCompte.EPARGNE, 0, "002");
		                                                    	
		l.info(compteService.getNombreComptesParType(TypeCompte.COURANT));
		l.info(compteService.getNombreComptesParType(TypeCompte.EPARGNE));
		
		compteService.modifierCompte("0806162166121", "def", TypeCompte.COURANT);
		
		clientServices.affecterBanqueACompte(1, "0002255566121");
		clientServices.affecterBanqueACompte(1, "0305224466121");
		clientServices.affecterBanqueACompte(1, "0806162166121");
		clientServices.affecterBanqueACompte(1, "0807165266121");
		clientServices.affecterBanqueACompte(1, "0922636566121");
		clientServices.affecterBanqueACompte(1, "1825366966121");
		
		for(Compte c : agentService.getCompteEpargne()){
			 l.info(c.getNCompte());
		 }
        for(Compte c : agentService.getCompteCourant()){
			 l.info(c.getNCompte());
		 }
		 
		//operationServices.verser(TypeOperation.VERSEMENT, "0722569866121", "001", 500);
	    //operationServices.verser(TypeOperation.VERSEMENT, "0002255566121", "002", 10000);
		//operationServices.verser(TypeOperation.VERSEMENT, "0305224466121", "001", 700);
		//operationServices.verser(TypeOperation.VERSEMENT, "0806162166121", "002", 70);
		//operationServices.verser(TypeOperation.VERSEMENT, "1825366966121", "001", 200);
	    //operationServices.verser(TypeOperation.VERSEMENT, "0922636566121", "002", 100);
		//operationServices.verser(TypeOperation.VERSEMENT, "0722569866121", "001", 30);
		//operationServices.verser(TypeOperation.VERSEMENT, "0002255566121", "002", 100);
		//operationServices.verser(TypeOperation.VERSEMENT, "0305224466121", "001", 700);
		//operationServices.verser(TypeOperation.VERSEMENT, "0806162166121", "002", 70);
		//operationServices.verser(TypeOperation.VERSEMENT, "0807165266121", "001", 200);
		//operationServices.verser(TypeOperation.VERSEMENT, "0922636566121", "002", 1000);
		//operationServices.retrait(TypeOperation.RETRAIT, "0305224466121", "002", 2300);
		//operationServices.retrait(TypeOperation.RETRAIT, "0722569866121", "001", 300);
		//operationServices.retrait(TypeOperation.RETRAIT, "0806162166121", "002", 600);
		//operationServices.retrait(TypeOperation.RETRAIT, "0807165266121", "001", 100);
		//operationServices.retrait(TypeOperation.RETRAIT, "0922636566121", "002", 500);
		//operationServices.virement(TypeOperation.VIREMENT, "0002255566121", "0807165266121", "001", 1200);
		//operationServices.virement(TypeOperation.VIREMENT, "0002255566121", "0922636566121", "001", 800);
		//operationServices.virement(TypeOperation.VIREMENT, "0002255566121", "0722569866121", "001", 550);
		//operationServices.virement(TypeOperation.VIREMENT, "0002255566121", "0305224466121", "001", 800);
		//operationServices.virement(TypeOperation.VIREMENT, "0002255566121", "0806162166121", "001", 1200);
		
		//l.info(operationServices.getAgentById("001").getPrenom());
		//l.info(operationServices.getSoldeByNumCompte("0002255566121"));
		 
		
		 l.info(compteService.avgSolde());
		 
		 l.info(compteService.listNumCompteAyantMaxSolde(TypeCompte.COURANT));
		 l.info(compteService.listNumCompteAyantMinSolde(TypeCompte.COURANT));
		 l.info(compteService.listNumCompteAyantMaxSolde(TypeCompte.EPARGNE));
		 l.info(compteService.listNumCompteAyantMinSolde(TypeCompte.EPARGNE));
		 
		 //creditService.ajouterEtAffecterCreditAClient("08061621", d1, "24", 60, 40000, 600, TypeCredit.immobiliers, false, 1);
		//creditService.ajouterEtAffecterCreditAClient("03052244", d2, "17", 30 , 20000, 500, TypeCredit.professionnels, false, 2);
		//creditService.ajouterEtAffecterCreditAClient("03052244", d1, "17", 30 , 60000, 500, TypeCredit.professionnels, false, 3);
		//l.info(creditService.SommeCreditClients());
		 
		 for(Operation o :operationServices.getAllOperationsParCompteAndPeriode("0806162166121", 7)){
			l.info(o.getDate()+" ; "+ o.getMontant()+" ; "+o.getSens());
		}
		 */
		     //confirmé
		
		
		//creditService.getTMM();
		
		
		//l.info(operationServices.getMoyOperationParJour(SensOperation.CREDIT, d2));
		
		
	/*	
		Document webPage;
		try {
			webPage = Jsoup.connect("https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105").get();
			Element tbody = webPage.getElementById("bct-hdr-classic");
		    Elements rows = tbody.getElementsByTag("tr");
			for(Element row : rows){
				Elements tds = row.getElementsByTag("td");
				for(int i = 0 ; i<tds.size() ; i++){
				    System.out.println(tds.get(i).text());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		try {
			creditService.ajouterTMM();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static Logger getL() {
		return l;
	}
	
}
