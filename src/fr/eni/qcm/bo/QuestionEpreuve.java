package fr.eni.qcm.bo;

public class QuestionEpreuve {
    private Boolean marquee;
    private Epreuve questionsTireesAuSort;

    public QuestionEpreuve(Boolean marquee, Epreuve questionsTireesAuSort) {
        this.marquee = marquee;
        this.questionsTireesAuSort = questionsTireesAuSort;
    }

    public Boolean getMarquee() {
        return marquee;
    }

    public void setMarquee(Boolean marquee) {
        this.marquee = marquee;
    }

    public Epreuve getQuestionsTireesAuSort() {
        return questionsTireesAuSort;
    }

    public void setQuestionsTireesAuSort(Epreuve questionsTireesAuSort) {
        this.questionsTireesAuSort = questionsTireesAuSort;
    }
}
