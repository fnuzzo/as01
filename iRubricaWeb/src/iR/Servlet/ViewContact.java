package iR.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewContact
 */
public class ViewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("link_clicked", "view");
		//mi ricavo il parametro passato col get
		String ris = request.getParameter("id");

		//richiamo la funzione che ricava i parametri dal db
		ricava_parametri(request);
		
		
		//ris può assumere i valori "edit" e "del"
		if (ris != null){
			if (ris.equals("edit")) { 
				request.setAttribute("operazione",ris);	
			}else if (ris.equals("del")){
				request.setAttribute("operazione",ris);	
			}
		}
		getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	public void ricava_parametri(HttpServletRequest request){
		request.setAttribute("idcontact", "007");
	/*	request.setAttribute("name", name);
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
	    request.setAttribute("note", note); */
		
		request.setAttribute("name", "Pluto");
	    request.setAttribute("surname", "Pippo");
	    request.setAttribute("mail", "pluto@libero.it");
	    request.setAttribute("phone_home", "123");
	    request.setAttribute("phone_office", "321");
	    request.setAttribute("cell", "111");
	    request.setAttribute("fax", "222");
	    request.setAttribute("other", "boooo");
	    request.setAttribute("web", "www.pirla.com");
	    request.setAttribute("city", "bologna");
	    request.setAttribute("state", "italia");
	    request.setAttribute("address_home", "via dei mille");
	    request.setAttribute("address_office", "via zamboni");
	    request.setAttribute("note", "farasssssssssssssssssss ssssssssssssssssssssssss sssssssssssssssssssssssssssssssssssssssssss???");
		
	}
}
