package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false)
	private String identifiant; //CIN/PASSEPORT
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String adresse;
	private String telephone;
	private String email;
	private String fonction;
	@Enumerated(EnumType.STRING)
	private TypeContratTravail typeCT;
	@Enumerated(EnumType.STRING)
	private EtatCivil etatCivil;
	private String nomConjoint;
	private String CINConjoint;
	private String fonctionConjoint;
	private int nbrEnfants;
	private double revenuBrut;
	@Enumerated(EnumType.STRING)
	private TypeClient type;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Compte> comptes;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Facture> factures;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Intervention_Client> interventionsclient;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Credit> credits;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Intervention_Client> interventions;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String identifiant, String nom, String prenom, Date dateNaissance, String adresse, String telephone,
			String email, String fonction, TypeContratTravail typeCT, EtatCivil etatCivil, String nomConjoint,
			String cINConjoint, String fonctionConjoint, int nbrEnfants, double revenuBrut, TypeClient type,
			List<Compte> comptes, List<Facture> factures, List<Intervention_Client> interventionsclient) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.fonction = fonction;
		this.typeCT = typeCT;
		this.etatCivil = etatCivil;
		this.nomConjoint = nomConjoint;
		CINConjoint = cINConjoint;
		this.fonctionConjoint = fonctionConjoint;
		this.nbrEnfants = nbrEnfants;
		this.revenuBrut = revenuBrut;
		this.type = type;
		this.comptes = comptes;
		this.factures = factures;
		this.interventionsclient = interventionsclient;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public TypeContratTravail getTypeCT() {
		return typeCT;
	}
	public void setTypeCT(TypeContratTravail typeCT) {
		this.typeCT = typeCT;
	}
	public EtatCivil getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(EtatCivil etatCivil) {
		this.etatCivil = etatCivil;
	}
	public String getNomConjoint() {
		return nomConjoint;
	}
	public void setNomConjoint(String nomConjoint) {
		this.nomConjoint = nomConjoint;
	}
	public String getCINConjoint() {
		return CINConjoint;
	}
	public void setCINConjoint(String cINConjoint) {
		CINConjoint = cINConjoint;
	}
	public String getFonctionConjoint() {
		return fonctionConjoint;
	}
	public void setFonctionConjoint(String fonctionConjoint) {
		this.fonctionConjoint = fonctionConjoint;
	}
	public int getNbrEnfants() {
		return nbrEnfants;
	}
	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}
	public double getRevenuBrut() {
		return revenuBrut;
	}
	public void setRevenuBrut(double revenuBrut) {
		this.revenuBrut = revenuBrut;
	}
	public TypeClient getType() {
		return type;
	}
	public void setType(TypeClient type) {
		this.type = type;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public List<Intervention_Client> getInterventionsclient() {
		return interventionsclient;
	}
	public void setInterventionsclient(List<Intervention_Client> interventionsclient) {
		this.interventionsclient = interventionsclient;
	}
	@Override
	public String toString() {
		return "Client [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email
				+ ", fonction=" + fonction + ", typeCT=" + typeCT + ", etatCivil=" + etatCivil + ", nomConjoint="
				+ nomConjoint + ", CINConjoint=" + CINConjoint + ", fonctionConjoint=" + fonctionConjoint
				+ ", nbrEnfants=" + nbrEnfants + ", revenuBrut=" + revenuBrut + ", type=" + type + ", comptes="
				+ comptes + ", factures=" + factures + " , interventionsclient="
				+ interventionsclient + "]";
	}
	

}
