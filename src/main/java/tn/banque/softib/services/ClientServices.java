package tn.banque.softib.services;

import java.util.Date;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.SoftIBApplicationTests;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Banque;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.EtatCivil;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeContratTravail;
import tn.banque.softib.repository.IAgentRepository;
import tn.banque.softib.repository.IBanqueRepository;
import tn.banque.softib.repository.IClientRepository;
import tn.banque.softib.repository.ICompteRepository;
@Service
public class ClientServices implements IClientServices {
	private static final Logger l = LogManager.getLogger(SoftIBApplicationTests.class);
	@Autowired
	IClientRepository clientRepository;
	@Autowired
	ICompteRepository compteRepository;
	@Autowired
	IBanqueRepository banqueRepository;
	@Autowired
	IAgentRepository agentRepo;

	@Override
	public Client modifierClient(String id) {
		Client cl = clientRepository.findById(id).get();
		return clientRepository.save(cl);
	}

	@Override
	public Set<Client> listClientParAgence(long idA) {
		return clientRepository.listeClientsParAgence(idA);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Client ajouterEtAffecterClientACompteEtAgent(String identifiant, String nom, String prenom, Date dateNaissance, String adresse, String telephone,
			String email, String fonction, TypeContratTravail typeCT, EtatCivil etatCivil, String nomConjoint,
			String cINConjoint, String fonctionConjoint, int nbrEnfants, double revenuBrut, TypeClient type, String av, TypeCompte typeCompte, String codeAgent) {
		//if(isValid)
		Client c = new Client();
		c.setIdentifiant(identifiant);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setDateNaissance(dateNaissance);
		c.setAdresse(adresse);
		c.setTelephone(telephone);
		c.setEmail(email);
		c.setFonction(fonction);
		c.setTypeCT(typeCT);
		c.setEtatCivil(etatCivil);
		c.setNom(nomConjoint);
		c.setCINConjoint(cINConjoint);
		c.setFonctionConjoint(fonctionConjoint);
		c.setNbrEnfants(nbrEnfants);
		c.setRevenuBrut(revenuBrut);
		c.setType(type);
		clientRepository.save(c);
		String idCompte = identifiant+=new Date().getDay()+new Date().getMonth()+new Date().getYear()+"/"+ type;
		Compte comp1 = new Compte(idCompte);
		comp1.setDateCreation(new Date());
		comp1.setAvantage(av);
		comp1.setType(typeCompte);
		comp1.setClient(c);
		compteRepository.save(comp1);
		Agent ag =agentRepo.findById(codeAgent).get();
		if(ag.getNbClients()<50){
		ag.getClients().add(c);
		ag.setNbClients(ag.getNbClients()+1);
		agentRepo.save(ag);
		}else{
			l.error("Vous ne pouvez pas affecter ce client à cet agent! veuillez réessayer avec un autre agent SVP");
		}
		return c;
		
	}

	@Override
	public void affecterBanqueACompte(long idB, String idC) {
		Banque b = banqueRepository.findById(idB).get();
		Compte c = compteRepository.findById(idC).get();
		c.setBanque(b);
		compteRepository.save(c);
		
		
	}

}
