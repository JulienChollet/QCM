package fr.eni.qcm.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.beans.Question;
import fr.eni.qcm.beans.QuestionEpreuve;
import fr.eni.qcm.beans.SectionTest;
import fr.eni.qcm.dal.QuestionDAO;
import fr.eni.qcm.dal.QuestionTirageDAO;
import fr.eni.qcm.dal.SectionTestDAO;
import fr.eni.qcm.dal.TestDAO;

/**
 * Servlet implementation class GestionQuestionsServlet
 */
@WebServlet(name = "GestionQuestionsServlet", urlPatterns = "/GestionQuestionsServlet")
public class GestionQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionQuestionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random randomGenerator = new Random();
		QuestionEpreuve questionEpreuve= null;
		RequestDispatcher rd;

        int testId = Integer.parseInt(request.getParameter("idEpreuve"));
		try {

			//1. on charge les questions
			ArrayList<Integer> listStock = new ArrayList<>();
			SectionTest section = null;
			TestDAO.getTestById(testId);
			//aller chercher en fonction de l'id du theme la section de questions
			section = SectionTestDAO.afficher(testId);
			ArrayList<Question> questionsByTheme = QuestionDAO.afficherQuestionByTheme(section.getIdTheme());
			// Id Thème 2 = 4 questions (section.getNombreQuestion = 4)
            ArrayList<Question> questionsSelectionnees = new ArrayList<>();

            //Melange du tableau
                Collections.shuffle(questionsByTheme);
				for (int i = 0; i < section.getNombreQuestion(); i++) {
                    questionsSelectionnees.add(questionsByTheme.get(i));
                }

                //Tirage des premieres questions du tableau
                for(Question q : questionsSelectionnees){

                    Integer idQuestion = q.getIdQuestion();
                    Integer idEpreuve = TestDAO.getIdEpreuveByTest(testId);

                    questionEpreuve= new QuestionEpreuve(idQuestion, questionsSelectionnees.indexOf(q), idEpreuve);
                    QuestionTirageDAO.ajouterQE(questionEpreuve);
                }


			/** B _ Envoi la liste Aléatoire en fonction du theme choisit à l'affichage */

			rd = request.getRequestDispatcher("/question");
			request.setAttribute("questions", questionsByTheme);
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession();
		User userConnecte = (User)session.getAttribute("userConnecte");
		if (userConnecte.equals(null)) {
			request.getRequestDispatcher("/authentification").forward(request, response);
			return;
		}*/
		//doGet(request, response);
       // RequestDispatcher dispatcher;
       /* Integer idEpreuve =0;
        idEpreuve = Integer.parseInt(request.getParameter("idEpreuve"));
        dispatcher=  request.getRequestDispatcher("/question");
        dispatcher.forward(request, response);*/
	}

}
