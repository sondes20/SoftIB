package tn.banque.softib.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ChiffreAffaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double montant;
	private int annee;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Compte compte;
	@Enumerated(EnumType.STRING)
	private SensOperation sens;
	public SensOperation getSens() {
		return sens;
	}
	public void setSens(SensOperation sens) {
		this.sens = sens;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public ChiffreAffaire(long id, double montant, int annee, Compte compte) {
		super();
		this.id = id;
		this.montant = montant;
		this.annee = annee;
		this.compte = compte;
	}
	public ChiffreAffaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiffreAffaire [id=" + id + ", montant=" + montant + ", annee=" + annee + ", compte=" + compte
				+ ", sens=" + sens + "]";
	}
	

}
