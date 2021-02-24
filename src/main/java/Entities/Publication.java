package Entities;

import java.util.List;
import java.sql.Date;

public class Publication {
	private long id;
	private String titre;
	private String desc;
	private Date date;
	private String type;
	private int etatInfo;
	private Association association;
	private List<Don> dons;

	
	public Publication(long id, String titre, String desc, String type) {
		this.id = id;
		this.titre = titre;
		this.desc = desc;
		this.date =	new Date(new java.util.Date().getTime());
		this.type = type;
	}
	
	public Publication(long id, String titre, String desc,Date date, String type, int etatInfo) {
		this.id = id;
		this.titre = titre;
		this.desc = desc;
		this.date =	date;
		this.type = type;
		this.etatInfo = etatInfo;
	}
	

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String Titre_Pub) {
		this.titre = Titre_Pub;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc_Pub(String Desc_Pub) {
		this.desc = Desc_Pub;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate_Pub(Date Date_Pub) {
		this.date = Date_Pub;
	}
	
	public List<Don> getDons() {
		return dons;
	}
	
	public void setDons(List<Don> dons) {
		this.dons = dons;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEtatInfo() {
		return etatInfo;
	}

	public void setEtatInfo(int etatInfo) {
		this.etatInfo = etatInfo;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
