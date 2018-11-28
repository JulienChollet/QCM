package fr.eni.qcm.beans;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idQuestion;
    private String enonce;
    private String image;
    private Integer points;
    private List<Theme> themes;

    public Question(Integer idQuestion, String enonce, String image, Integer points, List<Theme> themes) {
        this.idQuestion = idQuestion;
        this.enonce = enonce;
        this.image = image;
        this.points = points;
        this.themes = themes;
    }    
    
    public Question(Integer idQuestion, String enonce, Integer points) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.points = points;
	}


	public Question(Integer idQuestion, String enonce) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
	}


	public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
}
