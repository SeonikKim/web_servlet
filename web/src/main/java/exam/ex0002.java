package exam;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex0002{

	public static void main(String[] args) {
		java2_box j2b = new java2_box();
		j2b.q2();
	}

}

class java2_box {
	ArrayList<Integer> ari = null;
	int no = 0;
	Scanner sc = null;
	
	public void q2() {// 응용2
		int res = 0;
		ari = new ArrayList<Integer>();
		ArrayList<Integer> ai = new ArrayList<Integer>();
		try {
			int k = 0;
			while (k < 6) {

				this.no = (int) Math.ceil(Math.random() * 46);
				if (!ai.contains(no)) {
					ai.add(this.no);
					k++;
				}
			}

			int w = 0;
			{
				while (w < 6) { //혹시 모를 오류방지 위해 무한루프 + count 사용 추천
					this.sc = new Scanner(System.in);
					System.out.println("6개의 숫자를 입력하세요 :(" + (w + 1) + "/6) (1~46까지 입력) :");
					int userinput = this.sc.nextInt();

					 
					if(userinput<1 || userinput>46) {
						System.out.println("1~46까지 입력 가능합니다");
					}
					else if (!ari.contains(userinput)) {
						ari.add(userinput);
						w++;
						
					}
					
					else {
						System.out.println("중복 숫자 발생되었습니다.. 다시 입력해주세요 ");
						System.out.println(ari);
					}

				}
			}

			int j = 0;
			while (j < ai.size()) {
				if (ai.contains(ari.get(j))) {
					res++;
				}
				j++;

			}
			System.out.println(res + "개 맞췄습니다.");
			System.out.println("컴퓨터는 : " + ai + "였습니다.");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력해야합니다 .. 처음부터 다시하세요");
			q2();
		} catch (Exception e) {
			System.out.println(e);
		}

	};
}
