package shop;
//Database, user id, user pw 등록

import java.sql.Connection;
import java.sql.DriverManager;
//DB기본 메서드 명이 getConnection이라서 그냥 쓴거지 바꿔도 상관없음
public class m_dbinfo {
	
	public static Connection getConnection() throws Exception{
		//연습용이라 String으로 하는거지 실제론 Map 또는 Stringbuilder 사용해야함
		String db_driver = "com.mysql.cj.jdbc.Driver"; // DB 라이브러리 가져오기 	
		String db_url = "jdbc:mysql://localhost:3306/mrp"; // DB 경로 연결 구조는 jdbc:mysql://ip:port/db
		String db_user = "project";//DB에 접속하는 유저
		String db_pw = "a123456";//DB에 접속하는 유저 PW
		
		//실제 DB에 연결을 하는 명령어
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pw);
//		System.out.println(con); //db연결 확인 후 지워도 됨
		return con; //DB가 정상적으로 연결되었는지 확인 결과 return함
	}
	
	
}
