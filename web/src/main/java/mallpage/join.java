package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/join.do")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {

		footers ft = new footers();// abstract를 사용하여 copyright model의 데이터를 가져옴
		ft.fts();
		rq.setAttribute("cpdata", ft.cpdata);
		
		RequestDispatcher rd = rq.getRequestDispatcher("./join.jsp");
		rd.forward(rq, rp);

	}

}

class footers extends ab_footer {
	public footers() {
		this.fts();
	}
@Override
public void fts() {
	super.fts();
}
}