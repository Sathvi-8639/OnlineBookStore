package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/viewbook")
public class CustomerViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired.....");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}else {
			ArrayList<BookBean> al=new ViewAllBooksDAO().retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("CustomerView.jsp").forward(req, res);
		}
	}
}
