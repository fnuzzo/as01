package iR.Servlet;

import java.io.IOException;
//import java.io.PrintWriter;
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
		request.getSession().setAttribute("link_clicked", "no");
		
	    String account = request.getParameter("username_login");
	    String password = request.getParameter("pass_login");
    
	    request.getSession().setAttribute("logged_user", "no");
	    if (account==null ||  password==null ){
			request.setAttribute("mgerrore","Errore ricezione dati!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

		}else if (account.compareTo("")==0 || password.compareTo("")==0) {
			request.setAttribute("mgerrore","Username o password mancanti!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);

		}else if ((account.equals("amy"))&& (password.equals("amy")) ) {
			request.getSession().setAttribute("logged_user", "si");
			request.getSession().setAttribute("mgbenvenuto","Benvenuto/a " + account);
			getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			//response.sendRedirect("contact.jsp");
		}else{
			request.setAttribute("mgerrore", "Username o password errate!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
			
		}
	    
	}   
}
