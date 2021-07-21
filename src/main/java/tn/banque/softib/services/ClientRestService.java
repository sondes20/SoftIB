package tn.banque.softib.services;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.EtatCivil;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeContratTravail;

@RestController
public class ClientRestService {
	@Autowired
	ClientServices clientServices;
    
	
	
    @PutMapping("/modifierclient")
	public Client modifierClient(String id) {
		return clientServices.modifierClient(id);
	}
    @PostMapping("/ajouterclient")
	public Client ajouterEtAffecterClientACompteEtAgent(String identifiant, String nom, String prenom,
			Date dateNaissance, String adresse, String telephone, String email, String fonction,
			TypeContratTravail typeCT, EtatCivil etatCivil, String nomConjoint, String cINConjoint,
			String fonctionConjoint, int nbrEnfants, double revenuBrut, TypeClient type, String av,
			TypeCompte typeCompte, String codeAgent) {
		return clientServices.ajouterEtAffecterClientACompteEtAgent(identifiant, nom, prenom, dateNaissance, adresse,
				telephone, email, fonction, typeCT, etatCivil, nomConjoint, cINConjoint, fonctionConjoint, nbrEnfants,
				revenuBrut, type, av, typeCompte, codeAgent);
	}

	public Set<Client> listClientParAgence(long idA) {
		return clientServices.listClientParAgence(idA);
	}

	public void affecterBanqueACompte(long idB, String idC) {
		clientServices.affecterBanqueACompte(idB, idC);
	}

}
