package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.encry_model;


@WebServlet("/adminok")
public class adminok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String adm_id = rq.getParameter("adm_id");
		String adm_pw = rq.getParameter("adm_pw");
		String adm_no = rq.getParameter("adm_no");
		System.out.println(adm_id);
		System.out.println(adm_pw);
		System.out.println(adm_no);
		encry_model em = new encry_model();
		//Model을 이용해 암호화된 내용을 복호화 진행
		String id = em.datadecode(adm_id);
		String pw = em.datadecode(adm_pw);
		String no = em.datadecode(adm_no);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(no);
		
		if(id.equals("admin") && pw.equals("a1234") && no.equals("0556")) {
			System.out.println("정상적으로 관리자 로그인");
		}
		else {
			System.out.println("회원 정보를 다시 확인하세요");
		}
	}

}
