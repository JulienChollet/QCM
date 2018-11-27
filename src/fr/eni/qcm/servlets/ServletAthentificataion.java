package fr.eni.qcm.servlets;

import fr.eni.qcm.beans.CodeProfil;
import fr.eni.qcm.beans.User;
import fr.eni.qcm.dal.UserDao;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAthentificataion", urlPatterns = "/gestionAuthentification")
public class ServletAthentificataion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String mail = request.getParameter("email");
       String mdp = request.getParameter("motdepasse");

        try {
            UserDao.rechercher(mail,mdp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }
}
