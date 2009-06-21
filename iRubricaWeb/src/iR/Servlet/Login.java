package iR.Servlet;


import iR.entity.Contact;
import iR.entity.User;
import iR.entityManager.ContactManagerLocal;
import iR.entityManager.UserManagerLocal;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.protocol.mailto.MailToURLConnection;




/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB UserManagerLocal managerUser;
	@EJB ContactManagerLocal managerContatto;
	
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
		
		request.getSession().setAttribute("op", request.getParameter("id"));
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

		}else if (managerUser.auth(username, passwd)) {
			
				
				User user = managerUser.findByUsername(username);
				if(user.getType().equals("inattesa"))
				{
					request.setAttribute("mgerrore", "Il tuo account non è ancora stato attivato!");
					getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
				}
				else	
				{
					request.getSession().setAttribute("logged_user", "si");		
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("mgbenvenuto","Benvenuto/a " + username);
					
					if(user.getType().equals("admin"))
					{
						List<User> lista_utenti = managerUser.allUser();
						if (lista_utenti.isEmpty()){
							request.getSession().setAttribute("lista_utenti", "nessun contatto");
						}else{
							request.getSession().setAttribute("lista_utenti", lista_utenti);
						}
					}
					
					//mi ricavo la lista dei contatti e la passo in una variabile di sessione
					//alla jsp al momento del login
					List<Contact> lista = managerContatto.ListAll();
					if (lista.isEmpty()){
						request.getSession().setAttribute("lista", "nessun contatto");
					}else{
						request.getSession().setAttribute("lista", lista);
					}
				
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("mgerrore", "Username o password errate!");
				getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);			
		}
			
	}
	}
