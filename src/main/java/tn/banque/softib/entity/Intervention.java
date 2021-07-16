package tn.banque.softib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Intervention implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private long id;
	@Enumerated(EnumType.STRING)
	private TypeIntervention type;
	@OneToMany(mappedBy="intervention", cascade=CascadeType.ALL )
	private List<Intervention_Client> interventions;
	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Intervention(long id, TypeIntervention type, List<Intervention_Client> interventions) {
		super();
		this.id = id;
		this.type = type;
		this.interventions = interventions;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TypeIntervention getType() {
		return type;
	}
	public void setType(TypeIntervention type) {
		this.type = type;
	}
	public List<Intervention_Client> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention_Client> interventions) {
		this.interventions = interventions;
	}
	@Override
	public String toString() {
		return "Intervention [id=" + id + ", type=" + type + ", interventions=" + interventions + "]";
	}
	
	

}
