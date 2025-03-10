package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	//controller에 하나의 View 적용됩니다. 단, 해당 View 안에 여러개의 include(jsp)가 있는 상황
	//Tree Page라고 한대용
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String corp = "(사)에이핑크";
		rq.setAttribute("corp", corp);
		RequestDispatcher rd = rq.getRequestDispatcher("./main.jsp");
		rd.forward(rq, rp);
	}

}
