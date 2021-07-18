package tn.banque.softib.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.softib.entity.Client;

@RestController
public class ClientRestService {
	@Autowired
	ClientServices clientServices;
    
	@RequestMapping(value="/client", method = RequestMethod.POST)
	public Client ajouterClient(Client client) {
		return clientServices.ajouterClient(client);
	}

	public Client modifierClient(String id) {
		return clientServices.modifierClient(id);
	}

	public Set<Client> listClientParAgence(long idA) {
		return clientServices.listClientParAgence(idA);
	}

	public void ajouterEtAffecterClientACompte(String idC) {
		clientServices.ajouterEtAffecterClientACompte(idC);
	}

	public void affecterBanqueACompte(long idB, String idC) {
		clientServices.affecterBanqueACompte(idB, idC);
	}

}
