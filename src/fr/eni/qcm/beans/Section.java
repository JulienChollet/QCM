package fr.eni.qcm.beans;


public class Section {
    private Integer idSection;
    private Integer nbQuestionsAttendues;
 

    public Section(Integer nbQuestionsAttendues) {
        
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

	@Override
	public String toString() {
		return "Section [idSection=" + idSection + ", nbQuestionsAttendues=" + nbQuestionsAttendues + "]";
	}

   
}
