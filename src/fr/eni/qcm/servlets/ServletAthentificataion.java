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

        String mailBdd = null;
        String passwordBdd = null;
        String nom = null;
        String prenom = null;
        String codePromo = null;
        int codeProfil = 0;
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        String mail = (String) request.getParameter("mail");
        String password = (String) request.getParameter("password");

        if (session.getAttribute("mail") == request.getParameter("mail")
                && session.getAttribute("password") == request.getParameter("password")) {
            this.getServletContext().getRequestDispatcher("/index").forward(request, response);
        }
        try {
            UserDao.rechercher(request.getParameter("mail"),request.getParameter("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }


        if (session.getAttribute("mail") == null){
            session.setAttribute("mail", mail);
            session.setAttribute("password", password);
            session.setAttribute("nom", nom);
            session.setAttribute("prenom", prenom);
            session.setAttribute("codeProfil", codeProfil);
            session.setAttribute("codePromo", codePromo);
        }
        if (mail.equals(mailBdd) && password.equals(passwordBdd)){
            request.setAttribute("session", session);

            // redirection
            for(CodeProfil p : CodeProfil.values()) {
                if(codeProfil == p.getCode()) {
                    switch(p) {
                        case CANDIDAT_LIBRE:
                        case STAGIAIRE:
                            response.sendRedirect("/index");
                            break;

                        case RESPONSABLE:
                            response.sendRedirect("/indexResponsable");
                            break;

                        case FORMATEUR:
                            response.sendRedirect("/index");
                            break;

                        case CELLULE_RECRUTEMENT:
                            response.sendRedirect("/index");
                            break;

                        case ADMIN:
                            response.sendRedirect("/admin");
                            break;
                    }
                    return;
                }
            }

            response.sendRedirect("/index");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }
}
