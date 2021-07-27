package tn.banque.softib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.TypeCompte;
@Repository
public interface ICompteRepository extends CrudRepository<Compte, String> {
	
	@Query("select count(c) from Compte c where typeCompte=:typeCpt and c.agence=:agence")
	public long findCountCompteByTypeAndAgence(@Param("typeCpt") TypeCompte type, @Param("agence") Agence agence);
	
	@Query("select c from Compte c where typeCompte=:EPARGNE")
	public List<Compte> findCompteEpargne(@Param("EPARGNE") TypeCompte type);
	
	@Query("select c from Compte c where typeCompte=:COURANT")
	public List<Compte> findCompteCourant(@Param("COURANT") TypeCompte type);
	
	@Query("select c.solde from Compte c where c.NCompte=:numcpt")
	public double findSoldeByCompte(@Param("numcpt") String numcpt);
	public List<Compte> findByTypeCompte(TypeCompte type);
	
	@Query("select avg(c.solde) from Compte c")
	public double findAVGFromSolde();
	
	@Query("select c.NCompte from Compte c where c.typeCompte=:typec order by c.solde desc")
	public List<String> getComptePlusCrediteurByOrdreDescAndAnnee(@Param("typec") TypeCompte type);
	
	@Query("select c.NCompte from Compte c where c.typeCompte=:typec order by c.solde asc")
	public List<String> getComptePlusDebiteurByOrdreDescAndAnnee(@Param("typec") TypeCompte type);
	
}
