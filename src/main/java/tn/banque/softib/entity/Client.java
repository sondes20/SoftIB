package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false, nullable=false)
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
	private TypeClient type;
	@OneToMany(mappedBy="client", cascade={CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Compte> comptes;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Facture> factures;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Intervention_Client> interventionsclient;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Credit> credits;
	@OneToMany
	@JsonIgnore
	private List<Demande> demandes;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String identifiant, String nom, String prenom, Date dateNaissance, String adresse, String telephone,
			String email, String fonction, TypeClient type) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.fonction = fonction;
		this.type = type;
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
	public List<Credit> getCredits() {
		return credits;
	}
	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	@Override
	public String toString() {
		return "Client [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email
				+ ", fonction=" + fonction + ", type=" + type + ", comptes=" + comptes + ", factures=" + factures
				+ ", interventionsclient=" + interventionsclient + ", credits=" + credits + ", demandes=" + demandes
				+ "]";
	}
	
}