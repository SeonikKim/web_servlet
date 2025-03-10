package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delivery")
public class delivery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	PrintWriter pw = null;

//	//이런식으로도 핸들링 가능.. 근데 뭐 더 추가해야함 나중에 알려주신대요
//	HttpServletRequest request;
//	HttpServletResponse response;
//
//	public delivery() throws Exception {
//		
//		this.request.setCharacterEncoding("utf-8");
//		this.response.setContentType("text/html;charset=utf-8");
//		this.pw = this.response.getWriter();
//	}

	//즉시실행 메서드(Servlet) : 주의※ 일반 class에서 사용하는 형태와는 구조가 다릅니다.
	//일반메서드가 됨
    public void delivery(HttpServletRequest request,HttpServletResponse response) {//action에서 해당 class실행하면 즉시메서드 실행
//    	즉시실행에 매개변수 태워서 사용 가능 단, 리턴 void 추가해서 사용해야함
//    	try~catch 쓰기 싫으면 throws exception 해도 됨
    	try {
    		request.setCharacterEncoding("utf-8");
    		response.setContentType("text/html;charset=utf-8");
    		this.pw = response.getWriter();
			
		} catch (Exception e) {
			System.out.println("해당 URL 경로가 올바르지 않습니다.");
		}
    }

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		this.delivery(rq, rp);

		String mname =rq.getParameter("mname");
		String mtel =rq.getParameter("mtel");
		String memail =rq.getParameter("memail");
		String maddr =rq.getParameter("maddress");
		//클래스배열 생성해서 보내기도 가능!
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(memail);
		data.add(maddr); //지금은 그냥 하지만.. DTO로 만들면 편합니다
		//setAttribute로 클래스배열 넘기기
		rq.setAttribute("data", data);
		RequestDispatcher rd = rq.getRequestDispatcher("./delivery.jsp");
		rd.forward(rq, rp);
		
	}

}
