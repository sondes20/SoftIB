package tn.banque.softib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Operation;
@Repository
public interface IOperationRepository extends CrudRepository<Operation, Long> {
	
}
