package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.result.BinaryStreamValueFactory;

public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		int nidx =Integer.parseInt(rq.getParameter("nidx"));
		m_noticeview nv = new m_noticeview();
		//조회수 +1 증가 및 데이터 출력
		nv.viewcount(nidx);
		
		ArrayList<String> notice_v = nv.db_data;
		rq.setAttribute("notice_v", notice_v);
//		System.out.println(notice_v);
		
		RequestDispatcher rd = rq.getRequestDispatcher("./notice_view.jsp");
		rd.forward(rq, rp);
	}

}
