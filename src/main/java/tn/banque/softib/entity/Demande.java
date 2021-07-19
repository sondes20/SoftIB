package tn.banque.softib.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Demande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Enumerated
	private NomDemande nom;
	private boolean isAccepted;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Agent agent;
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demande(NomDemande nom, boolean isAccepted) {
		super();
		this.nom = nom;
		this.isAccepted = isAccepted;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public NomDemande getNom() {
		return nom;
	}
	public void setNom(NomDemande nom) {
		this.nom = nom;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		return "Demande [id=" + id + ", nom=" + nom + ", isAccepted=" + isAccepted + ", client=" + client + ", agent="
				+ agent + "]";
	}
	
	
	

}
