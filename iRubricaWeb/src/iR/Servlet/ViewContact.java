package iR.Servlet;

import iR.entity.Contact;
import iR.entityManager.ContactManagerLocal;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewContact
 */
public class ViewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB ContactManagerLocal managerContatto;
       
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

		
/*		Context contextContatto;
		ContactManagerLocal managerContatto =null;
		try{
			contextContatto = new InitialContext();
			managerContatto = (ContactManagerLocal) contextContatto.lookup("iRubrica/ContactManager/local");
	
		}catch (NamingException e){
			e.printStackTrace();				
		}*/
			
		
		//mi ricavo il contatto dall'id
		//pero prima converto l'id che ho ricato con il get in un intero
		int id = Integer.valueOf(idcontatto).intValue();
		Contact contatto = managerContatto.findById(id);

		//ris può assumere i valori "edit" e "del"
		if (ris != null){
			request.setAttribute("operazione",ris);	
			if (ris.equals("del") && idcontatto != null){
				//elimino il contatto 
				boolean canc = managerContatto.removeContact(id);
				
				if (canc){
					//aggiorno la lista dopo aver eliminato il contatto
					List<Contact> lista = managerContatto.ListAll();
					if (lista.isEmpty()){
						request.getSession().setAttribute("lista", "nessun contatto");
					}else{
						request.getSession().setAttribute("lista", lista);
					}	
					request.setAttribute("deleteOk", "Il contatto '"+contatto.getName()+" "+contatto.getSurname()+"' è stato eliminato!");
				}else{
					request.setAttribute("deleteErr", "Il contatto selezionato è gia stato cancellato o non esiste!");
				}
				
			}
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
