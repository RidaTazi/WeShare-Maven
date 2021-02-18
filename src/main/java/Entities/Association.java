package Entities;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class Association extends User implements Serializable {

    @Id
    private Long idAssoc;
	private String nomAssoc;
	private String codeAssoc;
	private String descAssoc;
	private String logoAssoc;
	private String addrAssoc;
	public List<Publication> publications;
	public List<Don> dons;

    public Association(Long idAssoc, String nomAssoc, String codeAssoc, String descAssoc, String logoAssoc, String addrAssoc, List<Publication> publications, List<Don> dons) {
        this.idAssoc = idAssoc;
        this.nomAssoc = nomAssoc;
        this.codeAssoc = codeAssoc;
        this.descAssoc = descAssoc;
        this.logoAssoc = logoAssoc;
        this.addrAssoc = addrAssoc;
        this.publications = publications;
        this.dons = dons;
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
}

