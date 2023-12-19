package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterCustomerServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		RegisterBean rb=new RegisterBean();
		rb.setUname(req.getParameter("uname"));
		rb.setPword(req.getParameter("pword"));
		rb.setFname(req.getParameter("fname"));
		rb.setLname(req.getParameter("lname"));
		rb.setAddr(req.getParameter("addr"));
		rb.setMid(req.getParameter("mid"));
		rb.setPhno(Long.parseLong(req.getParameter("phno")));
		int k=new RegisterCustomerDAO().insert(rb);
		if(k>0) {
		req.setAttribute("msg", "Customer registered successfully.......<br>");
		req.getRequestDispatcher("Register.jsp").forward(req, res);
//		}else {
	//		req.setAttribute("msg","Invalid Process");
		//	req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		
	}
}
