package tn.banque.softib.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.repository.ICompteRepository;
@Service
public class CompteService implements ICompteService {
	@Autowired
	ICompteRepository compteRepo;

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

	
}
