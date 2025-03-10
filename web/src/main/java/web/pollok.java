package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pollok")
public class pollok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public pollok() {
        super();
    }

//method = "get"
    //PrintWriter => Controller에서 종료(결과값에 대해서 처리)
    //RequestDispatcher => Controller -> view(jsp)에서 결과 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
		//위 두줄을 한 줄로 축약
		response.setContentType("text/html; charset=utf-8");
		
		//동일한 name => radio
		//getParameter : get, post 둘 다 동일하게 받음
		//getParameter~~~.intern()은 무조건 값이 넘어와야함
		//만약 intern 뒤에 붙였으면 무조건 try문 안에 넣어야함.
//		String word = request.getParameter("abc");
		String subject = request.getParameter("subject");
	
		//원시 배열로 받기
		String[] etc = request.getParameterValues("etc");//배열을 받을땐 getParameterValues로 받아야함
	
		//클래스 배열로 받기
//		ArrayList<String> etc = new ArrayList<String>(Arrays.asList(request.getParameterValues("etc")));
	
		PrintWriter pw = response.getWriter();
	
		try {
			request.setAttribute("subject", subject);//view에 출력 메서드
			request.setAttribute("etc", etc);//view에 출력 메서드(배열)
			RequestDispatcher rd = request.getRequestDispatcher("./pollok.jsp");
			rd.forward(request, response);
			
		}
		catch (Exception e) {
			pw.write("<script>alert('올바른 접근이 아닙니다.')</script>");
		}finally {
			pw.close();
		}
		
	}
}

