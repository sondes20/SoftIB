package tn.banque.softib.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Demande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public String cin;
	@JsonProperty
	private boolean isAccepted;
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Demande(boolean isAccepted, String cin) {
		super();
		this.isAccepted = isAccepted;
		this.cin = cin;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "Demande [id=" + id + ", isAccepted=" + isAccepted + "]";
	}
	
	
	
	
}