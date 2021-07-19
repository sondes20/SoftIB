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
	IClientServices clientService;
	@Autowired
	IOperationService opeSer;
	@Autowired
	ICompteService compteService;

	private static final Logger l = LogManager.getLogger(SoftIBApplicationTests.class);

	@Test
	public void contextLoads() throws ParseException{
		/*Banque b = new Banque("Banque d'habitat", "71778441", "Cité Mohamed El Khames, Tunis 1000");
		banqueService.ajouterBanque(b);*/
		
		/*Agence ag1 = new Agence("Agence BH Kef", "Cité Ahmed Amara, Kef 7100", "Darraji Feten", "78225114");
		Agence ag2 = new Agence("Agence BH Béja", "El Mzara, Béja 9000", "Lahouani Sondes", "78002336");
		Agence ag3 = new Agence("Agence BH Jandouba", "Cité Farhat Hached, Jandouba 8000", "Dardouri Zohra", "78226889");
		Agence ag4 = new Agence("Agence BH Seliana", "Cité Mokhtar Atia, Seliana 6000", "Ghribi Afef", "78224789");
		Agence ag5 = new Agence("Agence BH Bizerte", "Cité Habib Bourguiba, Bizerte 8100", "Ghribi Wided", "72586235");
		agenceService.ajouterAgence(ag1);
		agenceService.ajouterAgence(ag2);
		agenceService.ajouterAgence(ag3);
		agenceService.ajouterAgence(ag4);
		agenceService.ajouterAgence(ag5);*/
		
		/*agenceService.affecterBanqueAAgence(1, 1);
		agenceService.affecterBanqueAAgence(1, 2);
		agenceService.affecterBanqueAAgence(1, 3);
		agenceService.affecterBanqueAAgence(1, 4);
		agenceService.affecterBanqueAAgence(1, 5);*/
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		/*Date d1 = date.parse("1983-05-07");
		Client c1 = new Client("07002150", "Cherni", "Houssem", d1, "Kef", "55255411", "chernihoussem@gmail.com", "Enseignant", TypeContratTravail.CDI, EtatCivil.CELIBATAIRE, "", "", "", 0, 10000, TypeClient.PHYSIQUE);
		clientService.ajouterClient(c1);
		*/
		
		//clientService.ajouterEtAffecterClientACompte("07002150", "abc", TypeCompte.COURANT);
		//clientService.ajouterEtAffecterClientACompte("08061621", "abc", TypeCompte.EPARGNE);
		//compteService.modifierCompte("08061621/PHYSIQUE", "abc", TypeCompte.EPARGNE);
		//clientService.affecterBanqueACompte(1, "07002150/PHYSIQUE");
		Date d = date.parse(LocalDate.now().toString());
		//Operation op4 = new Operation(TypeOperation.OUVERTUREDUCOMPTE, SensOperation.CREDIT, d, 1300, compteService.getCompte("07002150/PHYSIQUE"), 0);
		//Operation op3 = new Operation(TypeOperation.RETRAIT, SensOperation.DEBIT, d, 100, compteService.getCompte("08061621/PHYSIQUE"), opeSer.getSoldeByNumCompte("08061621/PHYSIQUE"));
		//opeSer.ajouterOperation(op4);
		
		
		//Operation op5 = new Operation(TypeOperation.VIREMENT, SensOperation.DEBIT, d, 200, compteService.getCompte("08061621/PHYSIQUE"), compteService.getCompte("07002150/PHYSIQUE"));
		//opeSer.calculerSoldeVirement(op5.getMontant(), op5.getCompte().getNCompte(), op5.getCompte().getNCompte());
		
		//l.info(opeSer.getSoldeByNumCompte("08061621/PHYSIQUE"));
		
		
	
	}

	public static Logger getL() {
		return l;
	}

}
