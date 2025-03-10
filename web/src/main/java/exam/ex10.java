package exam;

import java.util.Scanner;

public class ex10 extends ex10_box {

	public static void main(String[] args) {
		System.out.println("[1.휴대폰 인증   2.이메일인증] 선택 : ");
		// 여기선 this 안됨... 따로 빼서 사용 ㄱ
		new ex10().sec();

	}

	public void sec() {
		String part = this.sc.next();
		String res = null;
		Integer hpno = null;
		String email = null;
		
		if (part.equals("1")) {
			System.out.println("휴대폰 번호를 입력하세요(숫자만) : ");
			try {
				hpno = this.sc.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요. 재실행됩니다.");
				new ex10().main(null);
			}
			res = this.hp(hpno);
			System.out.println(res);
		} else if (part.equals("2")) {
			System.out.println("이메일을 입력하세요 : ");
			email = this.sc.next();
			res = this.email(email);
			System.out.println(res);
		} else {
			new ex10().main(null);
		}
	}

}

abstract class ex10_box {
	Scanner sc = new Scanner(System.in);

	public String hp(Integer hpno) {// 휴대폰 인증
		String msg = "인증번호 : 1111";
		
		return msg;
	}

	public String email(String email) {// 이메일 인증
	String msg = "인증번호 : 2222";
		
		return msg;
	}
}