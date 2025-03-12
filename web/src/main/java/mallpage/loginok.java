package mallpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mallpage/loginok.do")
public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	m_member mb = new m_member();// DTO 선언
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		rp.setContentType("text/html;charset=utf-8");
		this.pw = rp.getWriter();
		this.mb.setMid(rq.getParameter("mid"));
		this.mb.setMpass(rq.getParameter("mpass"));
		
		copyright cr = new copyright();
		//Controller => model로 DTO를 이용해 값을 전송
		String result = cr.user_login(this.mb);
		
		//Modrl에서 DTO를 생성한 값을 Controller에 받는 역할
		m_member mb2 = cr.mb;
		
	
		System.out.println(mb2.getMname());
		if(result=="ok") {//성공
			// Model에서 적용된 DTO값을 받아서 session생성
			//HttpSession : controller(loginok, logout)에서만 설정
			HttpSession session = rq.getSession();
			session.setAttribute("mid",mb2.getMid());
			session.setAttribute("mname",mb2.getMname());
			session.setAttribute("memail",mb2.getMemail());
			
			pw.write("<script>alert('로그인 하셨습니다.');location.href='./index.do';</script>");
		}else {
			pw.write("<script>alert('아이디 또는 비밀번호가 일치하지않습니다.');history.go(-1);</script>");
			
		}
		this.pw.close();
		
		
		
	}

}
