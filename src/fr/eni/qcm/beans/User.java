package fr.eni.qcm.beans;

public class User {

private Integer idUser;
private String nom;
private String prenom;
private String email;
private String password;
private Epreuve inscrit;
private int profil;
private String promotion;

    public User(Integer idUser, String nom, String prenom, String email, String password, Epreuve inscrit, int profil, String promotion) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.inscrit = inscrit;
        this.profil = profil;
        this.promotion = promotion;
    }

    public User(Integer idUser, String nom, String prenom, String email, String password, Epreuve inscrit, int profil) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.inscrit = inscrit;
        this.profil = profil;
    }

    public User() {
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

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}
