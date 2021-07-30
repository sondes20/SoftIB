package tn.banque.softib.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.repository.IAgenceRepository;
import tn.banque.softib.repository.IAgentRepository;
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
    IAgentRepository agentRepo;
    @Autowired
    IAgenceRepository agenceRepo;
	@Override
	public Compte getCompte(String id) {
		
		return compteRepo.findById(id).get();
	}

	@Override
	public Compte modifierCompte(String ic, String av, TypeCompte type) {
		Compte c = compteRepo.findById(ic).get();
		c.setAvantage(av);
		c.setTypeCompte(type);
		return compteRepo.save(c);
	}

	@Override
	public long getNombreComptesParTypeEtAgence(TypeCompte type, long idAgence) {
		Agence ag = agenceRepo.findById(idAgence).get();
		return compteRepo.findCountCompteByTypeAndAgence(type, ag);
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
	public double avgSolde() {
		
		return compteRepo.findAVGFromSolde();
	}

	@Override
	public List<String> listNumCompteAyantMaxSolde(TypeCompte type) {
		
		return compteRepo.getComptePlusCrediteurByOrdreDescAndAnnee(type);
	}

	@Override
	public List<String> listNumCompteAyantMinSolde(TypeCompte type) {
		
		return compteRepo.getComptePlusDebiteurByOrdreDescAndAnnee(type);
	}

	@Override
	public List<Agent> getAllAgent() {
		
		return (List<Agent>) agentRepo.findAll();
	}
}