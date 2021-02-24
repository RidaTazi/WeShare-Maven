package Entities;


import java.util.List;

public class Donneur extends User {
	private String nom_donneur;
	private String prenom_donneur;
	private String addr_donneur;
	private Long idDonneur;
    private List<Don> dons;

	public Donneur() {
	}

	public Donneur(String nom_donneur,String prenom_donneur,String addr_Donneur) {
		this.addr_donneur = addr_Donneur;
		this.nom_donneur = nom_donneur;
		this.prenom_donneur = prenom_donneur;
	}

	public String getNomDonneur() {
		return this.nom_donneur;
	}

	public void setNomDonneur(String aNom_Donneur) {
		this.nom_donneur = aNom_Donneur;
	}

    public String getPrenomDonneur() {
        return this.prenom_donneur;
    }


    public void setPrenomDonneur(String prenom_Donneur) {
        this.prenom_donneur = prenom_Donneur;
    }
	public String getAddrDonneur() {
		return this.addr_donneur;
	}

	public void setAddrDonneur(String aAddr_Donneur) {
		this.addr_donneur = aAddr_Donneur;
	}
    public List<Don> getDons() {
	    return this.dons;
    }

    public void setIdDonneur(Long id){
	    this.idDonneur = id;
    }

    public Long getIdDonneur() {
        return idDonneur;
    }
}