package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired.......");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bCode=req.getParameter("bcode");
			int rqty=Integer.parseInt(req.getParameter("rqty"));
			ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("alist");
			Iterator<BookBean> it=al.iterator();
			BookBean bb=null;
			while(it.hasNext()) {
				bb=it.next();
				if(bCode.equals(bb.getCode())) {
					break;
					}
				}//end of while
			if(rqty<bb.getQty()) {
				int k=new PurchaseDAO().Purchase(rqty, bCode);
				
				if(k>0) {
				req.setAttribute("bbean", bb);
				req.setAttribute("msg","your payment is successfull.......");
				req.getRequestDispatcher("Purchase.jsp").forward(req, res);
				}
			}
			else {
			req.setAttribute("msg", "You got it wrong!!!");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			}
		}
	}
}

