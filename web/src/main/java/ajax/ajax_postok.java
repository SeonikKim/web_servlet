package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax_postok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		/*
		CORS를 해결하기 위해 사용하는 방식의 코드이며, 해당 origin, credentials를 사용하여 
		도메인을 다르게 접근하더라도 Ajax 통신이 되도록 허락하는 명령어 
		*/
		rp.addHeader("Access-Control-Allow-Origin", "*");// * 대신 특정 IP 입력도 가능
		rp.addHeader("Access-Control-Allow-Credentials", "true");
		
		String userid = rq.getParameter("userid");
		String usermail = rq.getParameter("usermail");
		System.out.println(userid);
		System.out.println(usermail);
		String msg = "";// ok: 아이디 정상, no : 아이디 오류, error: backend오류
		this.pw= rp.getWriter();
		if (userid.equals("hong")&&usermail.equals("hong@nate.com")) {
			msg="no";
		} else {
			msg="ok";
		}
		this.pw.print(msg); //frontend에 보내는값
	}

}
