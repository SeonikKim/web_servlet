package exam;

public class java5 {

	public static void main(String[] args) {
	int[] arr = {20,36,11,8,22,31};
	
	java5_box j5b = new java5_box();
	j5b.q5(arr);
	

	}

}
class java5_box{
	public void q5(int[] max) {
		int w = 0;
		int maxNum = 0;
		while(w<max.length) {
			maxNum = Math.max(maxNum, max[w]);
			w++;
		}
		
		System.out.println("가장 큰 수는 : "+maxNum);
	}
	
}
