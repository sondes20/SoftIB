package tn.banque.softib.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Banque;
import tn.banque.softib.repository.IAgenceRepository;
import tn.banque.softib.repository.IBanqueRepository;
@Service
public class AgenceServices implements IAgenceService {
	@Autowired
	IAgenceRepository agenceRepo;
	
	@Autowired
	IBanqueRepository banqueRepo;

	@Override
	public Agence ajouterAgence(Agence agence) {
		
		return agenceRepo.save(agence);
	}

	@Override
	public Agence modifierAgence(long id) {
		Agence ag = agenceRepo.findById(id).get();
		return agenceRepo.save(ag);
	}

	@Override
	public Set<Agence> afficherParBanque(Banque banque) {
		
		return (Set<Agence>) agenceRepo.findByBanque(banque);
	}

	@Override
	public void affecterBanqueAAgence(long idB, long idA) {
		Banque b = banqueRepo.findById(idB).get();
		Agence a = agenceRepo.findById(idA).get();
		a.setBanque(b);
		agenceRepo.save(a);
		
	}

}
