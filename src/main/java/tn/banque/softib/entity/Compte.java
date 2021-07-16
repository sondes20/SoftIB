package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false)
	private String NCompte;
	@Enumerated(EnumType.STRING)
	private TypeCompte type;
	private String avantage;
	private double solde;
	@ManyToOne
	private Banque banque;
	@OneToMany
	private List<Operation> operations;
	@ManyToOne
	private Client client;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	@Override
	public String toString() {
		return "Compte [NCompte=" + NCompte + ", type=" + type + ", avantage=" + avantage + ", solde=" + solde
				+ ", banque=" + banque + ", operations=" + operations + ", client=" + client + "]";
	}
	
	

}
