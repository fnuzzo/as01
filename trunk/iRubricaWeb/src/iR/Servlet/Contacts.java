package iR.Servlet;

import iR.entityManager.ContactManagerLocal;
import iR.entity.Contact;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
public class Contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacts() {
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
			
		String idcontact = request.getParameter("idcontact");
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
	    
    	if (name.equals("") && surname.equals("") && mail.equals("") && phone_home.equals("") 
    			&& phone_office.equals("") && cell.equals("") && note.equals("") && address_home.equals("")
    			&& address_office.equals("") && fax.equals("") && other.equals("") && web.equals("") 
    			&& city.equals("") && state.equals("")){
	    	
    		//quando la form è completamente vuota
    		request.setAttribute("msgError","La campi sono tutti vuoi. Riempire la form!");
    		if (!idcontact.equals("new")){ request.setAttribute("operazione","edit"); }
			
    	}else if (!name.equals("") && !surname.equals("") && !mail.equals("") && !city.equals("") && !state.equals("") 
	    		&& !address_home.equals("") && !phone_home.equals("")  ){
    		//quando ho inserito tutti i campi obbligatori
    	
    		if (idcontact.equals("new")){
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
				request.setAttribute("msgok", "Aggiunto nuovo contatto!!!");
				
				//aggiorno la lista nella variabile di sessione appena aggiungo un contatto
				List<Contact> lista = manager.ListAll();
				if (lista.isEmpty()){
					request.getSession().setAttribute("lista", "nessun contatto");
				}else{
					request.getSession().setAttribute("lista", lista);
				}		
			
	    	}else{
	    		request.setAttribute("msgok", "DA FAREEEE: Modificato contatto!!!");
	    	}
	    	request.getSession().setAttribute("link_clicked", "addOK");
			
	    }else{ 	//nel caso in cui non ho inserito tutti i campi obbligatori
			request.setAttribute("idcontact", idcontact);
			request.setAttribute("name", name);
		    request.setAttribute("surname", surname);
		    request.setAttribute("mail", mail);
		    request.setAttribute("phone_home", phone_home);
		    request.setAttribute("phone_office", phone_office);
		    request.setAttribute("cell", cell);
		    request.setAttribute("fax", fax);
		    request.setAttribute("other", other);
		    request.setAttribute("web", web);
		    request.setAttribute("city", city);
		    request.setAttribute("state", state);
		    request.setAttribute("address_home", address_home);
		    request.setAttribute("address_office", address_office);
		    request.setAttribute("note", note);
			request.setAttribute("msgError","Inserisci tutti i campi obbligatori");  
			if (!idcontact.equals("new")){ request.setAttribute("operazione","edit"); }
		}   

	    getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}


}

