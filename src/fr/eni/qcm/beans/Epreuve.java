package fr.eni.qcm.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Epreuve implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date debutValidite;
    private Date finValidite;
    private Integer tempsEcoule;
    private Integer etatEpreuve;
    private transient Float note;
    private transient String niveauAcquisition;
    private User inscrit;
    private Test test;
    private List<QuestionEpreuve> questionsTireesAuSort;
	private int idEpreuve;

	public void ajouter(QuestionEpreuve question){

    };
    public QuestionEpreuve extraire(Integer index){

        return null;
    }
	public Date getDebutValidite() {
		return debutValidite;
	}
	public void setDebutValidite(Date debutValidite) {
		this.debutValidite = debutValidite;
	}
	public Date getFinValidite() {
		return finValidite;
	}
	public void setFinValidite(Date finValidite) {
		this.finValidite = finValidite;
	}
	public Integer getTempsEcoule() {
		return tempsEcoule;
	}
	public void setTempsEcoule(Integer tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}
	public Integer getEtatEpreuve() {
		return etatEpreuve;
	}
	public void setEtatEpreuve(Integer etatEpreuve) {
		this.etatEpreuve = etatEpreuve;
	}
	public Float getNote() {
		return note;
	}
	public void setNote(Float note) {
		this.note = note;
	}
	public String getNiveauAcquisition() {
		return niveauAcquisition;
	}
	public void setNiveauAcquisition(String niveauAcquisition) {
		this.niveauAcquisition = niveauAcquisition;
	}
	public User getInscrit() {
		return inscrit;
	}
	public void setInscrit(User inscrit) {
		this.inscrit = inscrit;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public List<QuestionEpreuve> getQuestionsTireesAuSort() {
		return questionsTireesAuSort;
	}
	public void setQuestionsTireesAuSort(List<QuestionEpreuve> questionsTireesAuSort) {
		this.questionsTireesAuSort = questionsTireesAuSort;
	}
	public Epreuve(Date debutValidite, Date finValidite, Integer tempsEcoule) {
		super();
		this.debutValidite = debutValidite;
		this.finValidite = finValidite;
		this.tempsEcoule = tempsEcoule;
		
		
	}
	@Override
	public String toString() {
		return "Epreuve [debutValidite=" + debutValidite + ", finValidite=" + finValidite + ", tempsEcoule="
				+ tempsEcoule + ", etatEpreuve=" + etatEpreuve + ", inscrit=" + inscrit + ", test=" + test
				+ ", questionsTireesAuSort=" + questionsTireesAuSort + "]";
	};

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}
}
