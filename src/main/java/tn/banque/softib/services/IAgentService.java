package tn.banque.softib.services;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.SensOperation;

public interface IAgentService {
	public String ajouterAgent(Agent agent); 
	//public void affecterAgentAClient(String idAg, String idClient);
	public double getMoyTransactionsByAgence(SensOperation sens, long idagence);
	public double getEtatJournalierDesTransaction(long idagence);
	

}
