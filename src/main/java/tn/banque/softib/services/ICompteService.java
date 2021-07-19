package tn.banque.softib.services;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;

public interface ICompteService {
	
	public Compte getCompte(String id);
	public Compte modifierCompte(String ic, String av, TypeCompte type);

}
