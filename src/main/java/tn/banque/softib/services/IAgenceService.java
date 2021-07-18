package tn.banque.softib.services;

import java.util.Set;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Banque;

public interface IAgenceService {
	
	public Agence ajouterAgence(Agence agence);
	public Agence modifierAgence(long id);
	public Set<Agence> afficherParBanque(Banque banque);
	public void affecterBanqueAAgence(long idB, long idA);

}
