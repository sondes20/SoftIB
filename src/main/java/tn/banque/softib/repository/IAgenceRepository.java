package tn.banque.softib.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Banque;

@Repository
public interface IAgenceRepository extends CrudRepository<Agence, Long>{
	
	public Set<Agence> findByBanque(Banque banque);

}
