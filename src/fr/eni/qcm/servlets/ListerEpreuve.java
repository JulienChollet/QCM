package fr.eni.qcm.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.qcm.beans.Epreuve;
import fr.eni.qcm.beans.User;
import fr.eni.qcm.dal.EpreuveDAO;

/**
 * Servlet implementation class ListerEpreuve
 */
@WebServlet(name = "ListerEpreuve",urlPatterns = "/ListerEpreuve")
public class ListerEpreuve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerEpreuve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String typeListeAAfficher = request.getParameter("typeListeAAfficher");
	
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("idConnecte");
		
		List<Epreuve> epreuves = null;
		RequestDispatcher disp = null;
		
		try {
			epreuves = new ArrayList<>();
			epreuves = EpreuveDAO.getEpreuveByUserId(userId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		request.setAttribute("tableauEpreuves", epreuves);
		
		disp = request.getRequestDispatcher("/candidat");
		
		if (typeListeAAfficher.equals("Epreuves")){
			disp = request.getRequestDispatcher("/epreuves");}
		
		if (typeListeAAfficher.equals("Resultats")){
			disp = request.getRequestDispatcher("/resultats");}
		
	
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
