package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.beans.Epreuve;

public class EpreuveDAO {
	
	private static final String LISTER="SELECT dateDebutValidite ,dateFinValidite ,tempsEcoule ,etat ,note_obtenue ,niveau_obtenu ,EPREUVE.idTest ,idUtilisateur ,TEST.idTest "
			+ ",libelle, description, duree FROM dbo.EPREUVE INNER JOIN TEST ON EPREUVE.idTest=TEST.idTest WHERE idUtilisateur=?; ";
	
	private static final String EPREUVE_BY_ID="SELECT dateDebutValidite ,dateFinValidite "
			+ ",tempsEcoule ,etat ,note_obtenue ,niveau_obtenu ,EPREUVE.idTest ,idUtilisateur ,TEST.idTest"
			+ ",libelle ,description ,duree FROM dbo.EPREUVE INNER JOIN TEST ON EPREUVE.idTest = TEST.idTest WHERE idEpreuve=?"; 
						
	
	/**
	 * Récupère toues les épreuves liées à un user
	 * @param idUtilisateur
	 * @return
	 * @throws SQLException
	 */
	public static List<Epreuve> getEpreuveByUserId(Integer idUtilisateur) throws SQLException{
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		idUtilisateur = 5;
		
		ArrayList<Epreuve> epreuves= new ArrayList<>();
		try {
			cnx = ConnexionProvider.getConnexion();
			stmt = cnx.prepareStatement(LISTER);
			stmt.setInt(1, idUtilisateur);
			rs = stmt.executeQuery();
			
			System.out.println(stmt);
			Epreuve uneEpreuve;
			while (rs.next()){
				uneEpreuve = new Epreuve(rs.getDate("dateDebutValidite"),rs.getDate("dateFinValidite"),rs.getInt("tempsEcoule"));
				uneEpreuve.setTest(TestDAO.getTestById(rs.getInt("idTest")));
				epreuves.add(uneEpreuve);
				System.out.println(uneEpreuve);
			}
		
		} catch (SQLException e) {
			throw new SQLException("Probleme sur la methode lister') :" +e.getMessage());
		} finally {
			//ConnexionProvider.closeConnexion(cnx, stmt);
		}
		
		return epreuves;
		
	}
	
	/**
	 * Récupère une Epreuve apar son Id
	 * @param idEpreuve
	 * @return
	 * @throws SQLException
	 */
	public static Epreuve getEpreuveById(Integer idEpreuve) throws SQLException{
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Epreuve epreuve= null;
		try {
			
			cnx = ConnexionProvider.getConnexion();
			stmt = cnx.prepareStatement(EPREUVE_BY_ID);
				stmt.setInt(1, idEpreuve);
			rs = stmt.executeQuery();
			if (rs.next()){
				epreuve = new Epreuve(rs.getDate("dateDebutValidite"),rs.getDate("dateFinValidite"),rs.getInt("tempsEcoule"));
				epreuve.setTest(TestDAO.getTestById(rs.getInt("idTest")));
			}
		
		} catch (SQLException e) {
			throw new SQLException("Probleme sur la methode lister') :" +e.getMessage());
		} finally {
			ConnexionProvider.closeConnexion(cnx, stmt);
		}
		
		return epreuve;
		
	}
	
}
