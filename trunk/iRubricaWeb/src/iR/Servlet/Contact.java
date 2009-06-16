package iR.Servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getSession().setAttribute("link_clicked", "add");
		response.sendRedirect("contact.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Context context;		
		//rilevo i campi inseriti nel form di inserimento di un nuovo contatto
		String name = request.getParameter("name");
	    String surname = request.getParameter("surname");
	    String mail = request.getParameter("mail");
	    String phone = request.getParameter("phone");
	    String skype = request.getParameter("skype");
	    String cell = request.getParameter("cell");
	    String note = request.getParameter("note");
	    String adress = request.getParameter("adress");
	    
	    if (name.compareTo("")==0 || surname.compareTo("")==0 || adress.compareTo("")==0 
	    		|| (phone.compareTo("")==0 || cell.compareTo("")==0)){
			request.setAttribute("msgError","Inserisci almeno un numero di telefono!");
		}else{
			request.setAttribute("msgError","OK");
		}   
		getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}

}
