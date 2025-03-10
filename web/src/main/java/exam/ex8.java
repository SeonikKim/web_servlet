package exam;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class ex8 extends ex8_box{

	@Override
	public void odd() {// 삭제해서 출력하기~ 
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w<number.size()) {
			if(number.get(w) % 2 == 0) {
				number.remove(w);// 리무브 시 배열의 인덱스, 즉 노드 번호가 변경되므로 주의 
				w=0;//다시 배열0번 인덱스부터 시작하기 위함 
				
			}
			else {
				w++;
			}
		}
		System.out.println(number);
	}
	@Override
	public void even() {
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w<number.size()) {
			if(number.get(w) % 2 == 1) {
				number.remove(w);// 리무브 시 배열의 인덱스, 즉 노드 번호가 변경되므로 주의 
				w=0;
				
			}
			else {
				w++;
			}
		}
		System.out.println(number);
	}
	
	public static void main(String[] args) {
		new ex8().even();
		new ex8().odd();
	}
	

}
abstract class ex8_box{
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};
	
	abstract public void even();
	abstract public void odd();
}