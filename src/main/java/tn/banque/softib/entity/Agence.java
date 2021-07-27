package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private String telephone;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Banque banque;
	@OneToMany(mappedBy="agence", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Compte> comptes;
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agence(String nom, String adresse, String nomResponsable, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nomResponsable = nomResponsable;
		this.telephone = telephone;
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
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", nomResponsable=" + nomResponsable
				+ ", Telephone=" + telephone + ", banque=" + banque + "]";
	}
	
	
	

}
