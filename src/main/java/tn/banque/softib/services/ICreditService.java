package tn.banque.softib.services;


import java.io.IOException;
import java.util.List;

import javax.lang.model.element.Element;

import tn.banque.softib.entity.Credit;
import tn.banque.softib.entity.DemandeCredit;
import tn.banque.softib.entity.TMM;
import tn.banque.softib.entity.TypeCompte;

public interface ICreditService {
	
	public DemandeCredit ajouterDemandeCredit(TypeCompte type, DemandeCredit demandeCredit);
	
	public void ajouterEtAffecterCreditAClient(long idDemandeCredit, Credit credit, boolean isAccepted);
	
	public double SommeCreditClients(long id);
	
	public TMM ajouterTMM() throws IOException;
	
	public List<TMM> getTMM();
	

}
