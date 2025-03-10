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

//@WebServlet("/movie")
public class movie extends HttpServlet {
	private static final long serialVersionUID = 1L;
PrintWriter pw = null;
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;utf-8");

		String uname = rq.getParameter("uname");
		String uphone = rq.getParameter("uphone");
		String mov = rq.getParameter("mov");
		String resdate = rq.getParameter("resdate");
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(uname);
		ar.add(uphone);
		ar.add(mov);
		ar.add(resdate);
		rq.setAttribute("ar", ar); // 까먹지 마세요
		RequestDispatcher rd = rq.getRequestDispatcher("./movie.jsp");
		rd.forward(rq, rp);

	}

}
