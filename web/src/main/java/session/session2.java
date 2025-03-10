package session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		//세션에 저장된 값을 가져올 때 getAttribute를 이용해처리
//		System.out.println(se.getAttribute("id")); //세션에 저장된 값 출력
//		System.out.println(se.getAttribute("name"));//세션에 저장된 값 출력
//		System.out.println(se.getAttribute("tel"));//세션에 저장된 값 출력
//		System.out.println(se.getMaxInactiveInterval());//세션 최대 유지시간 확인 클래스 (기본은 1800 (30분))
		request.setAttribute("se",se);
		RequestDispatcher rd = request.getRequestDispatcher("./session2.jsp");
		rd.forward(request, response);
		
		
		
	}

}
