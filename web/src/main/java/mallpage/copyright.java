package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import shop.m_dbinfo;

//copyright Model + Login Model
public class copyright {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	ArrayList<String> cp = null;
	m_dbinfo db = new m_dbinfo();
	String result=null;
	m_member mb = new m_member();//기존에 사용한 dto 초기화 및 새로운 dto를 구성하기 위함
//	public static void main(String[] args) { //테스트 후 지워야합니다~ 
//		new copyright().main2();
//	
//
//	}
	
	//login꺼
	public String user_login(m_member dto) {
		try {
			this.con = this.db.getConnection();
			this.sql="select mid,mname,memail from joins where mid=? and mpass=?;";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, dto.getMid());
			this.ps.setString(2, dto.getMpass());
			this.rs=this.ps.executeQuery();
			if(this.rs.next() == true) {//성공
				this.result="ok";
				
			
				this.mb.setMid(this.rs.getString("mid"));//id저장
				this.mb.setMname(this.rs.getString("mname"));//가입자명 저장
				this.mb.setMemail(this.rs.getString("memail"));//가입자명 저장
			}
			
		} catch (Exception e) {
			this.result=null;
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				
			}
		}
		return this.result;
		
	}
	
	//copyright꺼
	public ArrayList<String> copyright_info() {
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from corp_info";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			this.rs.next();//rs는 buffered 형식이라 next 해줘야함
			this.cp = new ArrayList<String>();
			this.cp.add(this.rs.getString("corp_nm"));
			this.cp.add(this.rs.getString("ceo_nm"));
			this.cp.add(this.rs.getString("corp_addr"));
			this.cp.add(this.rs.getString("corp_tel"));
			this.cp.add(this.rs.getString("corp_time"));
			this.cp.add(this.rs.getString("ceo_email"));
			this.cp.add(this.rs.getString("corp_no"));
			this.cp.add(this.rs.getString("corp_no2"));
			this.cp.add(this.rs.getString("corp_master"));
			this.cp.add(this.rs.getString("corp_domain"));
//			System.out.println(this.cp);
			
			
		} catch (Exception e) {
			System.out.println("DB Err");
		}finally {
			try {
				
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				System.out.println("DB Err");
			}
		}
		return this.cp;
		
	}

}
