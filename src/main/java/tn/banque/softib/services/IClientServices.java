package tn.banque.softib.services;

import java.util.Set;

import tn.banque.softib.entity.Client;

public interface IClientServices {
	
	public Client ajouterClient(Client client);
	public Client modifierClient(String id);
	public Set<Client> listClientParAgence(long idA);
	public void ajouterEtAffecterClientACompte(String idC);
	public void affecterBanqueACompte(long idB, String idC);

}
