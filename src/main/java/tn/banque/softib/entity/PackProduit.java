package tn.banque.softib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PackProduit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	private String nom;
	private String typeDeFinancement;
	private String caracteriqtique;
	private String avantage;
	private String documentsUtils;
	private double prix;
	@ManyToOne
	private Banque banque;
	public PackProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackProduit(String nom, String typeDeFinancement, String caracteriqtique, String avantage,
			String documentsUtils, double prix, Banque banque) {
		super();
		this.nom = nom;
		this.typeDeFinancement = typeDeFinancement;
		this.caracteriqtique = caracteriqtique;
		this.avantage = avantage;
		this.documentsUtils = documentsUtils;
		this.prix = prix;
		this.banque = banque;
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
	public String getTypeDeFinancement() {
		return typeDeFinancement;
	}
	public void setTypeDeFinancement(String typeDeFinancement) {
		this.typeDeFinancement = typeDeFinancement;
	}
	public String getCaracteriqtique() {
		return caracteriqtique;
	}
	public void setCaracteriqtique(String caracteriqtique) {
		this.caracteriqtique = caracteriqtique;
	}
	public String getAvantage() {
		return avantage;
	}
	public void setAvantage(String avantage) {
		this.avantage = avantage;
	}
	public String getDocumentsUtils() {
		return documentsUtils;
	}
	public void setDocumentsUtils(String documentsUtils) {
		this.documentsUtils = documentsUtils;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	@Override
	public String toString() {
		return "PackProduit [id=" + id + ", nom=" + nom + ", typeDeFinancement=" + typeDeFinancement
				+ ", caracteriqtique=" + caracteriqtique + ", avantage=" + avantage + ", documentsUtils="
				+ documentsUtils + ", prix=" + prix + ", banque=" + banque + "]";
	}
	
	

}
