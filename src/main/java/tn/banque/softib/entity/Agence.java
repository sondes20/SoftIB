package tn.banque.softib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	private String nom;
	private String adresse;
	private String nomResponsable;
	private String Telephone;
	@ManyToOne
	private Banque banque;
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agence(String nom, String adresse, String nomResponsable, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nomResponsable = nomResponsable;
		Telephone = telephone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNomResponsable() {
		return nomResponsable;
	}
	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", nomResponsable=" + nomResponsable
				+ ", Telephone=" + Telephone + ", banque=" + banque + "]";
	}
	
	
	

}
