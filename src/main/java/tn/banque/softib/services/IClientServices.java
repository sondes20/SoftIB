package tn.banque.softib.services;

import java.util.Set;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.TypeCompte;

public interface IClientServices {
	
	public Client ajouterClient(Client client);
	public Client modifierClient(String id);
	public Set<Client> listClientParAgence(long idA);
	public void ajouterEtAffecterClientACompte(String idC, String av, TypeCompte type);
	public void affecterBanqueACompte(long idB, String idC);


}
