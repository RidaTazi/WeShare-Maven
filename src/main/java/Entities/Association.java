package Entities;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class Association  implements Serializable {

    @Id
    private Long idAssoc;
	private String nomAssoc;
	private String codeAssoc;
	private String descAssoc;
	private String logoAssoc;
	private String addrAssoc;
	private int etatInfo;
	private List<Publication> publications;
	private List<Don> dons;

    public Association() {
    }

    public Association(String nomAssoc, String codeAssoc, String descAssoc, String logoAssoc, String addrAssoc) {
        this.nomAssoc = nomAssoc;
        this.codeAssoc = codeAssoc;
        this.descAssoc = descAssoc;
        this.logoAssoc = logoAssoc;
        this.addrAssoc = addrAssoc;
        this.etatInfo = 1;
    }

    public Long getIdAssoc() {
        return idAssoc;
    }

    public void setIdAssoc(Long idAssoc) {
        this.idAssoc = idAssoc;
    }

    public String getNomAssoc() {
        return nomAssoc;
    }

    public void setNomAssoc(String nomAssoc) {
        this.nomAssoc = nomAssoc;
    }

    public String getCodeAssoc() {
        return codeAssoc;
    }

    public void setCodeAssoc(String codeAssoc) {
        this.codeAssoc = codeAssoc;
    }

    public String getDescAssoc() {
        return descAssoc;
    }

    public void setDescAssoc(String descAssoc) {
        this.descAssoc = descAssoc;
    }

    public String getLogoAssoc() {
        return logoAssoc;
    }

    public void setLogoAssoc(String logoAssoc) {
        this.logoAssoc = logoAssoc;
    }

    public String getAddrAssoc() {
        return addrAssoc;
    }

    public void setAddrAssoc(String addrAssoc) {
        this.addrAssoc = addrAssoc;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Don> getDons() {
        return dons;
    }

    public void setDons(List<Don> dons) {
        this.dons = dons;
    }

    public int getEtatInfo() {
        return etatInfo;
    }

    public void setEtatInfo(int etatInfo) {
        this.etatInfo = etatInfo;
    }
}

