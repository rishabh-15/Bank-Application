package com.log;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.log.dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginDao  dao =new LoginDao();
		
		String uname = request.getParameter("uname");
		String acc = request.getParameter("acc");
		
		if(dao.check(uname, acc)) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			response.sendRedirect("welcome.jsp");
		}
		else {
			 String errorMessage ="";
		        request.setAttribute("errorMessage", errorMessage );
		        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);  
		}
	
	}
}
