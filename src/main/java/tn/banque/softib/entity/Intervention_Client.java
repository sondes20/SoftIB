package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Intervention_Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Intervention_ClientPK interventionClientPK;
	@Temporal(TemporalType.DATE)
	private Date dateIntevention;
	private String contenu;
	@ManyToOne
	@JoinColumn(name="id_Intervention", referencedColumnName="id", insertable=false, updatable=false)
	private Intervention intervention;
	@ManyToOne
	@JoinColumn(name="id_Client", referencedColumnName="identifiant", insertable=false, updatable=false)
	private Client client;
	
	public Intervention_Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Intervention_Client(Intervention_ClientPK interventionClientPK, Date dateIntevention, String contenu,
			Intervention intervention, Client client) {
		super();
		this.interventionClientPK = interventionClientPK;
		this.dateIntevention = dateIntevention;
		this.contenu = contenu;
		this.intervention = intervention;
		this.client = client;
	}
	public Intervention_ClientPK getInterventionClientPK() {
		return interventionClientPK;
	}
	public void setInterventionClientPK(Intervention_ClientPK interventionClientPK) {
		this.interventionClientPK = interventionClientPK;
	}
	public Date getDateIntevention() {
		return dateIntevention;
	}
	public void setDateIntevention(Date dateIntevention) {
		this.dateIntevention = dateIntevention;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Intervention_Client [interventionClientPK=" + interventionClientPK + ", dateIntevention="
				+ dateIntevention + ", contenu=" + contenu + ", intervention=" + intervention + ", client=" + client
				+ "]";
	}
	

}
