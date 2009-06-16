package iR.Servlet;

import java.io.IOException;
/*import java.io.PrintWriter;*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prova
 */
public class Prova extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	static final long serialVersionUID = 33;

    /**
     * Default constructor. 
     */
    public Prova() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String contextPath= "http://localhost:8080/iRubricaWeb";
	    response.sendRedirect(response.encodeRedirectURL(contextPath + "/enter.jsp"));
		/* era la prova che quando cliccavo su un link stampava una pagina html
		 * response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Io sono un titolo!</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<h1>Questa è una prova!</h1>");
        out.println("</body>");
        out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
