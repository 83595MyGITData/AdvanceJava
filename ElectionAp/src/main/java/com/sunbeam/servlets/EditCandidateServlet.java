package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String stid=req.getParameter("id");
		int id=Integer.parseInt(stid);
		Candidate c = null;
		try(CandidateDao canDao = new CandidateDaoImpl();)
		{
			c=canDao.findById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.printf("<html>");
		out.printf("<head>");
		out.printf("<title>Edit Candidate</title>");
		out.printf("</head>");
		out.printf("<body>");
		out.printf("<h3>Online Voting</h3>");
		out.printf("<form method='post' action='editcand'>");
		
		out.printf(" <input type='hidden' name='id' value='%d'  readonly/><br/><br/>\n",c.getId());
		out.printf("Name: <input type='text' name='name' value='%s' /><br/><br/>\n",c.getName());
		out.printf("Party: <input type='text' name='party' value='%s' /><br/><br/>\n",c.getParty());		
		out.printf("Votes: <input type='text' name='votes' value='%d'  readonly/><br/><br/>\n",c.getVotes());
		out.println("<input type='submit' value='Update Candidate'/>");
		out.printf("</form>");
		out.printf("</body>");
		out.printf("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String stid=req.getParameter("id");
		System.out.println("id"+stid);

		int id =Integer.parseInt(stid);
		System.out.println("id"+id);
		String name=req.getParameter("name");
		String party =req.getParameter("party");
		String stVotes= req.getParameter("votes");
		int votes=Integer.parseInt(stVotes);
		Candidate c=new Candidate(id,name,party,votes);
		try(CandidateDao canDao = new CandidateDaoImpl();)
		{
			int count =canDao.update(c);
			//resp.sendRedirect("result");
			
			String msg="Candidates Edited: "+ count;
			req.setAttribute("message", msg);
			
			RequestDispatcher rd=req.getRequestDispatcher("result");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
	

}
