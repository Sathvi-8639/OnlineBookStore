package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/CustomerLog")
public class CustomerLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		RegisterBean rb=new CustomerLoginDAO().login(req.getParameter("uname"), req.getParameter("pword"));
		if(rb==null) {
			req.setAttribute("msg","Invalid Login Process");
		    req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
	
		HttpSession hs=req.getSession();
		hs.setAttribute("rbean",rb);
		req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	}

