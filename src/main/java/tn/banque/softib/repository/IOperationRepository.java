package tn.banque.softib.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeOperation;
@Repository
public interface IOperationRepository extends CrudRepository<Operation, Long> {
	
	public List<Operation> findByTypeAndCompte(Compte compte, TypeOperation type);
	@Query("select o from Operation o join o.compte c where o.sens=:sens and c.typeCompte=:typeCpt and extract(year from date)=:annee")
	public List<Operation> findListOperationsBySensAndTypeCompteAndAnnee(@Param("sens") SensOperation sens, @Param("typeCpt") TypeCompte type, @Param("annee") int annee);
	
	@Query("select sum(o.montant) from Operation o where o.sens =:sens and o.compte=:cp and extract(year from date)=:annee")
	public double findSomMontantBySensAndAnnee(@Param("sens") SensOperation sens, @Param("cp") Compte compte, @Param("annee") int annee);
	
	@Query("select o from Operation o where o.compte=:compte and extract(month from o.date)=:mois")
	public List<Operation> findByCompteAndPeriod(@Param("compte") Compte compte, @Param("mois") int mois);
	
	public List<Operation> findBySens(SensOperation sens);
	
	@Query("select avg(o.montant) from Operation o where o.date=:date and o.sens=:sens")
	public double findAvergeFromOperationByJour(@Param("sens") SensOperation sens, @Param("date") Date date);
	
	@Query("select sum(o.montant) from Operation o where o.sens=:sensOp and o.date=:date")
	public double findSumTransactionsByDate(@Param("sensOp") SensOperation sens, @Param("date") Date date);

	
}
