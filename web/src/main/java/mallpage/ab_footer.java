package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {
	// copyright 정보 Model
	copyright cr = new copyright();
	ArrayList<String> cpdata=null;
	public void fts() {
		
		this.cpdata = cr.copyright_info();
//		System.out.println(cpdata);
	}
	
//	public ArrayList<String> fts2() {// 이렇게 return 값으로 해도됨
//		
//		return cr.copyright_info();
////		System.out.println(cpdata);
//		
//	}
}
