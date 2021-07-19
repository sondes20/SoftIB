package tn.banque.softib.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.TypeCompte;

@RestController
public class ClientRestService {
	@Autowired
	ClientServices clientServices;
    
	@PostMapping("/ajouterclient")
	public Client ajouterClient(@RequestBody Client client) {
		return clientServices.ajouterClient(client);
	}
    @PutMapping("/modifierclient")
	public Client modifierClient(String id) {
		return clientServices.modifierClient(id);
	}

	public Set<Client> listClientParAgence(long idA) {
		return clientServices.listClientParAgence(idA);
	}


	public void ajouterEtAffecterClientACompte(String idC, String av, TypeCompte type) {
		clientServices.ajouterEtAffecterClientACompte(idC, av, type);
	}
	public void affecterBanqueACompte(long idB, String idC) {
		clientServices.affecterBanqueACompte(idB, idC);
	}

}
