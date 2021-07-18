package tn.banque.softib.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.SoftIBApplicationTests;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeOperation;
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
	IOperationService opService;

	@Override
	public long ajouterOperation(Operation operation) {
		
		if(operation.getType().equals(TypeOperation.OUVERTUREDUCOMPTE)){
			operation.setSolde(opService.calculerSoldeOuvertureDeCompte(operation.getMontant(), operation.getCompte().getNCompte()));
			operationRepo.save(operation);
		}else if(operation.getType().equals(TypeOperation.RETRAIT)){
			operation.setSolde(opService.calculerSoldeRetrait(operation.getMontant(), operation.getCompte().getNCompte()));
			operationRepo.save(operation);
		}
		return operationRepo.save(operation).getId();
	}

	@Override
	public long modifierOperation(long idOp) {
		
		return (operationRepo.save(operationRepo.findById(idOp).get())).getId();
		
	}
	

	@Override
	public double calculerSoldeRetrait(double montant, String numCompte) {
		double solde = operationRepo.findSoldeByCompte(numCompte);
		solde-=montant;
		return solde;
	}

	@Override
	public double calculerSoldeOuvertureDeCompte(double montant, String numCompte) {
		double solde=0;
		solde+=montant;
		return solde;
	}

	@Override
	public double calculerSoldeVirement(double montant, String numCompteUsagers, String numCompteBeneficiaire) throws ParseException{
		double soldeUser = opService.getSoldeByNumCompte(numCompteUsagers);
		l.info(soldeUser);
		double soldeBenef = opService.getSoldeByNumCompte(numCompteBeneficiaire);
		l.info(soldeBenef);
		soldeUser-=montant;
		soldeBenef +=montant;
		l.info(soldeUser);
		l.info(soldeBenef);
		return soldeUser;
	}

	@Override
	public double getSoldeByNumCompte(String numCompte) {
		
		return operationRepo.findSoldeByCompte(numCompte);
	}


	

}
