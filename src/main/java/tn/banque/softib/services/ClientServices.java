package tn.banque.softib.services;

import java.util.Date;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.DemandeInscription;
import tn.banque.softib.repository.IAgenceRepository;
import tn.banque.softib.repository.IAgentRepository;
import tn.banque.softib.repository.IBanqueRepository;
import tn.banque.softib.repository.IClientRepository;
import tn.banque.softib.repository.ICompteRepository;
import tn.banque.softib.repository.IDemandeInscriptionRepository;
@Service
public class ClientServices implements IClientServices {
	private static final Logger l = LogManager.getLogger(ClientServices.class);
	@Autowired
	IClientRepository clientRepository;
	@Autowired
	ICompteRepository compteRepository;
	@Autowired
	IBanqueRepository banqueRepository;
	@Autowired
	IAgentRepository agentRepo;
	@Autowired
	IDemandeInscriptionRepository demandeInscriRepo;
	@Autowired
	IAgenceRepository agenceRepo;

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
	public Client ajouterEtAffecterClientACompteEtAgentEtAgence(boolean isAccepted, long idDemande, Compte compte, String codeAgent, long idAgence){
		//if(isValid)
		Client client = new Client();
		DemandeInscription demandeInscri = demandeInscriRepo.findById(idDemande).get();
		if(isAccepted==true){
		client.setIdentifiant(demandeInscri.getCin());
		client.setDateNaissance(demandeInscri.getDateNaissance());
		client.setAdresse(demandeInscri.getAdresse());
		client.setEmail(demandeInscri.getEmail());
		client.setTelephone(demandeInscri.getTelephone());
		client.setFonction(demandeInscri.getFonction());
		client.setNom(demandeInscri.getNom());
		client.setPrenom(demandeInscri.getPrenom());
		client.setType(demandeInscri.getType());
		clientRepository.save(client);
		String idCompte = demandeInscri.getCin()+new Date().getDay()+new Date().getMonth()+new Date().getYear();
		compte.setDateCreation(new Date());
		compte.setNCompte(idCompte);
		compte.setClient(client);
		Agence agence = agenceRepo.findById(idAgence).get();
		compte.setAgence(agence);
		compteRepository.save(compte);
		Agent ag =agentRepo.findById(codeAgent).get();
		if(ag.getNbClients()<50){
		ag.getClients().add(client);
		ag.setNbClients(ag.getNbClients()+1);
		agentRepo.save(ag);
		}else{
			l.error("Vous ne pouvez pas affecter ce client à cet agent! veuillez réessayer avec un autre agent SVP");
		}
		}else{
			demandeInscriRepo.delete(demandeInscri);
		}
		return client;
		
	}

	@Override
	public DemandeInscription ajouterDemande(DemandeInscription DI) {
		
		return demandeInscriRepo.save(DI);
	}

}
