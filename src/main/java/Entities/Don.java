package Entities;

import java.sql.Date;
import java.io.Serializable;


public class Don implements Serializable {
	private long iD;
	private String type;
	private String logo;
	private String desc;
	private Date date;
	private String state;
	private int etatInfo;
	private Association association;
	private Publication publication;
	private Donneur donneur;
	
	
	public Don() {
		
	}
	
	//use this constructor to create a user's donation (no publication or association associated)
	public Don (String type, String logo, String desc, String state, Donneur donneur){
		this.type = type;
		this.logo = logo;
		this.desc = desc;
		this.date =	new Date(new java.util.Date().getTime());
		this.state = state;
		etatInfo = 1;
		this.donneur = donneur;
	}
	
	//use this constructor to retrieve a user's donations
	public Don (long iD, String type, String logo, String desc,Date date, String state, int etatInfo){
		this.iD = iD;
		this.type = type;
		this.logo = logo;
		this.desc = desc;
		this.date =	date;
		this.state = state;
		this.etatInfo = etatInfo;
	}
	

	public String getType() {
		return this.type;
	}

	public void setType(String Type_Don) {
		this.type = Type_Don;
	}

	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String Desc_Don) {
		this.desc = Desc_Don;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date Date_Don) {
		this.date = Date_Don;
	}


	public long getiD() {
		return iD;
	}


	public void setiD(long iD) {
		this.iD = iD;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getEtatInfo() {
		return etatInfo;
	}


	public void setEtatInfo(int etat_Info) {
		etatInfo = etat_Info;
	}
	
	public Association getAssociation() {
		return association;
	}


	public void setAssociation(Association association) {
		this.association = association;
	}


	public Publication getPublication() {
		return publication;
	}


	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	public Donneur getDonneur() {
		return donneur;
	}


	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	
}