package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.qcm.beans.Section;

public class SectionDAO {
private static final String SELECT_BY_TEST = "SELECT * FROM SECTION_TEST INNER JOIN TEST ON SECTION_TEST.idTest=TEST.idTest WHERE TEST.idTest=?;";

	
	/**
	 * Retourne une Objet Test r�cup�r� par son ID
	 * @param idTest
	 * @return Test
	 * @throws SQLException
	 */
	public static ArrayList<Section> getSectionByTestId(int idTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Section> sections= null;
		Section section;
		try {

			cnx = ConnexionProvider.getConnexion();
			stmt = cnx.prepareStatement(SELECT_BY_TEST);
				stmt.setInt(1, idTest);
			rs = stmt.executeQuery();
			sections = new ArrayList<>();
			while (rs.next()) {
				section = new Section(rs.getInt("nbQuestionsATirer"));
				sections.add(section);
			}
		} catch (SQLException e) {
			throw new SQLException("Probleme sur la methode lister') :" + e.getMessage());
		} finally {
			ConnexionProvider.closeConnexion(cnx, stmt);
		}

		return sections;
}
	}
