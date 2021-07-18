package tn.banque.softib.services;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.banque.softib.entity.Banque;
import tn.banque.softib.repository.IBanqueRepository;

@Service
public class BanqueServices implements IBanqueServices{
	
	private static final Logger l = LogManager.getLogger(BanqueServices.class);
	
	@Autowired
	IBanqueRepository banqueRepo;

	@Override
	public Banque ajouterBanque(Banque banque) {
		if(banque.getTelephone().matches("\\d{8}|\\{11}")){
		return banqueRepo.save(banque);
		}else{
			l.error("Numéro de téléphone invalide");
		}
		return null;
	}

	@Override
	public Set<Banque> afficherBanques() {
		
		return (Set<Banque>)banqueRepo.findAll();
	}

	public static Logger getL() {
		return l;
	}

	@Override
	public Banque modifierBanque(long id) {
		Banque b = banqueRepo.findById(id).get();
		return banqueRepo.save(b);
	}

}
