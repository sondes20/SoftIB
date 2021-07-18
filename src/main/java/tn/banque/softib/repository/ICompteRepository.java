package tn.banque.softib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Compte;
@Repository
public interface ICompteRepository extends CrudRepository<Compte, String> {
	

}
