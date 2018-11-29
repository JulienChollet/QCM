package fr.eni.qcm.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.beans.Epreuve;
import fr.eni.qcm.dal.EpreuveDAO;

/**
 * Servlet implementation class SelectionEpreuve
 */
@WebServlet(name = "SelectionEpreuve", urlPatterns ="/SelectionEpreuve" )

public class SelectionEpreuve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionEpreuve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO Récupérer ID dans SESSION
		//int userId;
		int userId = 5;
		Epreuve epreuve;
		int epreuveId= Integer.parseInt(request.getParameter("idEpreuve"));
		RequestDispatcher disp = null;
	
		try {
			epreuve = EpreuveDAO.getEpreuveById(epreuveId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		request.setAttribute("epreuve", epreuveId);
		
		
			disp = request.getRequestDispatcher("/WEB-INF/epreuves.jsp");
		
		
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
