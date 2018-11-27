package fr.eni.qcm.beans;

public class QuestionEpreuve {
    private Boolean marquee;

    public QuestionEpreuve(Boolean marquee) {
        this.marquee = marquee;
    }

    public Boolean getMarquee() {
        return marquee;
    }

    public void setMarquee(Boolean marquee) {
        this.marquee = marquee;
    }

}
