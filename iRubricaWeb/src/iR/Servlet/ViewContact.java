package iR.Servlet;

import iR.entity.Contact;
import iR.entity.User;
import iR.entityManager.ContactManagerLocal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
		String ris = request.getParameter("op");
		String idcontatto = request.getParameter("idcon");

		
		Context contextContatto;
		ContactManagerLocal managerContatto =null;
		try{
			contextContatto = new InitialContext();
			managerContatto = (ContactManagerLocal) contextContatto.lookup("iRubrica/ContactManager/local");
	
		}catch (NamingException e){
			e.printStackTrace();				
		}
		
		//mi ricavo il contatto dall'id
		//pero prima converto l'id che ho ricato con il get in un intero
		int id = Integer.valueOf(idcontatto).intValue();
		Contact contatto = managerContatto.findById(id);

		//ris può assumere i valori "edit" e "del"
		if (ris != null){
			request.setAttribute("operazione",ris);	
		}else if (idcontatto != null){
			request.getSession().setAttribute("contatto", contatto);
		}
		getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
