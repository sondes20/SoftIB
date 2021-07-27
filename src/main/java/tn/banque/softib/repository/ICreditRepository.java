package tn.banque.softib.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.banque.softib.entity.Credit;
@Repository
public interface ICreditRepository extends CrudRepository<Credit, Long> {
	
	@Query("select sum(cr.montant) from Credit cr") 
	public double findSumCreditClients();

}
