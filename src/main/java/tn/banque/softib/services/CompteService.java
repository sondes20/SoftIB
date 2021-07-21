package tn.banque.softib.services;


import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.ChiffreAffaire;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.repository.IChiffreAffaireRepository;
import tn.banque.softib.repository.ICompteRepository;
import tn.banque.softib.repository.IOperationRepository;
@Service
public class CompteService implements ICompteService {
	private static final Logger l = LogManager.getLogger(CompteService.class);
	@Autowired
	ICompteRepository compteRepo;
	@Autowired
	IOperationRepository operationRepo;
    @Autowired
    IChiffreAffaireRepository chiffreAffaireRepo;
	@Override
	public Compte getCompte(String id) {
		
		return compteRepo.findById(id).get();
	}

	@Override
	public Compte modifierCompte(String ic, String av, TypeCompte type) {
		Compte c = compteRepo.findById(ic).get();
		c.setAvantage(av);
		c.setType(type);
		return compteRepo.save(c);
	}

	@Override
	public long getNombreComptesParType(TypeCompte type) {
		
		return compteRepo.findCountCompteByType(type);
	}

	@Override
	public List<Compte> getCompteEpargne() {
		
		return compteRepo.findCompteEpargne(TypeCompte.EPARGNE);
	}

	@Override
	public List<Compte> getCompteCourant() {
		
		return compteRepo.findCompteCourant(TypeCompte.COURANT);
	}

	@Override
	public List<Operation> getListOperationsDebitDuCompteEpargneParAnnee(int annee) {
		List<Operation> opDebit = operationRepo.findListOperationsBySensAndTypeCompteAndAnnee(SensOperation.DEBIT, TypeCompte.EPARGNE, annee);
		for(Operation o: opDebit)
			l.info(o);
			
		return opDebit;
	}

	@Override
	public List<Operation> getListOperationsDebitDuCompteCourantParAnnee(int annee) {
		List<Operation> opDebit = operationRepo.findListOperationsBySensAndTypeCompteAndAnnee(SensOperation.DEBIT, TypeCompte.COURANT, annee);
		for(Operation o: opDebit){
			l.info(o);
		}
		return opDebit;
	}

	@Override
	public double getCADebiteurCompte(int annee, String numCp) {
		Compte cp = compteRepo.findById(numCp).get();
		return operationRepo.findCAByCompte(SensOperation.DEBIT, cp, annee);
		
	}
	
	

	@Override
	public List<Double> getListCACompteCourantDebiteurParAnnee(int annee) {
		List<Double> CA = new ArrayList<>();
		List<Compte> comptes = getCompteCourant();
		for(Compte c : comptes){
				double ca = getCADebiteurCompte(annee, c.getNCompte());
				CA.add(ca);
				Collections.sort(CA, Collections.reverseOrder());
				l.info(CA);	
			
		}
		return CA;
		
	}

	@Override
	public long ajouterChiffreAffaireDebit(int annee, String numCpt, SensOperation sens) {
		ChiffreAffaire chiffre = new ChiffreAffaire();
		chiffre.setSens(SensOperation.DEBIT);
			chiffre.setAnnee(annee);
			chiffre.setCompte(compteRepo.findById(numCpt).get());
			chiffre.setMontant(getCADebiteurCompte(annee, numCpt));
			return chiffreAffaireRepo.save(chiffre).getId();
		}

	@Override
	public double getCACrediteurCompte(int annee, String numCp) {
		Compte cp = compteRepo.findById(numCp).get();
		return operationRepo.findCAByCompte(SensOperation.CREDIT, cp, annee);
		
	}

	@Override
	public long ajouterChiffreAffaireCredit(int annee, String numCpt, SensOperation sens) {
		ChiffreAffaire chiffre = new ChiffreAffaire();
		chiffre.setSens(SensOperation.CREDIT);
		chiffre.setAnnee(annee);
		chiffre.setCompte(compteRepo.findById(numCpt).get());
		chiffre.setMontant(getCACrediteurCompte(annee, numCpt));
		return chiffreAffaireRepo.save(chiffre).getId();
	}
	 
	
	
		
	
}
