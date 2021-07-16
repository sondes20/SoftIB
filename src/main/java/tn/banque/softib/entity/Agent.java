package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private int nbClients;
	private String prenom;
	@OneToMany
	private List<Client> clients;
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(String code, String nom, String prenom, List<Client> clients) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.clients = clients;
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
	@Override
	public String toString() {
		return "Agent [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", nbClients=" + ", clients="
				+ clients + "]";
	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}
	

}
