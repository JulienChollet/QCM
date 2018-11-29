package fr.eni.qcm.beans;

import java.util.ArrayList;

public class Test {
    private Integer idTest;
    private String nom;
    private String description;
    private Integer duree;
    private Float seuilHaut;
    private Float seuilBas;
    private ArrayList<Section> sections;

    private transient Integer totalQuestionPosees;

    public void ajouter (QuestionEpreuve question){};
    public Section extraire (Integer index){

        return null;
    };

    public Test(Integer idTest, String nom, String description, Integer duree, Float seuilHaut, Float seuilBas) {
        this.idTest = idTest;
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.seuilHaut = seuilHaut;
        this.seuilBas = seuilBas;
        this.sections = new ArrayList<>();
    }

    public ArrayList<Section> getSections() {
		return sections;
	}
	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
		for (Section section : sections) {
			this.totalQuestionPosees = this.totalQuestionPosees =  + section.getNbQuestionsAttendues();
		}
		
	}
	public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Float getSeuilHaut() {
        return seuilHaut;
    }

    public void setSeuilHaut(Float seuilHaut) {
        this.seuilHaut = seuilHaut;
    }

    public Float getSeuilBas() {
        return seuilBas;
    }

    public void setSeuilBas(Float seuilBas) {
        this.seuilBas = seuilBas;
    }

    public Integer getTotalQuestionPosees() {
        return totalQuestionPosees;
    }

    public void setTotalQuestionPosees(Integer totalQuestionPosees) {
        this.totalQuestionPosees = totalQuestionPosees;
    }
}
