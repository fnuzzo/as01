package iR.Servlet;

import iR.entityManager.ContactManagerLocal;
import iR.entity.Contact;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Contact
 */
public class Contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB ContactManagerLocal managerContatto;
	
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

		String page = request.getParameter("p");
		if (page.equals("1")){
			request.getSession().setAttribute("link_clicked", "no");
		}else if(page.equals("2")){
			request.getSession().setAttribute("link_clicked", "add");
		}
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
	    String idcontact = request.getParameter("idcontact");
	    int idCreatore = Integer.parseInt(request.getParameter("idCreatore"));
	    Date insertDate = null;
	    
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
									
				//cerco un contatto con gli stessi campi (name,surname,mail,phone_home)
				//del contatto che sto cercando di inserire
				List<Contact> utenti_esistenti = managerContatto.findByCombo(name, surname, mail, phone_home);
				
				if (utenti_esistenti.isEmpty()){
					managerContatto.addContact(name, surname, phone_home, phone_office, cell, 
								address_home, address_office, fax, mail, insertDate, note, 
								idCreatore, other, web, city, state);
					request.setAttribute("msgok", "Aggiunto nuovo contatto!!!");
				
					//aggiorno la lista nella variabile di sessione appena aggiungo un contatto
					List<Contact> lista = managerContatto.ListAll();
					if (lista.isEmpty()){
						request.getSession().setAttribute("lista", "nessun contatto");
					}else{
						request.getSession().setAttribute("lista", lista);
					}		
					request.getSession().setAttribute("link_clicked", "addOK");
					
				}else {
					//entro qui se il contatto che inserisco è gia presente in rubrica
					request.setAttribute("msgError", "Utente gia presente in rubrica!!!");
				}
			
	    	}else{
	    		
	    		int idcontact_int = Integer.valueOf(idcontact).intValue();
	    	   
	    		//modifico un contatto gia esistente
	    //		managerContatto.updateContact(idcontact_int, name, surname, phone_home, phone_office, cell, address_home, address_office, fax, mail, insertDate, note, idCreatore,	other, web, city, state);
	    		    				
	    		request.setAttribute("msgok", "DA FAREEEE: Modificato contatto!!!");
	    		request.getSession().setAttribute("link_clicked", "addOK");
	    	}
	    	
			
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

