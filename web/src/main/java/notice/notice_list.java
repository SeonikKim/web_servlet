package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//List는 프론트에서 값을 받아서 띄우는게 아니기 때문에 꼭 ! doGet으로 해야합니다 ~ 
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		m_noticelist nl = new m_noticelist();//list를 출력하기 위한 DB table 로드
		ArrayList<ArrayList<String>> result = nl.db_data();//2차 클래스배열로 저장된 table에 모든 데이터 세팅
		
//		System.out.println(result); // result 잘 오는지 확인 ~ 
		rq.setAttribute("result", result);//jsp로 2차 클래스 배열 값을 전달(view)
		//실행은 do로 하는거임 jsp로하면 오류남 
		RequestDispatcher rd = rq.getRequestDispatcher("./notice_list.jsp");
		rd.forward(rq, rp);
		
	}

}
