package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.qcm.beans.QuestionEpreuve;

public class QuestionTirageDAO {

	private static final String AJOUTER_TIRAGE ="INSERT INTO dbo.QUESTION_TIRAGE(estMarquee, idQuestion, numordre, idEpreuve) VALUES (?,?,?,?)";
	private static final String SELECT_TIRAGE ="SELECT idEpreuve FROM dbo.QUESTION_TIRAGE WHERE idQuestion=?";

	public static void ajouterQE(QuestionEpreuve questionEpreuve) throws SQLException{
		
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			System.out.println(questionEpreuve.toString());
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(AJOUTER_TIRAGE);
			rqt.setBoolean(1, false);
			rqt.setInt(2, questionEpreuve.getIdQuestion());
			rqt.setInt(3, questionEpreuve.getNumordre());
			rqt.setInt(4, questionEpreuve.getIdEpreuve());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	public static Integer recupIdEpreuve(Integer idQuestion) throws SQLException {
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs;
		try{
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(SELECT_TIRAGE);
			rqt.setInt(1, idQuestion);
			rs = rqt.executeQuery();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return rs.getInt("idEpreuve");
	}
}
