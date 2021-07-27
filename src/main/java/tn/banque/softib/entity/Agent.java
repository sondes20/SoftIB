package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(updatable=false)
	private String code;
	private String nom;
	private String prenom;
	private int nbClients;
	@OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore
	private List<Client> clients;
	@OneToMany(mappedBy="agent", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JsonIgnore
	public List<Operation> operations;
	@OneToMany
	private List<Demande> demandes;
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(String code, String nom, String prenom) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	@Override
	public String toString() {
		return "Agent [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", nbClients=" + nbClients + ", clients="
				+ clients + ", operations=" + operations + "]";
	}
	
	


}
