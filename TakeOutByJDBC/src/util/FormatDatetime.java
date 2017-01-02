package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDatetime {
	public static Date getNowDatetime(){
		return new Date(System.currentTimeMillis());
	}
	public static String getStringDatetime(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(getNowDatetime());
	}
}

