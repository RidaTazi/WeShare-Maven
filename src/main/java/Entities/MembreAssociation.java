package Entities;

import javax.persistence.Id;
import java.io.Serializable;

public class MembreAssociation extends User implements Serializable {
    @Id
    private Long idMembre;
	private String nomMembre;
	private String prenomMembre;
	private String posteMembre;
	private Long idAssoc;
	private Long idUser;

    public MembreAssociation() {
    }

    public MembreAssociation(String nomMembre, String prenomMembre, String posteMembre, Long idAssoc, Long idUser) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
        this.posteMembre = posteMembre;
        this.idAssoc = idAssoc;
        this.idUser = idUser;
    }

    public Long getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Long idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getPosteMembre() {
        return posteMembre;
    }

    public void setPosteMembre(String posteMembre) {
        this.posteMembre = posteMembre;
    }

    public Long getIdAssoc() {
        return idAssoc;
    }

    public void setIdAssoc(Long idAssoc) {
        this.idAssoc = idAssoc;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
