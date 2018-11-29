package fr.eni.qcm.beans;

public class SectionTest {
	
	private Integer idTest;
	private Integer idTheme;
	private Integer nombreQuestion;
	
	
	public SectionTest(Integer idTest, Integer idTheme, Integer nombreQuestion) {
		super();
		this.idTest = idTest;
		this.idTheme = idTheme;
		this.nombreQuestion = nombreQuestion;
	}



	public Integer getIdTest() {
		return idTest;
	}


	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}


	public Integer getIdTheme() {
		return idTheme;
	}


	public void setIdTheme(Integer idTheme) {
		this.idTheme = idTheme;
	}


	public Integer getNombreQuestion() {
		return nombreQuestion;
	}


	public void setNombreQuestion(Integer nombreQuestion) {
		this.nombreQuestion = nombreQuestion;
	}


	@Override
	public String toString() {
		return "SectionTest [idTest=" + idTest + ", idTheme=" + idTheme + ", nombreQuestion=" + nombreQuestion + "]";
	}
	
	
	

}
