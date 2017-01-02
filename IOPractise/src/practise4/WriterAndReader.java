package practise4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriterAndReader {
	public static void main(String [] args){
		File file = new File("test.dat");
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		RandomAccessFile raf = null;
		try {
			file.createNewFile();
			writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			bWriter.write("How are you？你好吗？");
			bWriter.newLine();
			bWriter.write("I'm fine! Thank you! How about you?");
			bWriter.newLine();
			bWriter.write("I'm fine too!");
			bWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bWriter!=null)
					bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			String str = "";
			raf = new RandomAccessFile(file,"rw");
//			for(int i=0;i<raf.read();i++)
//				System.out.println(new  String(raf.readLine().getBytes("gbk")));
			while((str=raf.readLine())!=null)
				System.out.println(new String(str.getBytes("ISO-8859-1"),"utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
}
