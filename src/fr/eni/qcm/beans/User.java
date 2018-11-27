package fr.eni.qcm.beans;

public class User {

private Integer idUser;
private String nom;
private String prenom;
private String email;
private String password;
private Epreuve inscrit;

    public User(Integer idUser, String nom, String prenom, String email, String password, Epreuve inscrit) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.inscrit = inscrit;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Epreuve getInscrit() {
        return inscrit;
    }

    public void setInscrit(Epreuve inscrit) {
        this.inscrit = inscrit;
    }
}
