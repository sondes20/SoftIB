package tn.banque.softib.services;


import java.util.List;

import tn.banque.softib.entity.Credit;
import tn.banque.softib.entity.DemandeCredit;
import tn.banque.softib.entity.TMM;
import tn.banque.softib.entity.TypeCompte;

public interface ICreditService {
	
	public DemandeCredit ajouterDemandeCredit(TypeCompte type, DemandeCredit demandeCredit);
	
	public void ajouterEtAffecterCreditAClient(long idDemandeCredit, Credit credit, boolean isAccepted);
	
	public double SommeCreditClients();
	
	public List<TMM> getTMM();

}
