package tn.banque.softib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TMM {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String year;
	private String month;
	private String tmm;
	public TMM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TMM(String year, String month, String tmm) {
		super();
		this.year = year;
		this.month = month;
		this.tmm = tmm;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTmm() {
		return tmm;
	}
	public void setTmm(String tmm) {
		this.tmm = tmm;
	}
	@Override
	public String toString() {
		return "TMM [id=" + id + ", year=" + year + ", month=" + month + ", tmm=" + tmm + "]";
	}
	
	

}
