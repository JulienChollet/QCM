package fr.eni.qcm.dal;

import fr.eni.qcm.beans.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    public static final String connectionQuery ="SELECT idUtilisateur, nom, prenom, email, password, codeProfil, codePromo FROM UTILISATEUR WHERE email = ? AND password = ?";

    public static User rechercher(String mail, String password) throws SQLException, NamingException {
        Connection cnx = null;
        PreparedStatement rqt = null;
        ResultSet rs = null;
        User utilisateur=null;


        try{
            cnx = ConnexionProvider.getConnexion();
            Statement statement = cnx.createStatement();
            rqt = cnx.prepareStatement(connectionQuery);
            rqt.setString(1, mail);
            rqt.setString(2, password);
            rs=rqt.executeQuery();

           while (rs.next()){
                utilisateur = new User();
                utilisateur.setIdUser(rs.getInt("idUtilisateur"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setPassword(rs.getString("password"));
                utilisateur.setProfil(rs.getInt("codeProfil"));
                utilisateur.setPromotion(rs.getString("codePromo"));
            }

        }finally{
            if (rqt!=null) rqt.close();
            if (cnx!=null) cnx.close();
        }
        return utilisateur;
    }

}
