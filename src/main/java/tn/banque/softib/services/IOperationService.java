package tn.banque.softib.services;

import java.util.Date;
import java.util.Set;
import java.util.List;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeOperation;

public interface IOperationService {
	
	public Compte verser(TypeOperation type, String numCompte, String idAgent, double montant);
	public Compte retrait(TypeOperation type, String numCompte, String idAgent, double montant);
	public Set<Compte> virement(TypeOperation type, String numCptUser, String numCptBenef, String idAgent, double montant);
	public Agent getAgentById(String id);
	//public Double getMoyOperationParJour(SensOperation sens, Date date);
	public void archiverListOperationsParJour();
	public double getSoldeByNumCompte(String idcpt);
	public List<Operation> getAllOperationsParCompteAndPeriode(String idCompte, int mois, int annee);
}
