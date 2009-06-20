package iR.Servlet;

import iR.entity.User;
import iR.entityManager.UserManagerLocal;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB UserManagerLocal managerUser;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("act");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		
		if(act.equals("attiva"))
		{
			managerUser.changeStatus(username, "normale");
			request.setAttribute("ok_modifica","attiva");
		}
		if(act.equals("elimina"))
		{
			managerUser.removeUser(username);
			request.setAttribute("ok_modifica","elimina");
		}
		if(act.equals("modifica"))
		{
			managerUser.changeStatus(username, status);
			request.setAttribute("ok_modifica","modifica");
		}
		
		List<User> lista_utenti = managerUser.allUser();
		if (lista_utenti.isEmpty()){
			request.getSession().setAttribute("lista_utenti", "nessun contatto");
		}else{
			request.getSession().setAttribute("lista_utenti", lista_utenti);
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
