package tn.banque.softib;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.banque.softib.entity.Agence;
import tn.banque.softib.entity.Agent;
import tn.banque.softib.entity.Banque;
import tn.banque.softib.entity.Client;
import tn.banque.softib.entity.Compte;
import tn.banque.softib.entity.EtatCivil;
import tn.banque.softib.entity.Operation;
import tn.banque.softib.entity.SensOperation;
import tn.banque.softib.entity.TypeClient;
import tn.banque.softib.entity.TypeCompte;
import tn.banque.softib.entity.TypeContratTravail;
import tn.banque.softib.entity.TypeOperation;
import tn.banque.softib.services.IAgenceService;
import tn.banque.softib.services.IAgentService;
import tn.banque.softib.services.IBanqueServices;
import tn.banque.softib.services.IClientServices;
import tn.banque.softib.services.ICompteService;
import tn.banque.softib.services.IOperationService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftIBApplicationTests {
	@Autowired
	IBanqueServices banqueService;
	@Autowired
	IAgenceService agenceService;
	@Autowired
	IClientServices clientServices;
	@Autowired
	IOperationService operationServices;
	@Autowired
	ICompteService compteService;
	@Autowired
	IAgentService agentService;

	private static final Logger l = LogManager.getLogger(SoftIBApplicationTests.class);

	@Test
	public void contextLoads() throws ParseException{
		/*Banque b = new Banque("Banque d'habitat", "71778441", "Cité Mohamed El Khames, Tunis 1000");
		banqueService.ajouterBanque(b);
		*/
		/*Agence ag1 = new Agence("Agence BH Kef", "Cité Ahmed Amara, Kef 7100", "Darraji Feten", "78225114");
		Agence ag2 = new Agence("Agence BH Béja", "El Mzara, Béja 9000", "Lahouani Sondes", "78002336");
		Agence ag3 = new Agence("Agence BH Jandouba", "Cité Farhat Hached, Jandouba 8000", "Dardouri Zohra", "78226889");
		Agence ag4 = new Agence("Agence BH Seliana", "Cité Mokhtar Atia, Seliana 6000", "Ghribi Afef", "78224789");
		Agence ag5 = new Agence("Agence BH Bizerte", "Cité Habib Bourguiba, Bizerte 8100", "Ghribi Wided", "72586235");
		agenceService.ajouterAgence(ag1);
		agenceService.ajouterAgence(ag2);
		agenceService.ajouterAgence(ag3);
		agenceService.ajouterAgence(ag4);
		agenceService.ajouterAgence(ag5);
		*/
		/*agenceService.affecterBanqueAAgence(1, 1);
		agenceService.affecterBanqueAAgence(1, 2);
		agenceService.affecterBanqueAAgence(1, 3);
		agenceService.affecterBanqueAAgence(1, 4);
		agenceService.affecterBanqueAAgence(1, 5);*/
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = date.parse("1984-11-20");
		Date d2 = date.parse("1990-08-07");
		Date d3 = date.parse("1986-09-19");
		Date d4 = date.parse("1957-02-02");
		Date d5 = date.parse("1985-05-07");
		/*Client c1 = new Client("08061621", "Lahouani", "Sondes", d1, "Kef", "24071704", "lahouanisondes@gmail.com", "Etudiante", TypeContratTravail.STAGE, EtatCivil.CELIBATAIRE, "", "", "", 0, 0, TypeClient.PHYSIQUE);
		clientServices.ajouterClient(c1);
		Client c2 = new Client("18253669", "Lahouani", "Mohamed", d2, "Kef", "50178996", "lahouanimohamed@gmail.com", "Ouvrier", TypeContratTravail.CDD, EtatCivil.CELIBATAIRE, "", "", "", 0, 8000, TypeClient.PHYSIQUE);
		clientServices.ajouterClient(c2);
		Client c3 = new Client("07225698", "Lahouani", "Ahmed", d3, "Kef", "52552222", "lahouaniahmed@gmail.com", "Ouvrier", TypeContratTravail.CDI, EtatCivil.CELIBATAIRE, "", "", "", 0, 10000, TypeClient.PHYSIQUE);
		clientServices.ajouterClient(c3);
		Client c4 = new Client("03052244", "Lahouani", "Sadok", d4, "Kef", "50225369", "lahouanisadok@gmail.com", "Ouvrier", TypeContratTravail.CDD, EtatCivil.MARIE, "Jaouida", "04225889", "Ouvriere", 3, 6000, TypeClient.PHYSIQUE);
		clientServices.ajouterClient(c4);
		*/
		
		/*clientServices.ajouterEtAffecterClientACompteEtAgent("08061621", "Lahouani", "Sondes", d1, "Kef", "24071704", "lahouanisondes@gmail.com", "Etudiante", TypeContratTravail.STAGE, EtatCivil.CELIBATAIRE, "", "", "", 0, 0, TypeClient.PHYSIQUE, "abc", TypeCompte.EPARGNE, "001");
		clientServices.ajouterEtAffecterClientACompteEtAgent("18253669", "Lahouani", "Mohamed", d2, "Kef", "50178996", "lahouanimohamed@gmail.com", "Ouvrier", TypeContratTravail.CDD, EtatCivil.CELIBATAIRE, "", "", "", 0, 8000, TypeClient.PHYSIQUE, "abc", TypeCompte.EPARGNE, "001");
		clientServices.ajouterEtAffecterClientACompteEtAgent("07225698", "Lahouani", "Ahmed", d3, "Kef", "52552222", "lahouaniahmed@gmail.com", "Ouvrier", TypeContratTravail.CDI, EtatCivil.CELIBATAIRE, "", "", "", 0, 10000, TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, "002");
		clientServices.ajouterEtAffecterClientACompteEtAgent("03052244", "Lahouani", "Sadok", d4, "Kef", "50225369", "lahouanisadok@gmail.com", "Ouvrier", TypeContratTravail.CDD, EtatCivil.MARIE, "Jaouida", "04225889", "Ouvriere", 3, 6000, TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, "002");
		clientServices.ajouterEtAffecterClientACompteEtAgent("08071652", "Cherni", "Houssem", d5, "Kef", "98553057", "lahouanisadok@gmail.com", "Enseigant", TypeContratTravail.CDI, EtatCivil.CELIBATAIRE, "", "", "", 0, 10000, TypeClient.PHYSIQUE, "def", TypeCompte.COURANT, "002");*/
		
		
		/*clientServices.ajouterEtAffecterClientACompte("07002150", "abc", TypeCompte.COURANT);
		clientServices.ajouterEtAffecterClientACompte("08061621", "def", TypeCompte.EPARGNE);
		clientServices.ajouterEtAffecterClientACompte("18253669", "abc", TypeCompte.EPARGNE);
		clientServices.ajouterEtAffecterClientACompte("07225698", "def", TypeCompte.COURANT);
		clientServices.ajouterEtAffecterClientACompte("03052244", "abc", TypeCompte.COURANT);*/
		
		/*l.info(compteService.getNombreComptesParType(TypeCompte.COURANT));
		l.info(compteService.getNombreComptesParType(TypeCompte.EPARGNE));*/
		
	
		//compteService.modifierCompte("08061621/PHYSIQUE", "abc", TypeCompte.EPARGNE);
		//clientServices.affecterBanqueACompte(1, "03052244129/COURANT");
		//Date d = date.parse(LocalDate.now().toString());
		
		/*for(Compte c: compteService.getCompteEpargne()){
		l.info(c.getNCompte());
		}*/
		/*Agent ag1 = new Agent("001", "Ghribi", "Afef");
		Agent ag2 = new Agent("002", "Darraji", "Feten");
		agentService.ajouterAgent(ag1);
		agentService.ajouterAgent(ag2);*/
		
		//operationServices.verser(TypeOperation.VERSEMENT, "08061621129/PHYSIQUE", "001", 700);
		//operationServices.retrait(TypeOperation.RETRAIT, "08061621129/PHYSIQUE", "002", 400);
		//operationServices.virement(TypeOperation.VIREMENT, "08061621129/PHYSIQUE", "03052244129/PHYSIQUE", "001", 150);
		//l.info(operationServices.getAgentById("001").getPrenom());
		//l.info(opeSer.getSoldeByNumCompte("08061621/PHYSIQUE"));
		
		 //l.info(compteService.getListOperationsDebitDuCompteEpargneParAnnee(2021));
			
		//compteService.getListOperationsDebitDuCompteCourantParAnnee(2021);
		
		//l.info(compteService.getCADebiteurCompte(2021, "08061621129/PHYSIQUE"));
		//l.info(compteService.getCACrediteurCompte(2021, "08061621129/PHYSIQUE"));
		//compteService.getListCACompteCourantDebiteurParAnnee(2021);
		
		compteService.ajouterChiffreAffaireDebit(2021, "03052244129/PHYSIQUE", SensOperation.DEBIT);
		//compteService.ajouterChiffreAffaire(2021, "03052244129/PHYSIQUE", SensOperation.CREDIT);
		//compteService.ajouterChiffreAffaire(2021, "07225698129/PHYSIQUE", SensOperation.DEBIT);
		//compteService.ajouterChiffreAffaire(2021, "07225698129/PHYSIQUE", SensOperation.CREDIT);
		
		
		
		
		
	}

	public static Logger getL() {
		return l;
	}

}
