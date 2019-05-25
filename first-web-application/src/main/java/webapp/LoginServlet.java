package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private UserValidationService userValidationService = new UserValidationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>");
		 * out.println("<head>"); out.println("<title>Yahoo!!!!!!!!</title>");
		 * out.println("</head>"); out.println("<body>");
		 * out.println("My First Servlet"); out.println("</body>");
		 * out.println("</html>");
		 */
		System.out.println("---------First");
		String name = request.getParameter("username");
		request.setAttribute("name", name);
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", request.getParameter("username"));
		request.setAttribute("password", request.getParameter("password"));
		System.out.println("---------post");
		
		boolean isValid = userValidationService.isValidUser(request.getParameter("username"),
				request.getParameter("password"));
		if (isValid) {
			request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

		}
	}

}