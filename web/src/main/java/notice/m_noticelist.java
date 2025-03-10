package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.m_dbinfo;

//DB에 있는 모든 데이터를 가져오는 model
public class m_noticelist {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;// select 용

	String sql = null;// sql 쿼리
	ArrayList<String> data = null;// 1차원 각 컬럼 별 데이터
	ArrayList<ArrayList<String>> alldata = null;// 2차원 모든 데이터

	m_dbinfo db = new m_dbinfo();
	
	
	public m_noticelist() {

	}

	public ArrayList<ArrayList<String>> db_data() {
		try {
			this.con = db.getConnection();
			//필요한 컬럼만 지정해서 select로 가져오고 desc 정렬함
			this.sql = "select nidx, subject, writer, nview, ndate from notice order by nidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();//select~ 문
			this.alldata = new ArrayList<ArrayList<String>>();
			
			//반복문으로 table에 있는 컬럼을 1차원배열로 이관 후 2차원 배열에 담음
			while(this.rs.next()) { //나중엔 for~each로 쓰기 
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("writer"));
				this.data.add(this.rs.getString("nview"));
				this.data.add(this.rs.getString("ndate"));
				this.alldata.add(this.data);
			}
//			System.out.println(this.alldata);
		} catch (Exception e) {
			this.alldata=null;// 오류나면 alldata 초기화때려버림
		} finally {
			
			try {
				this.ps.close();
				this.con.close();
			} catch (SQLException e) {
				this.alldata=null;// 오류나면 alldata 초기화때려버림
			}

		}
		//Model에서 Controller로 데이터 회신
		return this.alldata;
	}
}
