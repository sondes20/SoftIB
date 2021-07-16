package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false)
	private String reference;
	private double montant;
	@Temporal(TemporalType.DATE)
	private Date dateDePaiement;
	private String nomBeneficiaire;
	@ManyToOne
	private Client client;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String reference, double montant, Date dateDePaiement, String nomBeneficiaire, Client client) {
		super();
		this.reference = reference;
		this.montant = montant;
		this.dateDePaiement = dateDePaiement;
		this.nomBeneficiaire = nomBeneficiaire;
		this.client = client;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateDePaiement() {
		return dateDePaiement;
	}
	public void setDateDePaiement(Date dateDePaiement) {
		this.dateDePaiement = dateDePaiement;
	}
	public String getNomBeneficiaire() {
		return nomBeneficiaire;
	}
	public void setNomBeneficiaire(String nomBeneficiaire) {
		this.nomBeneficiaire = nomBeneficiaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Facture [reference=" + reference + ", montant=" + montant + ", dateDePaiement=" + dateDePaiement
				+ ", nomBeneficiaire=" + nomBeneficiaire + ", client=" + client + "]";
	}
	

}
