package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class java4 {

	public static void main(String[] args) {
		java4_box j4b = new java4_box();
		j4b.q4();
	}

}
class java4_box{
	Scanner sc = null;
	ArrayList<Integer> ari = null;
	int no = 0;
	
	public void q4() {
		this.sc = new Scanner(System.in);
		this.ari = new ArrayList<Integer>();
		int w = 0;
		
		try {
			while (w<10) {
				System.out.println("입력범위 1 ~ 500까지 숫자를 입력해주세요 ("+(w+1)+"/10)");
				this.no = sc.nextInt();
				if(this.no<1 || this.no>500) {
					System.out.println("1 ~ 500 까지만 입력 가능합니다");
				}
				else {
					this.ari.add(this.no);				
					w++;
				}
			}
			
		}
		catch (InputMismatchException e) {
			System.out.println("숫자만 입력하세요 .. 처음부터..");
			q4();
		}
		
		catch (Exception e) {
			System.out.println(e);
			
		}
	
		Collections.sort(this.ari,Collections.reverseOrder());
		System.out.println(this.ari);
		
	
	}
	
}
