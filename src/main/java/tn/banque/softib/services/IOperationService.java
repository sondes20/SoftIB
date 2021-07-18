package tn.banque.softib.services;

import java.text.ParseException;


import tn.banque.softib.entity.Operation;

public interface IOperationService {
	
	public long ajouterOperation(Operation operation);
	public long modifierOperation(long idOp);//accee pour l'admin seulement
	public double getSoldeByNumCompte(String numCompte);
	public double calculerSoldeRetrait(double montant, String numCompte);
	public double calculerSoldeOuvertureDeCompte(double montant, String numCompte);
	public double calculerSoldeVirement(double montant, String numCompteUsagers, String numCompteBeneficiaire) throws ParseException;

}
