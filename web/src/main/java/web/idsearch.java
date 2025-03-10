package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idsearch")
public class idsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public idsearch() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//text/html은 do를 text/html형식으로 가상으로 만들기 때문
		PrintWriter pw = response.getWriter();

		try {

			// FE에서 값 받아오기
			String uname = request.getParameter("uname");
			String uphone = request.getParameter("uphone");
			String umail = request.getParameter("umail");
			int chkp = Integer.parseInt(uphone);
			String res = "가입정보가 확인되지 않습니다.";
			//조건문은 여기서 해결하는게 좋음
			if (uname.equals("홍길동") && uphone.equals("01010041919") && umail.equals("hong@naver.com")) {
				res = "hong2025";
			}
			request.setAttribute("res", res);
			// RequestDispatcher : View를 선언하여 웹페이지에 출력되도록 설정
			RequestDispatcher rd = request.getRequestDispatcher("/idsearch.jsp");
			rd.forward(request, response);

		} catch (Exception e) {// front-end 값이 숫자로 변환 시 비정상적일 경우 해당 스크립트 실행
			pw.write("<script>" + "alert('올바른 전화번호 값을 넣어주세요.');" + "history.go(-1);" + "</script>");

		}finally {
			pw.close();
		}

	}

}
