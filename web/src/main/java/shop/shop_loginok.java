package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

public class shop_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement ps = null;
	HttpSession session = null;
	ResultSet rs = null; // select 사용할 때 사용
	
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rp.setContentType("text/html;charset=utf-8");
		
		String spart = rq.getParameter("spart");
		String sid = rq.getParameter("sid");
		String spw = rq.getParameter("spw"); // 사용자가 입력한 사항
		m_dbinfo dn = new m_dbinfo();
		this.pw = rp.getWriter();
		try {
			this.con = dn.getConnection(); // 사용자가 입력한 값을 암호화 해야만 db와 비교 가능
			spw= new m_md5().md5_code(spw); // 암호화
			String sql = ""; // DB 쿼리문 용
			
			String id = "";
			String pw = "";
			String nm = "";
			String no = "";
			if (spart.equals("P")) { // 개인
				sql = "select sid, spw, snm from shop_member where sid=?";
				this.ps= this.con.prepareStatement(sql);
				this.ps.setString(1, sid);
				this.rs= this.ps.executeQuery();
				
				while(this.rs.next()) {
					id = (this.rs.getString("sid"));
					pw = (this.rs.getString("spw"));
					nm = (this.rs.getString("snm"));
				}
				if(id.equals("")||nm.equals("")) { // 조회된 내용이 없을 경우
					this.pw.write("<script>alert('해당 아이디를 확인할 수 없습니다.'); history.go(-1);</script>");
					
				}else {//조회된 내용이 있을 경우
					if(spw.equals(pw)) { //사용자가 입력한 PW == DB에 저장된 PW 비교
						this.session = rq.getSession();// 세션 생성
						this.session.setAttribute("mid", id); //id 세션 등록
						this.session.setAttribute("mnm", nm); //이름 세션 등록
						this.pw.write("<script>alert('로그인되었습니다.'); location.href='./main.jsp';</script>");
						
					}
				}
				
			} else { // 사업자
				String sno = rq.getParameter("sno"); // 사업자번호
				sql = "select sid, spw, snm, sno from shop_member where sid=? and sno=?";
				this.ps= this.con.prepareStatement(sql);
				this.ps.setString(1, sid);
				this.ps.setString(2, sno);
				this.rs= this.ps.executeQuery();
				
				while(this.rs.next()) {
					id = (this.rs.getString("sid"));
					pw = (this.rs.getString("spw"));
					nm = (this.rs.getString("snm"));
				}
				if(id.equals("")||nm.equals("")) { // 조회된 내용이 없을 경우
					this.pw.write("<script>alert('해당 아이디를 확인할 수 없습니다.'); history.go(-1);</script>");
					
				}else {//조회된 내용이 있을 경우
					if(spw.equals(pw)) { //사용자가 입력한 PW == DB에 저장된 PW 비교
						this.session = rq.getSession();// 세션 생성
						this.session.setAttribute("mid", id); //id 세션 등록
						this.session.setAttribute("mnm", nm); //이름 세션 등록
						this.pw.write("<script>alert('사업자 회원 로그인되었습니다.'); location.href='./main.jsp';</script>");
						
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println("DB연결 실패");

		} finally {
			try {
				this.con.close();
				this.pw.close();
			} catch (SQLException e) {
				System.out.println("DB종료 실패");

			}
		}
		
		
		
	}

}
