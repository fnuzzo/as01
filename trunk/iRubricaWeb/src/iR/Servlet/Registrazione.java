package iR.Servlet;

import iR.entity.User;
import iR.entityManager.UserManager;
import iR.entityManager.UserManagerLocal;


import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrazione
 */
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Context context;
		UserManagerLocal manager= null;;
		String email= request.getParameter("mail");
		String username= request.getParameter("username");
		try {
			context = new InitialContext();
			manager = (UserManagerLocal) context.lookup("iRubrica/UserManager/local");
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String password = request.getParameter("password1");
		String confirmPassword = request.getParameter("password2");

		if  (username.compareTo("")==0 || email.compareTo("")==0 ||password.compareTo("")==0 || confirmPassword.compareTo("")==0 ){
			request.setAttribute("errorMex","Riempire tutti i campi della registrazione!");
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
			
			
		}else{ 
			//Verifico che la password e il campo di conferma coincidano
     		if (password.compareTo(confirmPassword)!=0){
     			request.setAttribute("username",username);
     			request.setAttribute("email",email);
     			request.setAttribute("errorMex","Le due password non coincidono!");		  
     		}else if(manager.findByUsername(username) != null){
     			request.setAttribute("errorMex","UserName Gia' in uso!");
     		}else {
     			
			//qui entro nel caso in cui tutto va bene e sono pronto per inserire 
     		//l'user nel database
     			manager.addUser(username,email, password, "inattesa");
     			List<User> l= manager.allUser();
     			request.setAttribute("errorMex","user: "+username+" email: "+email+" password: "+password+" conferma pass: "+confirmPassword);
     			//request.setAttribute("errorMex","in database "+l.size());
     			User u = l.get(l.size()-1);
     			request.setAttribute("errorMex","id "+u.getId());
     		}
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
		}
	}

}
