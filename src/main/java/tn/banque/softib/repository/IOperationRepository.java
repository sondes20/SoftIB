package tn.banque.softib.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Operation;
@Repository
public interface IOperationRepository extends CrudRepository<Operation, Long> {
	
	public double findSoldeById(String numCompte);
	@Query("select o.solde from Operation o join o.compte c where c.id=:numCompte")
	public double findSoldeByCompte(@Param("numCompte") String numCompte);

}
