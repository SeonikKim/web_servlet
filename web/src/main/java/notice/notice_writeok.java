package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;

@MultipartConfig(//첨부파일 있으니까 추가
		fileSizeThreshold = 1024*1024*5,
		maxFileSize = 1024*1024*50
//		maxRequestSize = 1024*1024*500//이번엔 파일 한개만 쏘니까 필요없어요~
		)

public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	//Model 가져오기
	m_dbinfo db = new m_dbinfo();//db접속 정보
	m_md5 md5 = new m_md5();//암호화 
	
	

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		this.pw = rp.getWriter();
		//첨부파일 파트 ~ 첨부파일 유무에 따라 SQL 저장방식 바뀜!
		Part nfile = rq.getPart("nfile");
		long filesize = nfile.getSize();
//		System.out.println(filesize);// 용량체크
		try {
			this.con = this.db.getConnection();//DB연결
			String subject = rq.getParameter("subject");
			String writer = rq.getParameter("writer");
			String pw = rq.getParameter("pw");
			String texts = rq.getParameter("texts");
			
			pw = this.md5.md5_code(pw);//불러온 modal로 암호화
			String sql =""; //DB 쿼리
			int result=0;//DB입력 결과
			
			if(filesize==0) {//첨부 X
				sql = "insert into notice (nidx,subject,writer,pw,texts,ndate) values('0',?,?,?,?,now())";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, subject);
				this.ps.setString(2, writer);
				this.ps.setString(3, pw);
				this.ps.setString(4, texts);
//				System.out.println(sql);
				result = this.ps.executeUpdate();
				if(result>0) {//정상
					this.pw.write("<script>alert('정상적으로 게시완료되었습니다.'); lcoation.href='notice_list.do';</script>");
				}
				
			}else {//첨부 O
				//model을 이용하여 첨부파일을 저장하는 방식!~
				m_notice nt = new m_notice(nfile,subject,writer,pw,texts,rq);
				String msg = nt.msg; //private라서 못가져오니까 그냥 전역변수 msg 가져옴 ㅎ 
				if(msg.equals("ok")) {
					this.pw.write("<script>alert('공지사항 등록 완료');location.href='./notice_list.do';</script>");
				}
				else {
					this.pw.write("<script>alert('공지사항 등록 오류 발생');history.go()-1;</script>");
					
				}
			}
			
		} catch (Exception e) {
			this.pw.write("<script>alert('DB문제로 인하여 저장실패.'); history.go(-1);</script>");
			System.out.println(e);
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e2) {
//				System.out.println("close err");
			}
		}
	}

}
