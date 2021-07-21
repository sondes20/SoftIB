package tn.banque.softib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeOperation;
@Repository
public interface ICompteRepository extends CrudRepository<Compte, String> {
	
	@Query("select count(c) from Compte c where type=:typeCpt")
	public long findCountCompteByType(@Param("typeCpt") TypeCompte type);
	
	@Query("select c from Compte c where type=:EPARGNE")
	public List<Compte> findCompteEpargne(@Param("EPARGNE") TypeCompte type);
	
	@Query("select c from Compte c where type=:COURANT")
	public List<Compte> findCompteCourant(@Param("COURANT") TypeCompte type);
	
	
	public List<Compte> findByType(TypeCompte type);
	
	@Query("select c from Compte c join c.operations o where  o.sens=:sens and extract(year from o.date)=:annee")
    public List<Compte> findCompteByTypeAndSensOperationAndAnnee(@Param("sens") SensOperation sensop, @Param("annee") String annee);
	

}
