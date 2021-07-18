package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	@Enumerated(EnumType.STRING)
	private TypeOperation type;
	@Enumerated(EnumType.STRING)
	private SensOperation sens;
	@Temporal(TemporalType.DATE)
	private Date date;
	private double montant;
	private double solde;
	@ManyToOne
	private Compte compte;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(TypeOperation type, SensOperation sens, Date date, double montant, Compte compte, double solde) {
		super();
		this.type = type;
		this.sens = sens;
		this.date = date;
		this.montant = montant;
		this.compte = compte;
		this.solde = solde;
	}
	
	public Operation(TypeOperation type, SensOperation sens, Date date, double montant, Compte compteuser, Compte compteBnef) {
		super();
		this.type = type;
		this.sens = sens;
		this.date = date;
		this.montant = montant;
		this.compte = compteuser;
		this.compte = compteBnef;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TypeOperation getType() {
		return type;
	}
	public void setType(TypeOperation type) {
		this.type = type;
	}
	public SensOperation getSens() {
		return sens;
	}
	public void setSens(SensOperation sens) {
		this.sens = sens;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	

}
