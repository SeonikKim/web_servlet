package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class noticeok extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	HttpServletRequest : 데이터 전달 통신 규격 인터페이스
//	HttpServletResponse : 결과에 대한 응답 통신 규격 인터페이스
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {

		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		try {
			this.pw = rp.getWriter();
			String se = rq.getParameter("se");
			if(se.equals("korea.com")) {
				String subject = rq.getParameter("subject");
				String writer = rq.getParameter("writer");
				String wtext = rq.getParameter("wtext");
				
				rq.setAttribute("subject", subject);
				rq.setAttribute("writer", writer);
				rq.setAttribute("wtext", wtext);
				RequestDispatcher rd = rq.getRequestDispatcher("./noticeview.jsp");
				rd.forward(rq, rp);
				
			}
			else {
				this.pw.write("<script>alert('올바른 접근 방법이 아닙니다.'); history.go(-1);</script>");//입력했던 내용 유지 location은 사라짐
				
			}
		} catch (Exception e) {

		} finally {
			this.pw.close();
		}
	}

}
