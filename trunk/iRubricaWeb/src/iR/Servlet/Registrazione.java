package iR.Servlet;

import iR.entity.User;
import iR.entityManager.UserManagerLocal;
import iR.util.DesEncrypter;
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
//		String iduser = request.getParameter("iduser");
		String idmod = request.getParameter("idmod");
		if (idmod.equals("1")){
			request.setAttribute("iduser", "modifica_mail");
		}else if (idmod.equals("2")){
			request.setAttribute("iduser", "modifica_pass");
		}
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
		password = request.getParameter("password1");
		String confirmPassword = request.getParameter("password2");
		
		boolean matchFound = false;
		if (iduser.equals("new")){
		
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(email);
			matchFound = m.matches();
			
			request.setAttribute("username",username);
 			request.setAttribute("email",email);

			if  (username.equals("") || email.equals("") ||password.equals("") || confirmPassword.equals("")){
				request.setAttribute("errorMex","Riempire tutti i campi della registrazione!");
					
			}else if (!matchFound ){
				request.setAttribute("errorMex","La mail inserita non è valida!");
				
			}else { 
				//Verifico che la password e il campo di conferma coincidano
	     		if (!password.equals(confirmPassword)){
	     			request.setAttribute("errorMex","Le due password non coincidono!");	
	     		     				     			
	     		}else if(managerUser.findByUsername(username) != null && iduser.equals("new")){
	     			request.setAttribute("username",null);
	     			request.setAttribute("email",null);
	     			request.setAttribute("errorMex","UserName Gia' in uso!");
	     			
	     		}else { //qui nel caso in cui tutto va bene e sono pronto per inserire l'user nel database
	     		 	
	     			String encrypted_password = null;
	     			try {
	     		        DesEncrypter encrypter = new DesEncrypter();
	     		        encrypted_password = encrypter.encrypt(password);
	       		    } catch (Exception e) {
	     		    }
	     			
	     			//Se l'utente si chiama admin lo faccio admin (per poter eseguire i test)
	     			if(username.equals("admin1")){
	     				managerUser.addUser(username, email, encrypted_password, "admin");
	     			}else{ 
	     				managerUser.addUser(username, email, encrypted_password, "inattesa"); 
	     			}
	     			request.setAttribute("errorMex", null);
	     			request.setAttribute("username",null);
	     			request.setAttribute("email",null);
	     			request.setAttribute("okMex", "Utente in attesa di autenticazione!");
	     			InvioMail.invioEmail(email, "Registrazione", "Salve "+username+"\nOra il tuo account e' in attesa di conferma.\n ");
	     					     			
	     		}
			}
			getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
			
		}else if (iduser.equals("mod_mail")){
			
			request.setAttribute("iduser", "modifica_mail");
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = p.matcher(email);
			matchFound = m.matches();
			
			User us = managerUser.findByUsername(username);
			String password = us.getPasswd();
			
			if (email.equals("")){
				request.setAttribute("errorMex","Il campo mail e' obbligatorio!");

			}else if (!matchFound ){
				request.setAttribute("errorMex","La mail inserita non e' valida!");

			}else{
				managerUser.updateUser(username, email, password);
				
				request.setAttribute("modifica_ok", "Email utente modificata con successo.");
				request.setAttribute("iduser", null);
				us = managerUser.findByUsername(username);
				request.getSession().setAttribute("user", us);
								
			}
			getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
			
		}else if  (iduser.equals("mod_pass")){
			
			request.setAttribute("iduser", "modifica_pass");
			User us = managerUser.findByUsername(username);
			String real_old_password = us.getPasswd();
			String email = us.getMail();
			
			String old_password= request.getParameter("old_password");
 							
			if(password.equals("") || confirmPassword.equals("") || old_password.equals("") ){ 
				request.setAttribute("errorMex","Riempire tutti i campi per modificare la password!");
			}else {
				String encrypted_old_password = null;
				String encrypted_password = null;
				try {	     
			        DesEncrypter encrypter = new DesEncrypter();
			        encrypted_old_password = encrypter.encrypt(old_password);
			        encrypted_password = encrypter.encrypt(password);
			    } catch (Exception e) {}
			    
				if (!password.equals(confirmPassword)){
					request.setAttribute("errorMex","Le due nuove password non coincidono!");
				}else if (!encrypted_old_password.equals(real_old_password)){
					request.setAttribute("errorMex","La vecchia password non coincide!");
	     		
				}else{
					
					managerUser.updateUser(username, email, encrypted_password);
					
					request.setAttribute("modifica_ok", "Password utente modificata con successo.");
					request.setAttribute("iduser", null);
					request.getSession().setAttribute("user", us);
									
				}
			}
			getServletContext().getRequestDispatcher("/contact.jsp").forward(request, response);
				
		}else if  (iduser.equals("recupera")){
     		
			if (!username.equals("")){
				
				User us = managerUser.findByUsername(username);
				
				if (us == null){
	     			request.setAttribute("errorMex", "L'username non è presente nel database");
	     		}else{
	     			email = us.getMail(); 
	     			password = us.getPasswd();
     		
	     			String decrypted_password =null; 
	     			try {
		        		DesEncrypter encrypter = new DesEncrypter();
		        		decrypted_password = encrypter.decrypt(password);
		        	} catch (Exception e) {
		        	}
     			
		        	InvioMail.invioEmail(email, "Recupera password", username+" la tua password e' "+decrypted_password);
		        	request.setAttribute("okMex", "La password ti e' stata inviata via mail!");
	     		}
     		
     		}else{
     			request.setAttribute("errorMex", "inserisci l'username");
     		}
     		getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
     	}
	}


}
