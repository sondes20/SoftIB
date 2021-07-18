package tn.banque.softib.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Banque;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.repository.IBanqueRepository;
import tn.banque.softib.repository.IClientRepository;
import tn.banque.softib.repository.ICompteRepository;
@Service
public class ClientServices implements IClientServices {
	@Autowired
	IClientRepository clientRepo;
	@Autowired
	ICompteRepository compteRepo;
	@Autowired
	IBanqueRepository banqueRepo;

	@Override
	public Client ajouterClient(Client client) {
		
		return clientRepo.save(client);
	}

	@Override
	public Client modifierClient(String id) {
		Client cl = clientRepo.findById(id).get();
		return clientRepo.save(cl);
	}

	@Override
	public Set<Client> listClientParAgence(long idA) {
		return clientRepo.listeClientsParAgence(idA);
	}

	@Override
	public void ajouterEtAffecterClientACompte(String idC) {
		Client c = clientRepo.findById(idC).get();
		String idCompte = idC+="/"+ c.getType();
		Compte comp1 = new Compte(idCompte);
		comp1.setClient(c);
		compteRepo.save(comp1);
		
	}

	@Override
	public void affecterBanqueACompte(long idB, String idC) {
		Banque b = banqueRepo.findById(idB).get();
		Compte c = compteRepo.findById(idC).get();
		c.setBanque(b);
		compteRepo.save(c);
		
		
	}

}
