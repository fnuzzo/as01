package iR.Servlet;

import iR.entityManager.ContactManagerLocal;

import java.io.IOException;
import java.util.Date;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
			
		//rilevo i campi inseriti nel form di inserimento di un nuovo contatto
		//Obbligatori: name, surname, almeno un tell, 
		String name = request.getParameter("name");
	    String surname = request.getParameter("surname");
	    String mail = request.getParameter("mail");
	    String phone_home = request.getParameter("phone_home");
	    String phone_office = request.getParameter("phone_office");
	    String cell = request.getParameter("cell");
	    String note = request.getParameter("note");
	    String address_home = request.getParameter("address_home");
	    String address_office = request.getParameter("address_office");
	    String fax = request.getParameter("fax");
	    String other = request.getParameter("other");
	    String web = request.getParameter("web");
	    String city = request.getParameter("city");
	    String state = request.getParameter("state");
	    
	 //   if (name.compareTo("")==0 || surname.compareTo("")==0 || adress.compareTo("")==0 
	//    		|| (phone.compareTo("")==0 || cell.compareTo("")==0)){
	//		request.setAttribute("msgError","Inserisci almeno un numero di telefono!");
		//}else{
			//salvati tutti i dati con successo
			
			Context context;
			ContactManagerLocal manager =null;
			try{
				context = new InitialContext();
				manager = (ContactManagerLocal) context.lookup("iRubrica/ContactManager/local");
								
			}catch (NamingException e ){
				e.printStackTrace();				
			}
			
			Date insertDate = null;
			Integer idCreatore = 1;
			manager.addContact(name, surname, phone_home, phone_office, cell, 
								address_home, address_office, fax, mail, insertDate, note, 
								idCreatore, other, web, city, state);
			
			request.getSession().setAttribute("link_clicked", "addOK");
			
	//	}   
		getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}

}
