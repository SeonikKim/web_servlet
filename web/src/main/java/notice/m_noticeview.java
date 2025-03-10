package notice;
//DB Table 중 where 및 조회수 증가

//query : select, update

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.m_dbinfo;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String sql = "";// SQL query 저장용
	m_dbinfo db = new m_dbinfo(); // db 정보 불러오기

	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			// 해당 컬럼에 값을 +1씩 증가시키는 쿼리문
			this.sql = "update notice set nview = nview +1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);//setInt : nidx 자료형이 int 이니까~ 
			this.ps.executeUpdate();//쿼리문 실행

		} catch (Exception e) {

		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {

			}
		}

	}
}
