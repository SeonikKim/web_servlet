package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class java6 {

	public static void main(String[] args) {
		java6_box j6b = new java6_box();
		j6b.q6();
	}

}

class java6_box {
	String[][] udata = { { "마동석", "01053514423" }, { "김무열", "01023103637" }, { "이동휘", "01055317889" },
			{ "박지환", "01069882901" }, { "이주빈", "01095849004" }, };
	ArrayList<String> ars = null;
	Scanner sc = null;

	public void q6() {
		this.sc = new Scanner(System.in);
		this.ars = new ArrayList<String>();
		int w = 0;
		while (w < udata.length) {
			ars.add(udata[w][0]);
			ars.add(udata[w][1]);
			w++;
		}
		System.out.print("고객명을 입력하세요 : ");
		String name = sc.next();

		int count = 0;
		w = 0;
		while (w < ars.size()) {
			if (ars.get(w).equals(name)) {
				System.out.println(name + "님 연락처 " + ars.get(w + 1));
				count++;
			}
			w++;

		}

		if (count == 0) {
			System.out.println("해당 고객은 가입되지 않았습니다.");
		}
	}
}
