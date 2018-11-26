package fr.eni.qcm.bo;

import java.util.ArrayList;

public class Section {
    private Integer idSection;
    private Integer nbQuestionsAttendues;
    private static ArrayList<Test> sections;

    public static Integer compte(){
        return sections.size();
    }

    public Section(Integer idSection, Integer nbQuestionsAttendues) {
        this.idSection = idSection;
        this.nbQuestionsAttendues = nbQuestionsAttendues;
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public Integer getNbQuestionsAttendues() {
        return nbQuestionsAttendues;
    }

    public void setNbQuestionsAttendues(Integer nbQuestionsAttendues) {
        this.nbQuestionsAttendues = nbQuestionsAttendues;
    }

    public static ArrayList<Test> getSections() {
        return sections;
    }

    public static void setSections(ArrayList<Test> sections) {
        Section.sections = sections;
    }
}
