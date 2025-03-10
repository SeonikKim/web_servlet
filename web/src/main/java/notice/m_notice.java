package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;

//notice 파일 저장용 model
public class m_notice  {
	
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	//Model 가져오기
	m_dbinfo db = new m_dbinfo();//db접속 정보
//	m_md5 md5 = new m_md5();//암호화// 이미 날라온 값이 암호화라서 없어도 됨 
	
	String msg = ""; //Model 에서 처리된 값 Controller로 결과값 반환하는 역할
	String sql =""; //DB 쿼리
	int result=0;//DB입력 결과
	
	
	
	//즉시실행 메서드에서는 첨부파일을 저장하는 역할만 함.
	String subject,writer,pw2,texts;
	
	public m_notice(Part nfile,String subject,String writer,String pw,String texts, HttpServletRequest request)throws Exception {
		this.subject = subject;
		this.writer = writer;
		this.pw2 = pw;
		this.texts = texts;
		String filenm = nfile.getSubmittedFileName(); // 이렇게 해야지 file이름이 제대로 나옴. getName은 FE에서 날아온 name값이출력 됨 ..
		String url = request.getServletContext().getRealPath("")+"/notice_files/";//경로 지정
		long filesize = nfile.getSize();//파일 용량
//		System.out.println(filenm);
//		System.out.println(request.getServletContext().getRealPath(""));//기본 파일저장 경로

		try {
			nfile.write(url + filenm);//web에 저장
			this.fileok(filenm);//정상저장 되었을 경우
		} catch (IOException e) {
			this.fileok("error");//비정상적, 해당 디렉토리에 파일이 저장되지 않을경우
		}
	}
	//DB로 저장 및 Controller로 결과값을 리턴하는 메서드
	private String fileok(String data)throws Exception {
		if(data.equals("error")) {
			this.msg="error";
		}else {//정상적으로 저장 완료 시 
			try {
				this.con = this.db.getConnection();
				this.sql = "insert into notice (nidx, subject,writer,pw,texts,filenm,nfile,ndate) values('0',?,?,?,?,?,?,now())";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, this.subject);
				this.ps.setString(2, this.writer);
				this.ps.setString(3, this.pw2);
				this.ps.setString(4, this.texts);
				this.ps.setString(5, data);
				this.ps.setString(6, data);
				this.result = this.ps.executeUpdate();
				if(result>0) {//정상
					this.msg="ok";
				}
				
			} catch (Exception e) {
				this.msg="error";
			} finally {
				this.ps.close();
				this.con.close();

			}
		}
		return this.msg;//Controller로 리턴하는 값!
	}
}
