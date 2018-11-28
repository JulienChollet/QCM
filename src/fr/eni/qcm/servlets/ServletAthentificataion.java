package fr.eni.qcm.servlets;

import fr.eni.qcm.beans.CodeProfil;
import fr.eni.qcm.beans.User;
import fr.eni.qcm.dal.UserDao;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAthentificataion", urlPatterns = "/gestionAuthentification")

public class ServletAthentificataion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        valider(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        valider(request, response);

    }

    protected void valider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        User userConnecte = null;

        userConnecte = (User)request.getAttribute("userConnecte");
        System.out.println("coucocuocucoucouc");


        /**
         * Verification d'une connection existante
         */
        if (userConnecte != null) {
            System.out.println("Connect� !");
            redirectionMenuAnimateur(request, response);
            return;
        }

        /**
         *
         * récupération des champs de connections
         */
        String mail = request.getParameter("mail");
        String mdp = request.getParameter("motdepasse");
        if ((mail == null) || (mail.length() == 0)
                || (mdp == null) || (mdp.length() == 0)) {
            dispatcher = getServletContext().getRequestDispatcher("/authentification");
            dispatcher.forward(request, response);
            return;
        }
        try {
            // Valider l'identification par rapport aux informations de la base
            userConnecte = UserDao.rechercher(mail, mdp);
            System.out.println(userConnecte);
            // Si l'authentification est r�ussie...
            if (userConnecte != null) {
                System.out.println("authentification reussie !");
                // Placer le bean dans le contexte de session
                request.setAttribute("userConnecte", userConnecte);
                System.out.println("userConnectee !" + userConnecte);
                // Pr�senter la r�ponse
                redirectionMenuAnimateur(request, response);
            }
            // ...sinon
            else {
                System.out.println("Pas Connect� !");
                // Retourner � l'�cran d'identification
                dispatcher = getServletContext().getRequestDispatcher("/index");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | NamingException sqle) {
            // Placer l'objet repr�sentant l'exception dans le contexte de requete
            request.setAttribute("erreur", sqle);
            // Passer la main � la page de pr�sentation des erreurs
            dispatcher = getServletContext().getRequestDispatcher("/erreurPage");
            dispatcher.forward(request, response);
            return;
        }
    }

    protected void redirectionMenuAnimateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

            // En fonction de la m�thode de redirection utilis�e (forward ou sendRedirect()),
            // l'utilisateur pourra voir ou non l'URL de la ressource :

            // L'utilisation d'un forward masque la nouvelle ressource demand�e (car tout
            // se passe au sein du serveur d'application)
            System.out.println("Redirection !");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/question");
            dispatcher.forward(request, response);

            // L'utilisation d'un sendRedirect expose le nom de la page � l'utilisateur (car
            // une reponse 302 est renvoy�e au navigateur qui doit obligatoirement connaitre l'URL
            // de la ressource pour refaire une requete HTTP)
            //response.sendRedirect(request.getContextPath()+"/animateur/menuAnimateurPage");
        }
    }



