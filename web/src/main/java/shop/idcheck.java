package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	


	// Ajax 통신을 받는 메서드(아이디 중복체크)
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		// BE가 FE에 결과값을 통보하는 역할
		PrintWriter pw = rp.getWriter();
		String msg = ""; // FE에 보낼 결과를 담는 변수
		String id = rq.getParameter("sid");

		// Ajax로 FE가 보낸 데이터를 받는 역할
		try {
			if (id.equals("")) {
				msg = "error";
			}else {
				m_dbinfo db = new m_dbinfo();
				this.con = db.getConnection(); // db연결 시작
				/*sql 쿼리 작성
				1. select => ResultSet + excuteQuery
				2. insert, update, delete => int + excuteUpdate 
				*/
				
				String sql="select count(*) as ctn from shop_member where sid = '"+id+"'";
//				System.out.println(sql); // 혹시 몰라서 확인 해봄 ㅎ
				
				//Statement : DB에 쿼리문을 작성할 수 있도록 사용하는 메서드
				//createStatement() : create, alter, drop.. DDL 사용 시
				Statement st = this.con.createStatement();
				ResultSet rs = st.executeQuery(sql);//ResultSet = excuteQuery 결과값을 받는 역할 
//				//반복문 사용시
//				while(rs.next()) { // rs.next() : 결과값에 대해 반복(true or false) 
//					System.out.println(rs.getString("ctn"));					
//				}
				
//				//데이터 한개만 있을 때 사용
				if(rs.next()==true) {//정상적으로 쿼리 작동 시
					if(rs.getString("ctn").equals("0")) {//카운트 결과 0(중복x) 기본은 equals로 핸들링 해야함 == 아님.. (intern()쓰면 되긴 함)
						msg="ok";
					}else {//카운트 결과 0이아닐 시(중복)
						msg="no";
					}
				}
				rs.close();
				st.close();
				
				
			}
			pw.write(msg);
		}catch (NullPointerException e) { // FE가 올바른 값을 전달하지 않을 경우 
			msg = "error";
			pw.write(msg); // ok : 사용가능, no : 사용불능, error : 데이터 오류 와 같이 FE와 사전 협의하여서 사용함
		} 
		catch (Exception e) {
			msg = "Mysql-CODE 000"; //백엔드가 임의로 넣어서 확인
			pw.write(msg);
			
		}finally {
			pw.close();
		}
	}
}
