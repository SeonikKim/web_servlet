package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/product_list.do")
public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DTO
	dto_product pd = new dto_product();
	// select Model
	m_product mp = new m_product();

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {

		// 상품 한가지를 클릭했을 경우 Front-end에서 GET전송한 값
		String midx = rq.getParameter("midx");
		String pagename = ""; // 하나의 controller에서 2개의 뷰가 존재하기함

		if (midx == null) {
			ArrayList<ArrayList<String>> all = this.mp.product_all();
			rq.setAttribute("all", all);

			// jsp 로드하여 View 역할로 데이터 출력
			pagename = "./product_list.jsp";
		} else {// 상품 상세정보
			this.pd.setMidx(Integer.parseInt(midx));// dto로 전달
			this.mp.oneproduct(this.pd);// dto 객체를 model로 전달

			this.pd = this.mp.pd;//Controller에서 Model에 있는 DTO 가져오기
			
//			System.out.println(this.pd.getPnm());

			rq.setAttribute("dto", this.pd);//dto를 jsp로 전달하기위한 Attribute

			pagename = "./product_view.jsp";
		}
		RequestDispatcher rd = rq.getRequestDispatcher(pagename);
		rd.forward(rq, rp);

	}

}
