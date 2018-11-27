package fr.eni.qcm.dal;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

abstract class ConnexionProvider {

    public static Connection getConnexion() throws SQLException {
        Connection con =null;
        InitialContext context = null;
        DataSource ds = null ;
        try {
            context = new InitialContext();
        } catch (NamingException e) {
           throw new SQLException("Erreur d'accès au contexte initial : "+e.getMessage());
        }
        try {
            ds = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
        } catch (NamingException e) {
            throw new SQLException("Objet introuvable dans l'annuaire : "+e.getMessage());
        }
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            throw new SQLException("Impossible d'obtenir une connexion : "+e.getMessage());
        }
        return con;

    }

    public static void closeConnexion(Connection con, Statement stmt) throws  SQLException{
        try {
            stmt.close();
        }catch (SQLException e){
            throw new SQLException("Impossible de fermer le statement");
        }
        try {
            con.close();
        }catch (SQLException e){
            throw new SQLException("Impossiblde de fermer la connection à Jdbc" + e.getMessage());

        }

    }

}
