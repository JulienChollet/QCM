package fr.eni.qcm.beans;

public class Profil {
    private String codeProfil;
    private String libelle;

    public String getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(String codeProfil) {
        this.codeProfil = codeProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Profil(String codeProfil, String libelle) {
        this.codeProfil = codeProfil;
        this.libelle = libelle;
    }
}
