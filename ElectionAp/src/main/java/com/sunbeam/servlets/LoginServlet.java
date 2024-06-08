package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		process(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		process(req,resp);
	}
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try(UserDao userDao = new UserDaoImpl())
		{
			User user = userDao.findByEmail(email);
			if(user!=null && user.getPassword().equals(password))
			{
				System.out.println("Login Succesfull " + user);
				
				Cookie c = new Cookie("uname" ,user.getFirstName());
				c.setMaxAge(3600);
				resp.addCookie(c);
				
				HttpSession session = req.getSession();
				session.setAttribute("currentuser", user);
				
				if(user.getRole().equals("voter")) {
					resp.sendRedirect("candlist");
					
				}
				else
				{
					resp.sendRedirect("result");
				}
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invalid Email/Password </br>");
				out.println("<a href='index.html'>login again</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
