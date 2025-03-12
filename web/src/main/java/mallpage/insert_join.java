package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import shop.m_dbinfo;

//회원가입 처리 model
public class insert_join {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	m_dbinfo db = new m_dbinfo();
	Integer result = null;

//	m_member mb = new m_member(); //DTO //클래스배열 만드는거 아니면 안써도됨
	public Integer insert_member(m_member m) {
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into joins values('0',?,?,?,?,?,?,?,now())";
			// DTO getter를 이용해 db에 저장
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, m.getMid());
			this.ps.setString(2, m.getMpass());
			this.ps.setString(3, m.getMname());
			this.ps.setString(4, m.getMemail());
			this.ps.setString(5, m.getMtel());
			this.ps.setString(6, m.getEvent_mail());
			this.ps.setString(7, m.getEvent_sms());

			this.result = this.ps.executeUpdate();

		} catch (Exception e) {
			this.result = null;
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				this.result = null;
			}
		}
		return this.result;
	}
}
