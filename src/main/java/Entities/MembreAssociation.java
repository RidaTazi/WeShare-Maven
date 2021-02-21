package Entities;

import javax.persistence.Id;
import java.io.Serializable;

public class MembreAssociation extends User implements Serializable {
    @Id
    private String idMembre;
	private String nomMembre;
	private String prenomMembre;
	private String posteMembre;
	private Association association;
	private User user;

    public MembreAssociation() {
    }

    public MembreAssociation(String nomMembre, String prenomMembre, String posteMembre, Association association, User user) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
        this.posteMembre = posteMembre;
        this.association = association;
        this.user = user;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
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

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
