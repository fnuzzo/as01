package iR.Servlet;

import iR.entity.Contact;
import iR.entityManager.ContactManagerLocal;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB ContactManagerLocal managerContatto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String ricerca_contatto = request.getParameter("ricerca_contatto");
		 String ricerca = request.getParameter("ricerca");
		 
		 List<Contact> risultati_ricerca = null;
		 
		 if(ricerca.equals("perNome")){
			 risultati_ricerca =  managerContatto.findByName(ricerca_contatto);
		 }
		 
		 if(ricerca.equals("perTelefono")){

		 }
		 
		 if(ricerca.equals("perEmail")){
			 risultati_ricerca =  managerContatto.findByEmail(ricerca_contatto);
		 }
		 
		 if (risultati_ricerca.isEmpty()){
				request.getSession().setAttribute("lista", "nessun contatto");
			}else{
				request.getSession().setAttribute("lista", risultati_ricerca);
			}	
		 request.getSession().setAttribute("link_clicked", "search_result");
		 getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}
	
	
}
