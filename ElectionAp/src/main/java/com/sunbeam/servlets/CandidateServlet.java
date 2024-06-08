package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/candlist")

public class CandidateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			list = candDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("<center>");
		
		String userName= "";
		Cookie[] arr =req.getCookies();
		if(arr!=null)
		{
			for (Cookie c: arr)
			{
				if(c.getName().equals("uname"))
				{
					userName=c.getValue();
					break;
				}
			}
		}
				
		out.printf("Hello,%s<hr>\n",userName);
		
		out.println("<form method='post' action='vote'>");
		out.println("<h1>Welcome to Voting booth</h1><hr><hr>");
		for(Candidate c : list)
		{
			out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s)<br/>\n" ,c.getId(),c.getName(),c.getParty());
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		//out.println("</center>");

		out.println("</body>");
		out.println("</html>");
	}

}
