package tn.banque.softib.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.banque.softib.entity.Client;
@Repository
public interface IClientRepository extends CrudRepository<Client, String> {
	
	@Query("select c from Client c join c.comptes comp join comp.banque b join b.agences a where a.id=:idA ")
	public Set<Client> listeClientsParAgence(@Param("idA") long idA);

}
