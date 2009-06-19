package iR.Servlet;


import iR.entity.Contact;
import iR.entity.User;
import iR.entityManager.ContactManagerLocal;
import iR.entityManager.UserManagerLocal;

import java.io.IOException;
import java.util.List;
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
			
/*				LoginStateLocal lsl = (LoginStateLocal)request.getSession().getAttribute("logged_user");
			//	System.out.println(lsl);
				  if (lsl==null){
					   try{
						   lsl = (LoginStateLocal)context.lookup("iRubrica/LoginState/local");
					       request.getSession().setAttribute("logged_user",lsl);
					   } catch (NamingException e)    {
					       e.printStackTrace();
					       throw new RuntimeException(e);
					   }
				  }
				  lsl.login(username);*/

				
				request.getSession().setAttribute("logged_user", "si");		
				
				User user = manager.findByUsername(username);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("mgbenvenuto","Benvenuto/a " + username);
				
				if(user.getType().equals("admin"))
				{
					List<User> lista_utenti = manager.allUser();
					if (lista_utenti.isEmpty()){
						request.getSession().setAttribute("lista_utenti", "nessun contatto");
					}else{
						request.getSession().setAttribute("lista_utenti", lista_utenti);
					}
				}
				
				//mi ricavo la lista dei contatti e la passo in una variabile di sessione
				//al momento del login
				Context contextContatto;
				ContactManagerLocal managerContatto  =null;
				try{
					contextContatto = new InitialContext();
					managerContatto = (ContactManagerLocal) contextContatto.lookup("iRubrica/ContactManager/local");
			
				}catch (NamingException e){
					 e.printStackTrace();
				}
			
				List<Contact> lista = managerContatto.ListAll();
				if (lista.isEmpty()){
					request.setAttribute("lista", "nessun contatto");
				}else{
					request.getSession().setAttribute("lista", lista);
				}
				
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}else{
				request.setAttribute("mgerrore", "Username o password errate!");
				getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

			
		}
			
	}
	}
