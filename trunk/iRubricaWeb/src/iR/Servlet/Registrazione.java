package iR.Servlet;

import iR.entity.User;
import iR.entityManager.UserManagerLocal;
import iR.util.InvioMail;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrazione
 */
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB UserManagerLocal managerUser;
	String email,password = null;
       
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
		String iduser = request.getParameter("iduser");
		request.setAttribute("iduser", "modifica");
		getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String iduser = request.getParameter("iduser");
		String username= request.getParameter("username");

		email = request.getParameter("mail");
		String old_password= request.getParameter("old_password");
		password = request.getParameter("password1");
		String confirmPassword = request.getParameter("password2");
		
		boolean matchFound = false;
		if (iduser.equals("new")){
		
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(email);
			matchFound = m.matches();

			if  (username.equals("") || email.equals("") ||password.equals("") || confirmPassword.equals("")){
				request.setAttribute("errorMex","Riempire tutti i campi della registrazione!");
				request.setAttribute("username",username);
     			request.setAttribute("email",email);
				
			}else if (!matchFound ){
				request.setAttribute("errorMex","La mail inserita non è valida!");
				request.setAttribute("username",username);
     			request.setAttribute("email",email);
				
			}else { 
				//Verifico che la password e il campo di conferma coincidano
	     		if (!password.equals(confirmPassword)){
	     			request.setAttribute("username",username);
	     			request.setAttribute("email",email);
	     			request.setAttribute("errorMex","Le due password non coincidono!");	
	     				     			
	     		}else if(managerUser.findByUsername(username) != null && iduser.equals("new")){
	     			request.setAttribute("errorMex","UserName Gia' in uso!");
	     			
	     		}else { //qui nel caso in cui tutto va bene e sono pronto per inserire l'user nel database
	     		 			
	     			//Se l'utente si chiama admin lo faccio admin (per poter eseguire i test)
	     			if(username.equals("admin")){
	     				managerUser.addUser(username, email, password, "admin");
	     			}else{ 
	     				managerUser.addUser(username, email, password, "inattesa"); 
	     			}
	     			request.setAttribute("errorMex", null);
	     			request.setAttribute("okMex", "Utente in attesa di autenticazione!");
	     			InvioMail.invioEmail(email, "Registrazione", "In attesa di conferma autenticazione.");
	     					     			
	     		}
			}
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
			
		}else if (iduser.equals("mod")){
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(email);
			matchFound = m.matches();
			
			if (email.equals("")){
				request.setAttribute("errorMex","Il campo mail è obbligatorio!");
				request.setAttribute("iduser", "modifica");
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}else if (!matchFound ){
				request.setAttribute("errorMex","La mail inserita non è valida!");
				request.setAttribute("iduser", "modifica");
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}else if (!password.equals(confirmPassword)){
				request.setAttribute("email",email);
     			request.setAttribute("errorMex","Le due password non coincidono!");
     			request.setAttribute("iduser", "modifica");
     			getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}else {
     			
				if(password.equals("")){ password = old_password; }
				managerUser.updateUser(username, email, password);
 				
				User us = managerUser.findByUsername(username);
				request.setAttribute("modifica_ok", "ok");
				request.setAttribute("iduser", null);
				request.getSession().setAttribute("user", us);
				getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			}
   			
	
		}else if  (iduser.equals("recupera")){
     		if (!username.equals("")){
     			User us = managerUser.findByUsername(username);
     			email = us.getMail();
     			password = us.getPasswd();
     			InvioMail.invioEmail(email, "Recupera password", username+" la tua password è "+password);
     			request.setAttribute("okMex", "La password ti è stata inviata via mail!");
     			
     		}else{
     			request.setAttribute("errorMex", "inserisci l'username");
     		}
     		getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
     	}
	}


}
