package tn.banque.softib.services;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeOperation;
import tn.banque.softib.repository.IAgentRepository;
import tn.banque.softib.repository.ICompteRepository;
import tn.banque.softib.repository.IOperationRepository;

@Service
public class OperationServices implements IOperationService {
	private static final Logger l = LogManager.getLogger(OperationServices.class);
	@Autowired
	IOperationRepository operationRepo;
	@Autowired
	ICompteRepository cmptRepo;
	@Autowired
	IAgentRepository agentRepo;
	
	@Override
	@Transactional
	public Compte verser(TypeOperation type, String numCompte, String idAgent, double montant){
		Compte cp = cmptRepo.findById(numCompte).get();
		Agent ag = agentRepo.findById(idAgent).get();
		Operation op = new Operation();
		op.setType(TypeOperation.VERSEMENT);
		op.setCompte(cp);
		op.setDate(new Date());
		op.setSens(SensOperation.CREDIT);
		op.setMontant(montant);
		op.setAgent(ag);
		operationRepo.save(op);
		cp.setSolde(cp.getSolde()+montant);
		return cp;
	}
	@Override
	@Transactional
	public Compte retrait(TypeOperation type, String numCompte, String idAgent, double montant){
		Compte cp = cmptRepo.findById(numCompte).get();
		if((cp.getTypeCompte().equals(TypeCompte.EPARGNE) && cp.getSolde()<montant) || (cp.getTypeCompte().equals(TypeCompte.COURANT) && cp.getSolde()<montant-1000)){
			l.error("Solde insuffisant!");
		}else{
		Agent ag = agentRepo.findById(idAgent).get();
		Operation op = new Operation();
		op.setType(TypeOperation.RETRAIT);
		op.setCompte(cp);
		op.setDate(new Date());
		op.setSens(SensOperation.DEBIT);
		op.setMontant(montant);
		op.setAgent(ag);
		operationRepo.save(op);
		cp.setSolde(cp.getSolde()-montant);
		l.info("Operation réussi");
		}
		return cp;
	}
	@Override
	@Transactional
	public Set<Compte> virement(TypeOperation type, String numCptUser, String numCptBenef, String idAgent,
			double montant){
		Compte cptUser = retrait(TypeOperation.RETRAIT,  numCptUser, idAgent, montant);
		Compte cptBenef = verser(TypeOperation.VERSEMENT, numCptBenef, idAgent, montant);
		Set<Compte> comptes = new HashSet<>();
		comptes.add(cptUser);
		comptes.add(cptBenef);
		return comptes;
	}
	@Override
	public Agent getAgentById(String id) {
		
		return agentRepo.findById(id).get();
	}
	@Override
	public double getMoyOperationParJour(SensOperation sens, Date date) {
		List<Operation> operations= (List<Operation>) operationRepo.findAll();
		if(operations.isEmpty()){
			l.error("Aucune operation dans cette date");
			return 0;
		}else
			l.info("La moyenne journalier des transaction à cette date est:" + operationRepo.findAvergeFromOperationByJour(sens, date));
 		return operationRepo.findAvergeFromOperationByJour(sens, date);
	}
	@Override
	//@Scheduled(cron="0 0 0 * * *")
	public void archiverListOperationsParJour() {
		operationRepo.deleteAll();
		
		
	}
	
	@Override
	public double getSoldeByNumCompte(String numcpt) {
		
		return cmptRepo.findSoldeByCompte(numcpt);
	}
	
	@Override
	public List<Operation> getAllOperationsParCompteAndPeriode(String idCompte, int mois) {
		Compte compte = cmptRepo.findById(idCompte).get();
		return operationRepo.findByCompteAndPeriod(compte, mois);
	}
	

}
