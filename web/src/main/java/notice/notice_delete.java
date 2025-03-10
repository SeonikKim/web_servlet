package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import shop.m_dbinfo;
import shop.m_md5;

//DB 게시물 삭제 처리 Controller
public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;

	m_dbinfo db = new m_dbinfo();// db정보
	m_md5 md5 = new m_md5();// md5 암호화
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
	rp.setContentType("text/html;charset=utf-8");
	String nidx = rq.getParameter("nidx");
	String ori_pw = rq.getParameter("ori_pw");
	String npw = rq.getParameter("npw");
	
	this.pw = rp.getWriter();
	try {
		if (nidx.equals(null) || npw.equals(null)) {//사용자가 입력한 pw와 nidx가 올바르게 post되지 않았을 경우 접근 해제
			this.pw.write("<script>alert('올바른 접근이 아닙니다.'); history.go(-1);</script>");
		}else {
			npw= md5.md5_code(npw);//사용자가 입력한 pw를 db저장된(암호화된)pw 와 비교 후 삭제
			if(npw.equals(ori_pw)) {
				this.con=db.getConnection();
				this.sql = "delete from notice where nidx=?";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, nidx);
				this.result = this.ps.executeUpdate();
				if(this.result>0) {
					this.pw.write("<script>alert('삭완. 삭제완료라는 뜻'); location.href='./notice_list.do';</script>");
					
				}
				
				
			}else {
				this.pw.write("<script>alert('패스워드가 다릅니다.'); history.go(-1);</script>");
			}
			
		}
	} catch (Exception e) {
		this.pw.write("<script>alert('DB 삭제 오류'); history.go(-1);</script>");
	}finally {
		try {
			this.ps.close();
			this.con.close();
			this.pw.close();
		} catch (Exception e) {
			System.out.println("DB 접속에 따른 해제권한 오류 발생");
		}
	}
	}

}
