package tn.banque.softib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.banque.softib.entity.DemandeInscription;

@Repository
public interface IDemandeInscriptionRepository extends CrudRepository<DemandeInscription, Long>{

}
