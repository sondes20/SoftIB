package tn.banque.softib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.services.ICompteService;

@RestController
public class CompteController {
	
	@Autowired
	ICompteService compteService;
	//Moyenne des soldes des differents clients
    @RequestMapping("/getAVGSolde")
	public double avgSolde() {
		return compteService.avgSolde();
	}
    
    //Liste des comptes debiteurs
    @GetMapping("/comptesplusDebiteurs/{type}")
	public List<String> listNumCompteAyantMinSolde(@PathVariable TypeCompte type) {
		return compteService.listNumCompteAyantMinSolde(type);
	}
    
    //Liste des comptes crediteur
    @GetMapping("/comptesplusCrediteurs/{type}")
	public List<String> listNumCompteAyantMaxSolde(@PathVariable TypeCompte type) {
		return compteService.listNumCompteAyantMaxSolde(type);
	}
    
    //Nombre des comptes ouverts par type et banque
    @GetMapping("/nbrCompteParTypeEtAgence/{type}/{idA}")
	public long getNombreComptesParTypeEtAgence(@PathVariable TypeCompte type,@PathVariable long idA) {
		return compteService.getNombreComptesParTypeEtAgence(type, idA);
	}
    //update compte
    @PutMapping("/updateCompte/{ic}/{av}/{type}")
	public Compte modifierCompte(@PathVariable String ic, @PathVariable String av,@PathVariable TypeCompte type) {
		return compteService.modifierCompte(ic, av, type);
	}
    
    @GetMapping("/getCompte")
	public Compte getCompte(@PathVariable String id) {
		return compteService.getCompte(id);
	}
    
    @GetMapping("/getCompteEpargne")
	public List<Compte> getCompteEpargne() {
		return compteService.getCompteEpargne();
	}
    
    @GetMapping("/getCompteCourant")
	public List<Compte> getCompteCourant() {
		return compteService.getCompteCourant();
	}
    
    @GetMapping("/getListAgent")
	public List<Agent> getAllAgent() {
		return compteService.getAllAgent();
	}
    
    
    
    
    
    
    
    
    
	

}
