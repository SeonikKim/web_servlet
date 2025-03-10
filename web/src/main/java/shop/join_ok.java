package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null; // DB연결 (SQL쿼리 실행용)

//	protected void service(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException{ // doGet , doPost -> service(모두 사용 가능하나 보안 약함 -> 테스트용)
//		System.out.println("doGet,doPost 모두 받음!");
//	}

//	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException { // doGet 기본 문법
//		m_dbinfo db = new m_dbinfo();
//		try {
//			this.con = db.getConnection();
//		} catch (Exception e) {
//			System.out.println("db연결 실패");
//		} finally {
//			try {
//				this.con.close(); // 닫을 때에도 try~catch로 감싸줌
//			} catch (SQLException e) {
//				System.out.println("db종료 실패");
//			}
//		}
//
//	}

	PrintWriter pw = null;
	PreparedStatement ps = null;
	
	//회원가입 진행
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		
		this.pw = rp.getWriter();
		m_dbinfo db = new m_dbinfo();
		try {
			this.con = db.getConnection();
			String spart = rq.getParameter("spart");
			String sid = rq.getParameter("sid");
			String spw = rq.getParameter("spw");
			String stel = rq.getParameter("stel");
			String semail = rq.getParameter("semail");
			String snm = rq.getParameter("snm");
			spw = new m_md5().md5_code(spw); // 문자 PW를 MD5로 암호화
//			System.out.println(spw);//암호화 확인용
			String sql="";//쿼리문 입력용
			
			if(spart.equals("P")) {//개인회원
				sql = "insert into shop_member values('0',?,?,?,?,?,?,null,now());";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, spart);//1부터 시작함
				this.ps.setString(2, sid);
				this.ps.setString(3, spw);
				this.ps.setString(4, snm);
				this.ps.setString(5, stel);
				this.ps.setString(6, semail);
				int result = this.ps.executeUpdate();
				if(result>0) { //정상적으로 DB에 insert 완료 시
					this.pw.write("<script>alert('회원가입이 정상적으로 완료되었습니다.'); location.href='./login.jsp';</script>");
				}
				
			}else {//사업자 회원
				String sno = rq.getParameter("sno");
				sql = "insert into shop_member values('0',?,?,?,?,?,?,?,now());";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, spart);//1부터 시작함
				this.ps.setString(2, sid);
				this.ps.setString(3, spw);
				this.ps.setString(4, snm);
				this.ps.setString(5, stel);
				this.ps.setString(6, semail);
				this.ps.setString(7, sno);
				int result = this.ps.executeUpdate();
				if(result>0) { //정상적으로 DB에 insert 완료 시
					this.pw.write("<script>alert('사업자회원가입이 정상적으로 완료되었습니다.'); location.href='./login.jsp';</script>");
				}				
			}
			
			
		}catch (java.sql.SQLIntegrityConstraintViolationException e) {// DB에 Unique에 중복값이 발생할 경우
			this.pw.write("<script>alert('연락처 및 이메일이 중복되어 가입이 취소되었습니다.'); history.go(-1);</script>");
		}
		catch (Exception e) {
			
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

}
