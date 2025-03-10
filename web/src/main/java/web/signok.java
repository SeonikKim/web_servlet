package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signok")
public class signok extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public signok() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();  // PrintWriter 초기화

        String[] ck = request.getParameterValues("ck"); // 체크박스 값 받기
        String[] ckck = request.getParameterValues("ckck"); // 체크박스 값 받기

        // 체크박스 값이 없을 경우 예외 처리
        if (ck == null || ck.length == 0) {
            pw.write("<script>alert('필수항목 체크 필수입니다.');history.go(-1);</script>");
            return;
        }

        try {
            System.out.println("필수선택 :  " + Arrays.asList(ck));
            System.out.println("체크박스 개수: " + ck.length);

            System.out.println("선택선택..?" + Arrays.asList(ckck));
            
            if (ck.length != 3) {  // 체크박스가 3개 선택되지 않았을 경우
                pw.write("<script>alert('필수항목 체크 필수입니다.');history.go(-1);</script>");
                return;
            }

            // 체크 항목이 올바르면 다음 페이지로 이동
            request.setAttribute("ck", ck);
            RequestDispatcher rd = request.getRequestDispatcher("./signup.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            pw.write("<script>alert('올바른 접근 방법이 아닙니다.');history.go(-1);</script>");
        }finally {
			pw.close();
		}
    }
}