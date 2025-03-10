package admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(//enctype 설정 시 무조건 세팅해야지 페이지 활성화됨
		fileSizeThreshold = 1024*1024*10, //모바일은 화질 좋으니까.. 크게
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*100
		)

@WebServlet("/mobileok")
public class mobileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;utf-8");
		String sec = rq.getParameter("security"); //hidden으로 받은 값
//		System.out.println(sec);
		if(!sec.equals("m")) {//hidden에 있는 값이 다를 경우
			PrintWriter pw = rp.getWriter();
			pw.write("<script>alert('ERR'); history.go(-1);</script>");
			pw.close();
		}
		else {//hidden 값이 맞을 경우
			try {
				new reviews(rq,rp);			
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		

	}

}
class reviews{//외부 클래스 사용 시 한글 깨짐 처리는 메인 doPost, doGet에서 처리함
	PrintWriter pw =null;
	public reviews(HttpServletRequest rq, HttpServletResponse rp)throws Exception {
	this.pw = rp.getWriter();
		String mname = rq.getParameter("mname");
		String pname = rq.getParameter("pname");
		String star = rq.getParameter("star");
		String mtext = rq.getParameter("mtext");
		Part p = rq.getPart("mfile");
		String fname= p.getSubmittedFileName();
		
//		String ori = rq.getServletContext().getRealPath("/review2/");
//		File f = new File(ori);
//		f.mkdir();
		
		if(fname!="") {//이미지가 첨부 되었을 경우
			String url = rq.getServletContext().getRealPath("/review/");
	
			p.write(url+fname);
		}
		this.pw.write("<script>alert('정상적으로 리뷰가 등록되었습니다');location.href=./mobile.html;</script>");
	}
}