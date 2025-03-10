package event;
//db 환경설정 및 세팅 값

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
//		String database = "com.mysql.jdbc.Driver"; //v5.1, v5.5
		//mysql version 연걸 설정파트
		String database = "com.mysql.cj.jdbc.Driver"; //v5.7~
		//mysql 연결 경로
		String dburl = "jdbc:mysql://localhost:3306/mrp"; 
		String user = "project"; //mysql id
		String passwd = "p402402";//mysql pw
		
		Class.forName(database); //Class.forName : 어떤 라이브러리를 이용하여 db에 접속할 것인지 정하는 것
		Connection con = DriverManager.getConnection(dburl,user,passwd);//mysql -u 아이디 -p랑 같음..
		return con;
		
	}
}
