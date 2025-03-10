package review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
		fileSizeThreshold = 1024*1024*5,
		maxFileSize = 1024*1024*6,
		maxRequestSize = 1024*1024*50
		)
public class io_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf8");
		
		Part p = request.getPart("mfile");
		String fname= p.getSubmittedFileName();
		if(fname!="") {//이미지가 첨부 되었을 경우
			String url = request.getServletContext().getRealPath("/notice/");
	
			p.write(url+fname);
		}
		
		
		
	}

}
