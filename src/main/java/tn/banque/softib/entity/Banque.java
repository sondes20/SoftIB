package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	private String nom;
	private String telephone;
	private String adresse;
	@OneToMany(mappedBy="banque", cascade=CascadeType.ALL)
	private List<Agence> agences;
	@OneToMany(mappedBy="banque", cascade=CascadeType.ALL)
	private List<PackProduit> packProduits;
	@OneToMany(mappedBy="banque", cascade=CascadeType.ALL)
	private List<Compte> comptes;
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banque(String nom, String telephone, String adresse, List<Agence> agences, List<PackProduit> packProduits,
			List<Compte> comptes) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.agences = agences;
		this.packProduits = packProduits;
		/*this.comptes = comptes;*/
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Agence> getAgences() {
		return agences;
	}
	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
	public List<PackProduit> getPackProduits() {
		return packProduits;
	}
	public void setPackProduits(List<PackProduit> packProduits) {
		this.packProduits = packProduits;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", adresse=" + adresse + ", agences="
				+ agences + ", packProduits=" + packProduits + ", comptes=" + comptes + "]";
	}
	
	
	

}
