package tn.banque.softib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Banque;

@Repository
public interface IBanqueRepository extends CrudRepository<Banque, Long>{

}
