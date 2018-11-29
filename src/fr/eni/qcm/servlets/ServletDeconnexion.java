package fr.eni.qcm.servlets;

import fr.eni.qcm.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletDeconnexion",  urlPatterns = "/deconnexion")
public class ServletDeconnexion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userConnecte = (User)request.getSession().getAttribute("userConnecte");
        if (userConnecte == null) {
            request.getRequestDispatcher("/index").forward(request, response);
            return;
        }

        request.getParameter("mail");
        if(request.getSession().getAttribute("mail") == null){
            response.sendRedirect("/index");
        } else {
            request.getSession().getAttribute("mail");
            request.getSession().invalidate();
            response.sendRedirect("/index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
