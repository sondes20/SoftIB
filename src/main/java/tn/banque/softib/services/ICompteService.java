package tn.banque.softib.services;

import java.util.List;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeOperation;

public interface ICompteService {
	
	public Compte getCompte(String id);
	public Compte modifierCompte(String ic, String av, TypeCompte type);
	public long getNombreComptesParType(TypeCompte type);
	public List<Compte> getCompteEpargne();
	public List<Compte> getCompteCourant();
	public List<Operation> getListOperationsDebitDuCompteEpargneParAnnee(int annee);
	public List<Operation> getListOperationsDebitDuCompteCourantParAnnee(int annee);
	public double getCADebiteurCompte(int annee, String numCp);
	public double getCACrediteurCompte(int annee, String numCp);
	
	public List<Double> getListCACompteCourantDebiteurParAnnee(int annee);
	//public List<Operation> getOperationParCompteEtType(String numCompte, TypeOperation type);

	public long ajouterChiffreAffaireDebit(int annee, String numCpt, SensOperation sens);
	public long ajouterChiffreAffaireCredit(int annee, String numCpt, SensOperation sens);
}
