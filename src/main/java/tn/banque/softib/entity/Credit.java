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
public class Credit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	@Enumerated(EnumType.STRING)
	private TypeCredit type;
	@Temporal(TemporalType.DATE)
	private Date dateCredit;
	private double montant;
	private int dureeDePaiement;
	private double montantMensuel;
	private String dateDePaiement; //Date.day
	private boolean isPay;
	@ManyToOne
	private Client client;
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Credit(TypeCredit type, Date dateCredit, double montant, int dureeDePaiement, double montantMensuel,
			String dateDePaiement, boolean isPay, Client client) {
		super();
		this.type = type;
		this.dateCredit = dateCredit;
		this.montant = montant;
		this.dureeDePaiement = dureeDePaiement;
		this.montantMensuel = montantMensuel;
		this.dateDePaiement = dateDePaiement;
		this.isPay = isPay;
		this.client = client;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TypeCredit getType() {
		return type;
	}
	public void setType(TypeCredit type) {
		this.type = type;
	}
	public Date getDateCredit() {
		return dateCredit;
	}
	public void setDateCredit(Date dateCredit) {
		this.dateCredit = dateCredit;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getDureeDePaiement() {
		return dureeDePaiement;
	}
	public void setDureeDePaiement(int dureeDePaiement) {
		this.dureeDePaiement = dureeDePaiement;
	}
	public double getMontantMensuel() {
		return montantMensuel;
	}
	public void setMontantMensuel(double montantMensuel) {
		this.montantMensuel = montantMensuel;
	}
	public String getDateDePaiement() {
		return dateDePaiement;
	}
	public void setDateDePaiement(String dateDePaiement) {
		this.dateDePaiement = dateDePaiement;
	}
	public boolean isPay() {
		return isPay;
	}
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Credit [id=" + id + ", type=" + type + ", dateCredit=" + dateCredit + ", montant=" + montant
				+ ", dureeDePaiement=" + dureeDePaiement + ", montantMensuel=" + montantMensuel + ", dateDePaiement="
				+ dateDePaiement + ", isPay=" + isPay + ", client=" + client + "]";
	}
	
	

}
