package tn.banque.softib.services;

import java.text.ParseException;

import java.util.Set;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.DemandeInscription;


public interface IClientServices {
	
	public DemandeInscription ajouterDemande(DemandeInscription DI);
	public Client modifierClient(String id);
	public Set<Client> listClientParAgence(long idA);
	public Client ajouterEtAffecterClientACompteEtAgentEtAgence(long idDemande, Compte compte, String codeAgent, long idAgence);
}
