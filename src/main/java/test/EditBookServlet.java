package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bCode=req.getParameter("bcode");
			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("alist");
			BookBean bb=null;
			Iterator<BookBean> it=al.iterator();
			while(it.hasNext()) {
				bb=it.next();
				if(bCode.equals(bb.getCode())) {
					break;
				}
			}
			req.setAttribute("bbean", bb);
			req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
		}
	}
}
