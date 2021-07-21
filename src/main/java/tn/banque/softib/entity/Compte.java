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
	private TypeCompte type;
	private String avantage;
	private double solde;
	@ManyToOne
	private Banque banque;
	@OneToMany(mappedBy="compte", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private List<Operation> operations;
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Client client;
	@OneToMany(mappedBy="compte")
	private List<ChiffreAffaire> chiffreAffaires;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String nCompte) {
		super();
		NCompte = nCompte;
	}

	public Compte(String nCompte, Date dateCreation, TypeCompte type, String avantage, double solde) {
		super();
		NCompte = nCompte;
		this.dateCreation = dateCreation;
		this.type = type;
		this.avantage = avantage;
		this.solde = solde;
	}

	public String getNCompte() {
		return NCompte;
	}
	public void setNCompte(String nCompte) {
		NCompte = nCompte;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	public String getAvantage() {
		return avantage;
	}
	public void setAvantage(String avantage) {
		this.avantage = avantage;
	}
	
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
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

	@Override
	public String toString() {
		return "Compte [NCompte=" + NCompte + ", dateCreation=" + dateCreation + ", type=" + type + ", avantage="
				+ avantage + ", solde=" + solde + ", banque=" + banque + ", operations=" + operations + ", client="
				+ client + "]";
	}

	@Override
	public int compareTo(Compte o) {
		
		return (int) (this.solde-o.solde);
	}

	
	
	

}
