package com.mvc.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		  PrintWriter out = response.getWriter(); out.println("<html>");
		  out.println("<head>"); out.println("<title>Yahoo!!!!!!!!</title>");
		  out.println("</head>"); out.println("<body>");
		  out.println("My First Servlet and I am so Happy"); out.println("</body>");
		  out.println("</html>");
		 

	}

}
