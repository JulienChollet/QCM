package fr.eni.qcm.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.qcm.beans.SectionTest;

public class SectionTestDAO {

		// REQ Affiche Question en front
		private final static String SELECT = "SELECT nbQuestionsATirer,idTest,idTheme FROM SECTION_TEST WHERE idTest=?";

		
		/** MODIFIER  (by_id)
		 * @throws SQLException */	
		public static SectionTest afficher(Integer idTest) throws SQLException{
			Connection cnx=null;
			PreparedStatement rqt=null;
			ResultSet rs = null;
			SectionTest st = null;
			
			try{
				cnx=ConnexionProvider.getConnexion();
				rqt=cnx.prepareStatement(SELECT);
				rqt.setInt(1,idTest);
				rs = rqt.executeQuery();
				
				if(rs.next()) {
					st = new SectionTest(rs.getInt("idTest"),rs.getInt("idTheme"),rs.getInt("nbQuestionsATirer"));
				}				
			}finally{
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			}
			return st;
		}
	}


