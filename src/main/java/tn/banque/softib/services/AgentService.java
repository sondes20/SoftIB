package tn.banque.softib.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.repository.IAgentRepository;
import tn.banque.softib.repository.IClientRepository;
import tn.banque.softib.repository.ICompteRepository;
import tn.banque.softib.repository.IOperationRepository;
@Service
public class AgentService implements IAgentService {
	
	private static final Logger l = LogManager.getLogger(AgentService.class);
	@Autowired
	IAgentRepository agentRepository;
	@Autowired
	IClientRepository clientRepo;
	@Autowired
	IOperationRepository operationRepo;
	@Autowired
	ICompteRepository compteRepo;

	@Override
	public String ajouterAgent(Agent agent) {
		
		return agentRepository.save(agent).getCode();
	}

	/*@Override
	public void affecterAgentAClient(String idAg, String idClient) {
		Agent ag = agentRepository.findById(idAg).get();
		Client cl = clientRepo.findById(idClient).get();
		ag.getClients().add(cl);
		agentRepository.save(ag);	
	}*/
	
	@Override
	public double getMoyTransactionsByAgence(SensOperation sens, long idag) {
		
		 return operationRepo.findAvergeFromOperationByJour(sens, idag);
		 
		 }

	@Override
	public double getEtatJournalierDesTransaction(long idag) {
		double sumCreit = operationRepo.findSumTransactionsByAgence(SensOperation.CREDIT, idag);
		double sumDebit = operationRepo.findSumTransactionsByAgence(SensOperation.DEBIT, idag);
		
		double etat =sumCreit-sumDebit;
		return etat;
	}
}