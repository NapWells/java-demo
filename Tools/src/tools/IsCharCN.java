package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsCharCN {
	public static boolean checkCharCN(char c){
		String s = String.valueOf(c);
		String  regex = "[\u4e00-\u9fa5]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static void main(String[] args) {
		System.out.println(checkCharCN('我'));
		System.out.println(checkCharCN(','));
		System.out.println(checkCharCN('\\'));
		System.out.println(checkCharCN('&'));
		System.out.println(checkCharCN('2'));
		System.out.println(checkCharCN('m'));
	}

}
