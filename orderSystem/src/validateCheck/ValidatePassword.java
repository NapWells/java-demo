package validateCheck;

import java.util.regex.Pattern;

public class ValidatePassword {
	public static void validatePassword(String passwrod) throws Exception{
		Pattern lenPattern = Pattern.compile("[0-9a-zA-Z]{6,}");
		if(!lenPattern.matcher(passwrod).find()){
			throw new Exception("���볤�Ȳ���С��6��");
		}
		
		Pattern numPattern = Pattern.compile("[0-9]");
		if(!numPattern.matcher(passwrod).find()){
			throw new Exception("���벻��Ϊ�����֣�");
		}
		
		Pattern charPattern = Pattern.compile("[a-zA-Z]");
		if(!charPattern.matcher(passwrod).find()){
			throw new Exception("���벻��Ϊ����ĸ��");
		}
	}
}
