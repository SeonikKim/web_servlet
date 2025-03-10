package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;


public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con = null;
       PreparedStatement ps =null;
       PrintWriter pw = null;
       m_dbinfo db = new m_dbinfo();
       

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		this.pw = rp.getWriter();
		try {
			this.con = this.db.getConnection();//db연결 떄리기
			//받아오는 친구들
			String to_name = rq.getParameter("to_name"); 
			String to_mail = rq.getParameter("to_mail"); 
			String subject = rq.getParameter("subject"); 
			String context = rq.getParameter("context"); 
			String sql = "";//sql 쿼리문 때리는애
			int res = 0; // DB 결과 확인용
			
			sql = "insert into mail (midx,to_name,to_mail,subject,context,sendAt) values('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
//			System.out.println(sql);
			res = this.ps.executeUpdate();
			
			if(res>0) { // 성공
				this.pw.write("<script>alert('정상적으로 메일 보냄');location.href='./mailok.do';</script>");
			}
					 
		} catch (Exception e) {
			this.pw.write("<script>alert('정상적으로 메일 안보냄');history.go(-1);</script>");
			
		}finally {
			
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
