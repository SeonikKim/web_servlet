package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/index.do")//공용작업 시엔 xml에 쓰기
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //copyright 정보 Model
	copyright cr = new copyright();
	

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		ArrayList<String> cpdata = this.cr.copyright_info();
		rq.setAttribute("cpdata", cpdata);
		
		RequestDispatcher rd = rq.getRequestDispatcher("./index.jsp");
		rd.forward(rq, rp);
	}

}
