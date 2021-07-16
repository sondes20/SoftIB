package tn.banque.softib.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Intervention_ClientPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id_Intervention;
	private String id_Client;
	public Intervention_ClientPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_Intervention() {
		return id_Intervention;
	}
	public void setId_Intervention(long id_Intervention) {
		this.id_Intervention = id_Intervention;
	}
	public String getId_Client() {
		return id_Client;
	}
	public void setId_Client(String id_Client) {
		this.id_Client = id_Client;
	}
	@Override
	public String toString() {
		return "Intervention_ClientPK [id_Intervention=" + id_Intervention + ", id_Client=" + id_Client + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Client == null) ? 0 : id_Client.hashCode());
		result = prime * result + (int) (id_Intervention ^ (id_Intervention >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intervention_ClientPK other = (Intervention_ClientPK) obj;
		if (id_Client == null) {
			if (other.id_Client != null)
				return false;
		} else if (!id_Client.equals(other.id_Client))
			return false;
		if (id_Intervention != other.id_Intervention)
			return false;
		return true;
	}
	

}
