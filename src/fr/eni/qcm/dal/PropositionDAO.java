package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.qcm.beans.Proposition;

public class PropositionDAO {
	
	// REQ Ajouter une r�ponse : 1 / l'id de la r�ponse donn�e ; 2 / si elle est bonne !
	private static final String AJOUTER="INSERT INTO dbo.PROPOSITION(idProposition, estBonne) VALUES(?,?)";
	private static final String LISTER="SELECT idProposition, enonce FROM dbo.PROPOSITION";
	private static final String AJOUTER_REPONSE="INSERT INTO dbo.REPONSE_TIRAGE(idProposition, idQuestion, idEpreuve) VALUES (?,?,?)";

	/** AJOUTER REPONSE 
	 * @throws SQLException */	
	public static void ajouterProposition(Proposition proposition) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=ConnexionProvider.getConnexion();
			rqt=cnx.prepareStatement(AJOUTER_REPONSE);
			rqt.setInt(1, proposition.getIdReponse());
			rqt.setBoolean(2, proposition.getEstCorrecte());
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/** AFFICHER PROPOSITIONS
	 * @throws SQLException */	
	public static ArrayList<Proposition> afficherReponses() throws SQLException{
		
		Connection cnx=null;
		Statement stm=null;
		ResultSet rs = null;
		
		// Initialisation liste
		ArrayList<Proposition> propositions= new ArrayList<Proposition>();
		try {
			cnx=ConnexionProvider.getConnexion();
			stm=cnx.createStatement();
			rs=stm.executeQuery(LISTER);
			
			Proposition proposition;
			while (rs.next()) {
				proposition = new Proposition(
						rs.getInt("idProposition"),
						rs.getString("enonce")
						);
				propositions.add(proposition);
			}
		}finally {
			if (rs!=null) rs.close();
			if (stm!=null) stm.close();
			if (cnx!=null) cnx.close();
		}
		
		return propositions;		
	}	
}
