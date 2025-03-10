package model;
//Model(난수 생성기)

import java.util.ArrayList;
import java.util.Random;

public class rmd {
	ArrayList<String> num = null;
	int ea = 0;

	public rmd(int n) {
		this.ea = n; // 자동등록방지 자리수
		this.num = new ArrayList<String>();
	}

	public ArrayList<String> mk_num() { // 난수를 생성하는 메서드
		Random rd = new Random();
		int w = 1;
		while(w<=this.ea) {
			this.num.add(String.valueOf(rd.nextInt(10)));// 0~9까지 생성
			
			w++;
		}
		return this.num;
	}
}
