package tn.banque.softib.services;

import java.util.Set;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeOperation;

public interface IOperationService {
	
	public long modifierOperation(long idOp);//accee pour l'admin seulement
	public Compte verser(TypeOperation type, String numCompte, String idAgent, double montant);
	public Compte retrait(TypeOperation type, String numCompte, String idAgent, double montant);
	public Set<Compte> virement(TypeOperation type, String numCptUser, String numCptBenef, String idAgent, double montant);
	
}
