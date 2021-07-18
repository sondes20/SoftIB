package tn.banque.softib.entity;

import java.io.Serializable;
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
	@ManyToOne
	private Banque banque;
	@OneToMany(mappedBy="compte", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private List<Operation> operations;
	@ManyToOne
	private Client client;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String nCompte) {
		super();
		NCompte = nCompte;
	}

	public Compte(String nCompte, TypeCompte type, String avantage, Client client) {
		super();
		NCompte = nCompte;
		this.type = type;
		this.avantage = avantage;
		this.client = client;
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

	@Override
	public String toString() {
		return "Compte [NCompte=" + NCompte + ", type=" + type + ", avantage=" + avantage
				+ ", banque=" + banque + ", operations=" + operations + ", client=" + client + "]";
	}
	
	

}
