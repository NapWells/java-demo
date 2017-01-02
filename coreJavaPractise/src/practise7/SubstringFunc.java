package practise7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringFunc {
	public static String substringFunc(String s,int n){
		String result = "";
		if(n>s.length())
			throw new RuntimeException();
		else{
			if(s.length()>2&&n>2){
				while(checkCharCN(s.charAt(n-2))){
					n --;
				}
				result = s.substring(0,n-1);
			}
			else
				result = s.substring(0,n);
			
		}
		return result;
	}
	public static boolean checkCharCN(char c){
		String s = String.valueOf(c);
		String  regex = "[\u4e00-\u9fa5]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static void main(String [] args){
		System.out.println(substringFunc("我ABC",4));
		System.out.println(substringFunc("我ABC汉DEF",6));
		System.out.println(substringFunc("我AB我汉DEF",1));
		System.out.println(substringFunc("2314fasffABC",4));
		
	}
}
