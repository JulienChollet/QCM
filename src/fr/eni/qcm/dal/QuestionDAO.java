package fr.eni.qcm.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.eni.qcm.beans.Question;


public class QuestionDAO {
	
	// REQ Affiche Question en front
	private static final String LISTER="SELECT idQuestion, enonce, points FROM dbo.QUESTION";
	// REQ Create_ajouter Question en base /
	private static final String AJOUTER="INSERT INTO dbo.QUESTION(idQuestion, enonce, points) VALUES(?,?,?)";
	// REQ Delete Question By_q_id /
	private static final String SUPPRIMER="DELETE FROM dbo.QUESTION WHERE idQuestion = ?";
	// REQ Update Question By_q_id / 
	private static final String MODIFIER="UPDATE dbo.QUESTION set enonce = ?, points = ? where idQuestion = ?";
	// REQ Update Question By_id_Theme / 
	private static final String LISTER_BY_THEME="SELECT idQuestion, enonce, points FROM dbo.QUESTION WHERE idTheme = ?";
	
	/** AFFICHER LISTE QUESTIONS 
	 * @throws SQLException */
	public static ArrayList<Question> afficherQuestions() throws SQLException{
		
		Connection cnx=null;
		Statement stm=null;
		ResultSet rs=null;
		// Initialisation liste
		ArrayList<Question> questions= new ArrayList<Question>();
		try {
			cnx=ConnexionProvider.getConnexion();
			stm=cnx.createStatement();
			rs=stm.executeQuery(LISTER);

			Question question;
			while (rs.next()) {
				question = new Question(
						rs.getInt("idQuestion"),
						rs.getString("enonce"),
						rs.getInt("points")
						);
				questions.add(question);
			}
		}finally {
			if (rs!=null) rs.close();
			if (stm!=null) stm.close();
			if (cnx!=null) cnx.close();
		}
		return questions;
	}	
	/** AFFICHER LISTE QUESTIONS ByIdTheme
	 * @throws SQLException */
	public static ArrayList<Question> afficherQuestionByTheme(Integer theme) throws SQLException{
		
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		Question quest = null;
		ArrayList<Question> questions= new ArrayList<Question>();

		try {
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(LISTER_BY_THEME);
			rqt.setInt(1, theme);
			rs = rqt.executeQuery();
			
			while (rs.next()) {
				quest = new Question(rs.getInt("idQuestion"),rs.getString("enonce"), rs.getInt("points"));
				questions.add(quest);
			}
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return questions;
	}

	
	
	/** AJOUTER QUESTION 
	 * @throws SQLException */	
	public static void ajouter(Question question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(AJOUTER);
			rqt.setInt(1, question.getIdQuestion());
			rqt.setString(2, question.getEnonce());
			rqt.setInt(3, question.getPoints());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/** SUPPRIMER QUESTION 
	 * @throws SQLException */	
	public static void supprimer(Question question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(SUPPRIMER);
			rqt.setInt(1, question.getIdQuestion());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/** MODIFIER QUESTION (by_id)
	 * @throws SQLException */	
	public static void modifier(Question question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(MODIFIER);
			rqt.setString(1, question.getEnonce());
			rqt.setInt(2, question.getPoints());
			rqt.setInt(3, question.getIdQuestion());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
}
