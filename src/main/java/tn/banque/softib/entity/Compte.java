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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte implements Serializable, Comparable<Compte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false)
	private String NCompte;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Enumerated(EnumType.STRING)
	private TypeCompte typeCompte;
	private String avantage;
	private double solde;
	@OneToMany(mappedBy="compte", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Operation> operations;
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JsonIgnore
	private Client client;
	@ManyToOne
	@JsonIgnore
	private Agence agence;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String nCompte, Date dateCreation, TypeCompte typeCompte, String avantage) {
		super();
		NCompte = nCompte;
		this.dateCreation = dateCreation;
		this.typeCompte = typeCompte;
		this.avantage = avantage;
	}

	public Compte(TypeCompte typeCompte, String avantage) {
		super();
		this.typeCompte = typeCompte;
		this.avantage = avantage;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}


	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}


	public Compte(String nCompte, Date dateCreation, TypeCompte type, String avantage, double solde) {
		super();
		NCompte = nCompte;
		this.dateCreation = dateCreation;
		this.typeCompte = type;
		this.avantage = avantage;
		this.solde = solde;
	}


	public String getNCompte() {
		return NCompte;
	}
	public void setNCompte(String nCompte) {
		NCompte = nCompte;
	}
	
	public String getAvantage() {
		return avantage;
	}
	public void setAvantage(String avantage) {
		this.avantage = avantage;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Compte [NCompte=" + NCompte + ", dateCreation=" + dateCreation + ", type=" + typeCompte + ", avantage="
				+ avantage + ", solde=" + solde + ", operations=" + operations + ", client="
				+ client + "]";
	}
	

	@Override
	public int compareTo(Compte o) {
		
		return (int) (this.solde-o.solde);
	}

	
	
	

}
