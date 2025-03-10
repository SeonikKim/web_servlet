package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class event_infook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	Statement st =null;
	dbconfig db = new dbconfig();

	public event_infook() {
		try {
//			dbconfig db = new dbconfig();
//			this.con = db.info();
//			this.con = new dbconfig().info();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			System.out.println("DB연결 실패");

		}
	}
	protected void doPost(HttpServletRequest re, HttpServletResponse rp) throws ServletException, IOException {
		re.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		
		
		String ename = re.getParameter("ename");
		String etel = re.getParameter("etel");
		String email = re.getParameter("email");
		String ememo = re.getParameter("ememo");
		String info1 = re.getParameter("info1");
		String info2 = re.getParameter("info2");

		//SQL 쿼리문(DDL) - select , insert, update, delete
		String sql = "insert into event(eidx,ename,etel,email,info1,info2,ememo,ejoin)" + 
		"values('0','" + ename + "','"+etel + "','" + email + "','" + info1 + "','" + info2 + "','" + ememo + "',now())";
		this.pw = rp.getWriter();
		try {
			this.con = this.db.info();
			//SQL문법을 실행시키는 클래스(기초라 기능 부실함)
			this.st = this.con.createStatement();
			int result = this.st.executeUpdate(sql); //executeUpdate : (insert, update, delete)만 사용
			if(result > 0) {
//				if(result == 1) { //이거도 되긴 함 0, 1 두개만 출력됨
	
				this.pw.write("<script>alert('정상적으로 이벤트에 참여되었습니다.');location.href='./event_info.html;'</script>");
			}
			else {
				this.pw.write("<script>alert('이미 이벤트에 참여되었습니다.');location.href='./event_info.html;'</script>");
			}

			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("sql문법오류!");
		}finally {//정상적인 db 모두 핸들링 후 역순으로 close를 순차적으로 적용해야함.
			try {
				st.close();//statement close
				this.pw.close();
				this.con.close(); // db연결 끊기
				
			} catch (Exception e2) {
				System.out.println("DB가 정상적으로 종료되지 않았습니다.");
			}
		}

	}

}
