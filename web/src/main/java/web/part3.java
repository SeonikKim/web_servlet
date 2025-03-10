package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxRequestSize = 1024*1024*100
		)

@WebServlet("/part3")
public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 회원가입 완료

	PrintWriter pw = null;
	String url = null;//웹 경로를 저장하는 변수
	String filenm=null;//파일명을 저장하는 변수
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//한글값 안들어오면 빼도 됨
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		try {
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mpass = request.getParameter("mpass");
			String mmail = request.getParameter("mmail");
			String mtel = request.getParameter("mtel");
			Part mfile = request.getPart("mfile"); //첨부파일을 파트로
			if(mid.equals("")||mname.equals("")||mpass.equals("")||mmail.equals("")||mtel.equals("")) {
				this.pw.write("<script>alert('올바른 데이터 접근이 아닙니다.');history.go(-1); </script>");
			}else {
				this.filenm = mfile.getSubmittedFileName();//파일명
				if(this.filenm != null && this.filenm!="") {
					long size = mfile.getSize();
					if(size>2097152) {
						this.pw.write("<script>alert('첨부파일은 최대 2MB까지입니다.');history.go(-1); </script>");
					}else {//첨부파일 용량 2mb 이하일 경우 서버에 저장
						this.url = request.getServletContext().getRealPath("/user/");
						mfile.write(this.url+this.filenm);
						
					}
				}
			}
			//JSP에 값 전달
			request.setAttribute("mid", mid);
			request.setAttribute("mname",mname);
			request.setAttribute("mmail", mmail);
			request.setAttribute("mtel", mtel);
			request.setAttribute("image", this.filenm);
			
			RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
	
		}finally {
			
		}
	}

}
