package tn.banque.softib.services;

import java.util.Set;

import tn.banque.softib.entity.Banque;

public interface IBanqueServices {
	
	public Banque ajouterBanque(Banque banque);
	public Banque modifierBanque(long id);
	public Set<Banque> afficherBanques();

}
