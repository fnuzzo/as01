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
		request.setAttribute("name", "Pluto");
	    request.setAttribute("surname", "Pippo");
	    request.setAttribute("mail", "pluto@libero.it");
	    request.setAttribute("phone", "0541001122");
	    request.setAttribute("cell", "3331212123");
	    request.setAttribute("skype", "plutopluto");
	    request.setAttribute("adress","Via dei campanelli 31. 61432 Bologna BO");
	    request.setAttribute("note", "farasssssssssssssssssss ssssssssssssssssssssssss sssssssssssssssssssssssssssssssssssssssssss???");
		
	}
}
