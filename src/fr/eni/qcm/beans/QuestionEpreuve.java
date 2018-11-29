package fr.eni.qcm.beans;

import java.util.ArrayList;
import java.util.List;

public class QuestionEpreuve extends Question{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numordre;
	private Boolean marquee;
    private List<Epreuve> questionsTireesAuSort;
    
    
	public QuestionEpreuve(Integer idQuestion, Integer numordre, Integer idEpreuve) {
		super();
		setIdQuestion(idQuestion);
		setNumordre(numordre);
		questionsTireesAuSort= new ArrayList<Epreuve>();
	}

	public int getIdEpreuve() {
		int idEpreuve = 0;
		for(Epreuve e : questionsTireesAuSort) {
			idEpreuve = e.getIdEpreuve();
		}		
		return idEpreuve;
	}
	


	/**
	 * Accesseurs
	 * @return
	 */
	public Boolean getMarquee() {
        return marquee;
    }

    public void setMarquee(Boolean marquee) {
        this.marquee = marquee;
    }

	public List<Epreuve> getQuestionsTireesAuSort() {
		return questionsTireesAuSort;
	}

	public void setQuestionsTireesAuSort(List<Epreuve> questionsTireesAuSort) {
		this.questionsTireesAuSort = questionsTireesAuSort;
	}

	@Override
	public String toString() {
		return "QuestionEpreuve{" +
				"numordre=" + numordre +
				", marquee=" + marquee +
				", questionsTireesAuSort=" + questionsTireesAuSort +
				'}';
	}

	public int getNumordre() {
		return numordre;
	}

	public void setNumordre(int numordre) {
		this.numordre = numordre;
	}
}