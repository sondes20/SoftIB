package tn.banque.softib.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.Credit;
import tn.banque.softib.entity.DemandeCredit;
import tn.banque.softib.entity.DemandeInscription;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeOperation;
import tn.banque.softib.services.IAgenceService;
import tn.banque.softib.services.IAgentService;
import tn.banque.softib.services.IClientServices;
import tn.banque.softib.services.ICreditService;
import tn.banque.softib.services.IOperationService;

@RestController
@RequestMapping("/api/test")
public class AgentController {

	@Autowired
	IOperationService operationService;
	@Autowired
	IAgentService agentService;
	@Autowired
	ICreditService creditService;
	@Autowired
	IClientServices clientService;
	@Autowired
	IAgenceService agenceService;
	
	@PreAuthorize("hasAuthority('AGENT')")
	@GetMapping("/sumCredit/{id}")
	public double SommeCreditClients(@PathVariable long id) {
		return creditService.SommeCreditClients(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addAgence")
	public Agence ajouterAgence(@RequestBody Agence agence) {
		return agenceService.ajouterAgence(agence);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/addClientAndAffectToCompteAndAgent/{idDemande}/{codeAgent}/{idAgence}")
	public Client ajouterEtAffecterClientACompteEtAgentEtAgence(@PathVariable long idDemande, @RequestBody Compte compte, @PathVariable String codeAgent, @PathVariable long idAgence){
		return clientService.ajouterEtAffecterClientACompteEtAgentEtAgence(idDemande, compte, codeAgent, idAgence);
	}
	
	@PreAuthorize("hasAuthority('AGENT')")
	@GetMapping("/getMoyenneTransaction/{sens}/{idag}") 
	public double getMoyTransactionsByDate(@PathVariable SensOperation sens, @PathVariable long idag) {
		return agentService.getMoyTransactionsByAgence(sens, idag);
	}

	@PreAuthorize("hasAuthority('AGENT')")
	@PostMapping("/verser/{type}/{numCompte}/{idAgent}/{montant}")
	public Compte verser(@PathVariable TypeOperation type,@PathVariable String numCompte,@PathVariable String idAgent,@PathVariable double montant) {
		return operationService.verser(type, numCompte, idAgent, montant);
	}
    
	@PreAuthorize("hasAuthority('AGENT')")
	@PostMapping("/retrait/{type}/{numCompte}/{idAgent}/{montant}")
	public Compte retrait(@PathVariable TypeOperation type,@PathVariable String numCompte,@PathVariable String idAgent,@PathVariable double montant) {
		return operationService.retrait(type, numCompte, idAgent, montant);
	}
    
	@PreAuthorize("hasAuthority('AGENT')")
	@PostMapping("/transaction/{type}/{numCptUser}/{numCptBenef}/{idAgent}/{montant}")
	public Set<Compte> virement(@PathVariable TypeOperation type,@PathVariable String numCptUser,@PathVariable String numCptBenef,@PathVariable String idAgent, @PathVariable double montant) {
		return operationService.virement(type, numCptUser, numCptBenef, idAgent, montant);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAgent/{id}")
	public Agent getAgentById(@PathVariable String id) {
		return operationService.getAgentById(id);
	}
    
	@PreAuthorize("hasAuthority('CLIENT')")
    @GetMapping("getsoldebycompte/{idcpt}")
	public double getSoldeByNumCompte(@PathVariable String idcpt) {
		return operationService.getSoldeByNumCompte(idcpt);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addAgent")
	public String ajouterAgent(@RequestBody Agent agent) {
		return agentService.ajouterAgent(agent);
	}
    
	@PreAuthorize("hasAuthority('CLIENT')")
    @GetMapping("/getExtrait/{idCompte}/{mois}/{annee}")
	public List<Operation> getAllOperationsParCompteAndPeriode(@PathVariable String idCompte, @PathVariable int mois, @PathVariable int annee) {
		return operationService.getAllOperationsParCompteAndPeriode(idCompte, mois, annee);
	}
	
	@PreAuthorize("hasAuthority('CLIENT')")
    @PostMapping("/addDemandeInscri")
	public DemandeInscription ajouterDemande(@RequestBody DemandeInscription DI) {
		return clientService.ajouterDemande(DI);
	}
    
	@PreAuthorize("hasAuthority('AGENT')")
    @GetMapping("/getClientsAgence/{idA}")
	public Set<Client> listClientParAgence(@PathVariable long idA) {
		return clientService.listClientParAgence(idA);
	}
	
    @PreAuthorize("hasAuthority('AGENT')")
    @PostMapping("/addDemandeCredit/{type}")
	public DemandeCredit ajouterDemandeCredit(@PathVariable TypeCompte type, @RequestBody DemandeCredit demandeCredit) {
		return creditService.ajouterDemandeCredit(type, demandeCredit);
	}
    
    @PreAuthorize("hasAuthority('AGENT')")
    @PostMapping("/addCreditAClient/{idDemandeCredit}/{isAccepted}")
	public void ajouterEtAffecterCreditAClient(@PathVariable long idDemandeCredit,@RequestBody Credit credit,@PathVariable boolean isAccepted) {
		creditService.ajouterEtAffecterCreditAClient(idDemandeCredit, credit, isAccepted);
	}
    
    @PreAuthorize("hasAuthority('AGENT')")
    @GetMapping("/getEtatJournalier/{idag}")
    @Scheduled(cron="0 0 9 * * *")
	public double getEtatJournalierDesTransaction(@PathVariable long idag) {
		return agentService.getEtatJournalierDesTransaction(idag);
	}
    
   
	
    
    
	
	
	
	

	

}
