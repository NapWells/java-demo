package learnRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {
	public static boolean test(String str){
		Pattern p = Pattern.compile("0\\d{2,3}-\\d{7,8}");
		Matcher m = p.matcher(str);
		System.out.println(str + ":" + m.matches());
		return m.matches();
	}
	public static void main(String [] args){
		String [] reg = {"12345","0134-3425322","234-9993843"};
		for(String str : reg)
			test(str);
	}
}
