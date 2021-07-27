package tn.banque.softib.services;

import java.util.Date;
import tn.banque.softib.entity.Agent;

public interface IAgentService {
	public String ajouterAgent(Agent agent); 
	public void affecterAgentAClient(String idAg, String idClient);
	public double getSomTransactionsByDate(Date date);
	

}
