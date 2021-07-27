package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@DiscriminatorValue(value="inscription")
@Entity
public class DemandeInscription extends Demande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateNaissance;
	private String adresse;
	private String telephone;
	private String email;
	private String nom;
	private String prenom;
	private String fonction;
	@Enumerated(EnumType.STRING)
	private TypeClient type;
	public DemandeInscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DemandeInscription(boolean isAccepted, String cin) {
		super(isAccepted, cin);
		// TODO Auto-generated constructor stub
	}

	
	public DemandeInscription(String cin, Date dateNaissance, String adresse, String telephone, String email,
			String nom, String prenom, String fonction, TypeClient type) {
		super();
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.type = type;
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

	@Override
	public String toString() {
		return "DemandeInscription [cin=" + cin + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom
				+ ", fonction=" + fonction + ", type=" + type + "]";
	}

	
	
}
