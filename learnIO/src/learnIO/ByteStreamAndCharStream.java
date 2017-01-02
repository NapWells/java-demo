package learnIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class ByteStreamAndCharStream {
	public static void main(String [] args){
		//字节流主要是操作byte类型数据，以byte数组为准，主要操作类就是OutputStream、InputStream
		File f = new File("test.txt");
		try {
			OutputStream out = new FileOutputStream(f);
			String str = "Hello,World!";
			byte [] b = str.getBytes();
			out.write(b);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//字符流在程序中一个字符等于两个字节，那么java提供了Reader、Writer两个专门操作字符流的类。
		File f1 = new File("Test2.txt");
		try {
			Writer out = new FileWriter(f1);
			String str = "Hello,World";
			out.write(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
