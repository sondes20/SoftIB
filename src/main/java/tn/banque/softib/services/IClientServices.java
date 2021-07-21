package tn.banque.softib.services;

import java.util.Date;
import java.util.Set;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.EtatCivil;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeContratTravail;

public interface IClientServices {
	
	//public Client ajouterClient(Client client);
	public Client modifierClient(String id);
	public Set<Client> listClientParAgence(long idA);
	//public void ajouterEtAffecterClientACompte(String idC, String av, TypeCompte type);
	public void affecterBanqueACompte(long idB, String idC);
	//public Client affecterClientAAgent(String codeAg, String codeClient);
	public Client ajouterEtAffecterClientACompteEtAgent(String identifiant, String nom, String prenom, Date dateNaissance, String adresse, String telephone,
			String email, String fonction, TypeContratTravail typeCT, EtatCivil etatCivil, String nomConjoint,
			String cINConjoint, String fonctionConjoint, int nbrEnfants, double revenuBrut, TypeClient type, String av, TypeCompte typeCompte, String codeAgent);


}
