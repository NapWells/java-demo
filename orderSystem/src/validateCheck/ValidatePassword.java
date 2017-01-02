package validateCheck;

import java.util.regex.Pattern;

public class ValidatePassword {
	public static void validatePassword(String passwrod) throws Exception{
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!lenPattern.matcher(passwrod).find()){
			throw new Exception("密码长度不能小于6！");
		}
		
		Pattern numPattern = Pattern.compile("[0-9]");
		if(!numPattern.matcher(passwrod).find()){
			throw new Exception("密码不能为纯数字！");
		}
		
		Pattern charPattern = Pattern.compile("[a-zA-Z]");
		if(!charPattern.matcher(passwrod).find()){
			throw new Exception("密码不能为纯字母！");
		}
	}
}
