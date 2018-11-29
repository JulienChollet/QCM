package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.qcm.beans.Test;

public class TestDAO {
	private static final String SELECT_BY_ID = "SELECT idEpreuve, EPREUVE.idTest, libelle, description, duree, seuil_haut, seuil_bas FROM dbo.TEST INNER JOIN EPREUVE ON EPREUVE.idTest=TEST.idTest WHERE EPREUVE.idTest=?;";

	
	/**
	 * Retourne une Objet Test r�cup�r� par son ID
	 * @param idTest
	 * @return Test
	 * @throws SQLException
	 */
	public static Test getTestById(int idTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Test test = null;

		try {

			cnx = ConnexionProvider.getConnexion();
			stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, idTest);
			rs = stmt.executeQuery();
			while (rs.next()) {
				test = new Test(idTest, rs.getString("libelle"), rs.getString("description"), rs.getInt("duree"),
						rs.getFloat("seuil_haut"), rs.getFloat("seuil_bas"));
				test.setSections(SectionDAO.getSectionByTestId(rs.getInt("idTest")));
			}
		} catch (SQLException e) {
			throw new SQLException("Probleme sur la methode lister') :" + e.getMessage());
		} finally {
			ConnexionProvider.closeConnexion(cnx, stmt);
		}

		return test;
	}
	public static Integer getIdEpreuveByTest(int idTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int idEpreuve = 0;

		try {
		cnx = ConnexionProvider.getConnexion();
		stmt = cnx.prepareStatement(SELECT_BY_ID);
		stmt.setInt(1, idTest);
		rs = stmt.executeQuery();
		if (rs.next()) {
			idEpreuve=rs.getInt("idEpreuve");
		}
	} catch (SQLException e) {
		throw new SQLException("Probleme sur la methode lister') :" + e.getMessage());
	} finally {
		ConnexionProvider.closeConnexion(cnx, stmt);
	}
		return idEpreuve;
	}

}
