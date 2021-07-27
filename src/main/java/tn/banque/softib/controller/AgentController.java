package tn.banque.softib.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	
	@PostMapping("/addAgence")
	public Agence ajouterAgence(@RequestBody Agence agence) {
		return agenceService.ajouterAgence(agence);
	}

	@PostMapping("/addClientAndAffectToCompteAndAgent/{isAccepted}/{idDemande}/{codeAgent}/{idAgence}")
	public Client ajouterEtAffecterClientACompteEtAgentEtAgence(@PathVariable boolean isAccepted, @PathVariable long idDemande, @RequestBody Compte compte, @PathVariable String codeAgent, @PathVariable long idAgence){
		return clientService.ajouterEtAffecterClientACompteEtAgentEtAgence(isAccepted, idDemande, compte, codeAgent, idAgence);
	}

	@GetMapping("/etatjournalierdestransactions/{date}")
	public double getSomTransactionsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return agentService.getSomTransactionsByDate(date);
	}
    
	@PostMapping("/verser/{type}/{numCompte}/{idAgent}/{montant}")
	public Compte verser(@PathVariable TypeOperation type,@PathVariable String numCompte,@PathVariable String idAgent,@PathVariable double montant) {
		return operationService.verser(type, numCompte, idAgent, montant);
	}

	@PostMapping("/retrait/{type}/{numCompte}/{idAgent}/{montant}")
	public Compte retrait(@PathVariable TypeOperation type,@PathVariable String numCompte,@PathVariable String idAgent,@PathVariable double montant) {
		return operationService.retrait(type, numCompte, idAgent, montant);
	}

	@PostMapping("/transaction/{type}/{numCptUser}/{numCptBenef}/{idAgent}/{montant}")
	public Set<Compte> virement(@PathVariable TypeOperation type,@PathVariable String numCptUser,@PathVariable String numCptBenef,@PathVariable String idAgent, @PathVariable double montant) {
		return operationService.virement(type, numCptUser, numCptBenef, idAgent, montant);
	}
    @GetMapping("/MoyenneTransaction/{sens}/{date}")
	public double getMoyOperationParJour(@PathVariable SensOperation sens,@PathVariable @DateTimeFormat(pattern = ("yyyy-MM-dd")) Date date) {
		return operationService.getMoyOperationParJour(sens, date);
	}
    
    @GetMapping("/getAgent/{id}")
	public Agent getAgentById(@PathVariable String id) {
		return operationService.getAgentById(id);
	}
    
    @GetMapping("getsoldebycompte/{idcpt}")
	public double getSoldeByNumCompte(@PathVariable String idcpt) {
		return operationService.getSoldeByNumCompte(idcpt);
	}
    @PostMapping("/addAgent")
	public String ajouterAgent(@RequestBody Agent agent) {
		return agentService.ajouterAgent(agent);
	}
    
    @GetMapping("/getExtrait/{idCompte}/{mois}")
	public List<Operation> getAllOperationsParCompteAndPeriode(@PathVariable String idCompte, @PathVariable int mois) {
		return operationService.getAllOperationsParCompteAndPeriode(idCompte, mois);
	}
    @PostMapping("/addDemandeInscri")
	public DemandeInscription ajouterDemande(@RequestBody DemandeInscription DI) {
		return clientService.ajouterDemande(DI);
	}
    
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
    
   
	
    
    
	
	
	
	

	

}
