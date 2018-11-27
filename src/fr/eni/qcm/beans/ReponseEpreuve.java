package fr.eni.qcm.beans;

public class ReponseEpreuve {
    private QuestionEpreuve reponses;

    public ReponseEpreuve(QuestionEpreuve reponses) {
        this.reponses = reponses;
    }

    public QuestionEpreuve getReponses() {
        return reponses;
    }

    public void setReponses(QuestionEpreuve reponses) {
        this.reponses = reponses;
    }
}
