package fr.eni.qcm.bo;

public class Theme {
    private Integer idTheme;
    private String libelle;

    public Theme(Integer idTheme, String libelle) {
        this.idTheme = idTheme;
        this.libelle = libelle;
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
