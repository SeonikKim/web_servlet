package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ex0003 {

	public static void main(String[] args) {
		new java3_box().q3();

	}

}

class java3_box {
	String[][] aidata = { { "watermelon", "수박" }, { "kiwi", "키위" }, { "grape", "포도" }, { "strawberry", "딸기" },

	};
	ArrayList<String> ars = null;
	ArrayList<ArrayList<String>> ars2 = null;
	Scanner sc = null;

	public void q3() {
		this.ars2 = new ArrayList<ArrayList<String>>();
		this.sc = new Scanner(System.in);

		try {
			int w = 0;
			while (w < aidata.length) {
				this.ars = new ArrayList<String>();
				this.ars.add(aidata[w][0]);
				this.ars.add(aidata[w][1]);
				ars2.add(ars);
				w++;

			}
			System.out.println("과일 이름을 한글로 입력하세요 : ");
			String userinput = this.sc.next();
			w = 0;
			int chk = 0;
			while (w < this.aidata.length) {
				if (userinput.equals(this.ars2.get(w).get(1))) {
					System.out.println("영어 : " + this.ars2.get(w).get(0) + "입니다.");
					chk++;
					break;
				}
				w++;
			}

			if (chk == 0) {
				System.out.println("아직 등록된 단어가 아닙니다..");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
