package tn.banque.softib.services;


import java.util.List;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;

public interface ICompteService {
	
	public Compte getCompte(String id);
	public Compte modifierCompte(String ic, String av, TypeCompte type);
	public long getNombreComptesParTypeEtAgence(TypeCompte type, long idAgence);
	public List<Compte> getCompteEpargne();
	public List<Compte> getCompteCourant();
	public List<Agent> getAllAgent();
    
	public List<String> listNumCompteAyantMaxSolde(TypeCompte type);
	
	public List<String> listNumCompteAyantMinSolde(TypeCompte type);
	
	public double avgSolde();
	
}
