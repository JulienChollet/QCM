package fr.eni.qcm.beans;

import java.util.Date;

public class Epreuve {
    private Date debutValidite;
    private Date finValidite;
    private Integer tempsEcoule;
    private  Integer etatEpreuve;
    private transient Float note;
    private transient String niveauAcquisition;

    public void ajouter(QuestionEpreuve question){

    };
    public QuestionEpreuve extraire(Integer index){

        return null;
    };

}
