package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginDao ld = new LoginDao();
		
	resp.setContentType("text/html");
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	
	try {
		PrintWriter pw = resp.getWriter();
		if(ld.validate(username, password)==true) {
			RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
			rd.forward(req, resp);
		}
		else {
			
			pw.print("<h2>usernmae and password is incorrect </h2>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
		    rd.include(req, resp);
			
			
		}
	} catch (Exception e) {

		e.printStackTrace();
	}
	}

}
