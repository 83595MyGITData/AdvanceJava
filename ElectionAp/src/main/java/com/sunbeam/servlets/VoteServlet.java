package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentuser");
		System.out.println(user);
		int userId = user.getId();
		System.out.println("UserID:" + userId);
		String message = "";

		if (user.getStatus() == 0) {
			
			System.out.println("Status:"+user.getStatus());
			String candidateId = req.getParameter("candidate");
			int id = Integer.parseInt(candidateId);
			try (CandidateDao candDao = new CandidateDaoImpl()) {

				candDao.incrementVote(id);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
			message = "Your vote is registered  successfully<br><br>";

			try (UserDao userDao = new UserDaoImpl()) {
				userDao.updateStatus(userId, true);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else {
			message = "You have Already Voted..";
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("</head>");
		out.println("<body>");

		String userName = "";
		Cookie[] arr = req.getCookies();
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("uname")) {
					userName = c.getValue();
					break;
				}
			}
		}

		out.printf("Hello,%s<hr>\n", userName);

		out.println("<center><br><br><br><br><br><br>");
		out.println(message);
		out.println("<a href='logout'>Log out</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
