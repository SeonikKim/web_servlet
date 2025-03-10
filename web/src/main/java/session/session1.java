package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 session : 일정 시간동안 브라우저에 해당 값을 저장 및 유지시키는 방식(back-end);
 //밑에 두개는 보안이 안좋음
 cooke : 브라우저에 cache메모리에 값을 저장하는 방식(도메인 및 ip기준)(front, back-end);
 storage : 메모리에 저장(front, back-end);(로컬, 세션방식 2개)
 
 */
//session1 -> 세션을 생성하는 컨트롤러
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		response.setContentType("text/html; charset=utf-8");
		this.pw = response.getWriter();

		if (mid.equals("hong") && mpass.equals("a1234")) {// id, pw 확인
			String username= "홍길동";
			String tel= "0101010101010";
			//HttpSession : 브라우저 cache메모리에 데이터를 임시저장
			HttpSession se = request.getSession();
			se.setAttribute("id", mid);
			se.setAttribute("name", username);
			se.setAttribute("tel", tel);
			
		} else {
			this.pw.write("<script>alert('아이디 및 패스워드를 확인하세요'); history.go(-1);</script>");

		}
		this.pw.close();

	}

}
