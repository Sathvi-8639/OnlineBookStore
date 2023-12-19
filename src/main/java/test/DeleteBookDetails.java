package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteBookDetails extends HttpServlet  {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired");
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
			bb.setCode(bCode);
			int k=new DeleteBookDAO().delete(bb);
			if(k>0) {
			req.setAttribute("msg", "Book Deleted Successfully...<br>");
			req.getRequestDispatcher("DeleteBook.jsp").forward(req, res);
			}
		}
		
	}
}
