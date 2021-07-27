package tn.banque.softib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.banque.softib.entity.Agent;
@Repository
public interface IAgentRepository extends CrudRepository<Agent, String>{

}
