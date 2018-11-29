package fr.eni.qcm.beans;

import java.util.List;

public class Proposition {

private Integer idReponse;
private String libelle;
private Boolean estCorrecte;
private List<Question> propositions;

    public Proposition(Integer idReponse, String libelle, Boolean estCorrecte, List<Question> propositions) {
        this.idReponse = idReponse;
        this.libelle = libelle;
        this.estCorrecte = estCorrecte;
        this.propositions = propositions;
    }

    public Proposition(Integer idReponse, String libelle) {
        this.idReponse = idReponse;
        this.libelle = libelle;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEstCorrecte() {
        return estCorrecte;
    }

    public void setEstCorrecte(Boolean estCorrecte) {
        this.estCorrecte = estCorrecte;
    }

    public List<Question> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Question> propositions) {
        this.propositions = propositions;
    }
}
