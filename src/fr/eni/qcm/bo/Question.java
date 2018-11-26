package fr.eni.qcm.bo;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {


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
