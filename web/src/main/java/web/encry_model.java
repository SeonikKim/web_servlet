package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//문자를 암호화하는 model
public class encry_model {
	public String dataencode(String word) {//base64 암호화
		Encoder ec = Base64.getEncoder();
		String sec = ec.encodeToString(word.getBytes());
				
		return sec;		
	}
	public String datadecode(String word) {//base64 복호화
		Decoder dc = Base64.getDecoder();
		
		
//		byte[] dec = dc.decode(word);
//		String sec = new String(dec);
		String sec = new String(dc.decode(word));
		return sec.toString();
	}
	//md5 : %02x 기본 =>%03x : 자리수 변경(x소문자 X대문자))
	//sha1 : 16진수 40자로 생성되는 암호화 기술(%01x, %02x)
	//sha-2 : sha-224, sha-256, sha-384, sha-512
	//sha-3 : sha3-224, sha3-256, sha3-384, sha3-512
	
	//복합 암호화 기술 -> base64 -> md5-> ... 이런식으로 복합해서 암호화
	public String md5_encode(String word) {//MD5
		String sec = "";
		try {
			//MessageDigest : 암호화 클래스 구성 형태를 갖고있는 라이브러리
			MessageDigest md = MessageDigest.getInstance("sha3-256");
			md.update(word.getBytes());//해당 암호화 기준으로 문자를 byte로 변환
			byte[] md5byte = md.digest();//원시 배열에 해당 암호화된 byte값 저장
			StringBuilder sb = new StringBuilder();//문자열 클래스로 연속화
			
			for(byte s : md5byte) {
			sb.append(String.format("%02x", s));	
			//%02x => 2자리 문자 -> 1234 ->01,02,03,04
			//%02x => 1자리 문자 -> 1234 ->1,2,3,4
			
			}
			sec=String.valueOf(sb);
		} catch (Exception e) {
			sec = "MD-5 Err";
			
		}
		return sec;
	}
	
}
