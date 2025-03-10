package review;

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

public class coupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uid = request.getParameter("uid");
		String cpnum = request.getParameter("cpnum");
		String[] cparr = { "A1316B1004", "C4024A0096", "B1987C3136" };
		ArrayList<String> resarr = new ArrayList<String>(Arrays.asList(cparr));

		pw = response.getWriter();

		request.setAttribute("uid", uid);
		request.setAttribute("cpnum", cpnum);
		if (!resarr.contains(cpnum)) {
			this.pw.write("<script>alert('해당 쿠폰번호를 확인하세요.');history.go(-1); </script>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("./coupon2.jsp");
			rd.forward(request, response);
			this.pw.close();

		}
	}
}
