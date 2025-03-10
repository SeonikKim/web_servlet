package notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		int nidx =Integer.parseInt(rq.getParameter("nidx"));
		m_noticeview nv = new m_noticeview();
		
		nv.viewcount(nidx);
		RequestDispatcher rd = rq.getRequestDispatcher("./notice_view.jsp");
		rd.forward(rq, rp);
	}

}
