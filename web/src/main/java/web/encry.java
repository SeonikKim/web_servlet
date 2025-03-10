package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller
@WebServlet("/encry")
public class encry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("///////////////////////base64///////////////////////");
		String passwd = "a123456";
		//해당 문자를 base64를 이용해 encode
		encry_model em = new encry_model();//암호화 model클래스 로드
		String res = em.dataencode(passwd);//해당 메서드에 문자열 전달
		System.out.println(res);//최종 암호화 된 문자열 출력
		//base64로 변환된 문자를 decode
		String repw= "YTEyMzQ1Ng==";
		String res2 = em.datadecode(repw);
		System.out.println(res2);
		
		//md5 암호화
		System.out.println("///////////////////////MD5///////////////////////");
		String result3 = em.md5_encode(passwd);
		System.out.println(result3);
		
		
	}

}
