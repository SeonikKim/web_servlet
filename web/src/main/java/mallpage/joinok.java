package mallpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/mallpage/joinok.do")
public class joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		this.pw = rp.getWriter();
		
		String mid = rq.getParameter("mid");
		String mapss = rq.getParameter("mpass");
		String mname = rq.getParameter("mname");
		String memail = rq.getParameter("memail");
		String mtel = rq.getParameter("mtel");
		
		String event_mail = rq.getParameter("event_mail");
		if(event_mail==(null)) {
			event_mail="N";
		}
		String event_sms = rq.getParameter("event_sms");
		if(event_sms==(null)) {
			event_sms="N";
		}
		//컬럼이 많아서 DTO 만들어서 날릴꺼임(m_member.java)
		//DTO(setter 메서드에 Frontend가 전달한 값을 모두 이관)
		m_member dto = new m_member();
		dto.setMid(mid);
		dto.setMpass(mapss);
		dto.setMname(mname);
		dto.setMemail(memail);
		dto.setMtel(mtel);
		dto.setEvent_mail(event_mail);
		dto.setEvent_sms(event_sms);
		//DTO값을 insert model로 전달함
		Integer result = new insert_join().insert_member(dto);
		if(result>0) {//성공
			pw.write("<script>alert('회원가입 성공!'); location.href='./login.do';</script>");
		}else {//실패
			pw.write("<script>alert('회원가입이 실패했습니다...'); history.go(-1);</script>");
		}
		this.pw.close();
	}

}
