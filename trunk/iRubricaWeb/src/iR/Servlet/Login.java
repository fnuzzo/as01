package iR.Servlet;


import iR.entity.Contact;
import iR.entityManager.ContactManagerLocal;

import iR.entityManager.UserManagerLocal;


import java.io.IOException;
import java.util.Collection;
//import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//entra qui quando dalla pagina contact.jsp faccio logout
		//setto logged_user a no e faccio redirect alla enter
		request.getSession().setAttribute("link_clicked", "no");
		request.getSession().setAttribute("logged_user", "no");
		request.getSession().setAttribute("mgbenvenuto", null);
		response.sendRedirect("enter.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	HttpSession session = request.getSession(true);	
		/*response.setContentType("text/html");
	    PrintWriter out = response.getWriter();*/
		//out.println("errore");
		
		Context context = null;
		UserManagerLocal manager = null;
		try {
			context = new InitialContext();
			
			manager = (UserManagerLocal) context.lookup("iRubrica/UserManager/local");
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("link_clicked", "no");
		
	    String username = request.getParameter("username_login");
	    String passwd = request.getParameter("pass_login");
    
	    request.getSession().setAttribute("logged_user", "no");
	    if (username==null ||  passwd==null ){
			request.setAttribute("mgerrore","Errore ricezione dati!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

		}else if (username.compareTo("")==0 || passwd.compareTo("")==0) {
			request.setAttribute("mgerrore","Username o password mancanti!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

		}else if (manager.auth(username, passwd)) {
				 
				request.getSession().setAttribute("logged_user", "si");
				request.getSession().setAttribute("mgbenvenuto","Benvenuto/a " + username);
				//devo passare la lista dei contatti una volta logato
	
				// PROVA ottenimento contatto ###########
//				Context contextContatto;
//				ContactManagerLocal managerContatto =null;
//				try{
//					contextContatto = new InitialContext();
//					managerContatto = (ContactManagerLocal) contextContatto.lookup("iRubrica/ContactManager/local");
									
//				}catch (NamingException e ){
//					e.printStackTrace();				
//				}
			//	Collection<Contact> lista = managerContatto.ListAll();
				request.setAttribute("lista", "pluto pluto");
				//########################################
				
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}else{
				request.setAttribute("mgerrore", "Username o password errate!");
				getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

			
		}
			
	}
	}
