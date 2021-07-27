package tn.banque.softib.entity;

import java.io.Serializable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@DiscriminatorValue(value="credit")
@Entity
public class DemandeCredit extends Demande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double revenueAnnuel;
	@Enumerated(EnumType.STRING)
	private TypeCredit typeCredit;
	private double maxMontant;
	public DemandeCredit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DemandeCredit(double revenueAnnuel, TypeCredit typeCredit, double maxMontant) {
		super();
		this.revenueAnnuel = revenueAnnuel;
		this.typeCredit = typeCredit;
		this.maxMontant = maxMontant;
	}


	public DemandeCredit(boolean isAccepted, String cin) {
		super(isAccepted, cin);
		// TODO Auto-generated constructor stub
	}


	public double getRevenueAnnuel() {
		return revenueAnnuel;
	}
	public void setRevenueAnnuel(double revenueAnnuel) {
		this.revenueAnnuel = revenueAnnuel;
	}
	public TypeCredit getTypeCredit() {
		return typeCredit;
	}
	public void setTypeCredit(TypeCredit type) {
		this.typeCredit = type;
	}
	public double getMaxMontant() {
		return maxMontant;
	}
	public void setMaxMontant(double maxMontant) {
		this.maxMontant = maxMontant;
	}
	
	@Override
	public String toString() {
		return "DemandeCredit [revenueAnnuel=" + revenueAnnuel + ", typeCredit="
				+ typeCredit + ", maxMontant=" + maxMontant + "]";
	}
	
}
