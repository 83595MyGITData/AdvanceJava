import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/hii" , loadOnStartup=0,
initParams= {
		@WebInitParam(name="color",value="pink")
})
public class HelloServlet2 extends HttpServlet {
	
	private String color = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		System.out.println("Hello init()");
		color=config.getInitParameter("color");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("Hello Destroy()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DoGet ()");
		process(req,resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("DoPost ()");
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	   resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.printf("<body bgcolor='%s'>\n" , color);
		out.println("<h1>Swapnil HelloServlet2</h1>");
		out.println("</body>");
		out.println("</html>");
   }

}
