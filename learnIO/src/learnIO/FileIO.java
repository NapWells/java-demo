package learnIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//1演示如何创建文件夹
//2、如何创建文件、并写入内容（）
//3、列出目录下所有文件
//4、读取文件内容
//5、删除文件
//6、copy文件
public class FileIO {
	public static void main(String [] args){
//		File file = new File("E:/ecplise/workspeace/IO/newfolder");
//		System.out.println("文件是否存在："+file.exists());
//		System.out.println("文件是否为目录："+file.isDirectory());
//		System.out.println("是否为文件："+file.isFile());
		
		String folderPath = "E:/ecplise/workspeace/IO/newfolder";
		creatFolder(folderPath);
		
		String fileName = "E:/ecplise/workspeace/IO/newfolder/newFile.txt";
		creatFile(fileName);
		String shortFileName = "E:/ecplise/workspeace/IO/newfolder/newFile2.txt";
		creatFile(shortFileName);
		
		writerFile(fileName);
		readerFile(fileName);
		
		copyFile(fileName);
//		listAndDeleteFiles(folderPath);
	}
	
	public static void creatFolder(String folderPath){
		File file = new File(folderPath);
		file.mkdirs();
	}

	public static boolean creatFile(String fileName){
		File file = new  File(fileName);
		System.out.println(file.getAbsolutePath());
		boolean isSuccess = false;
		try {
			isSuccess = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static void writerFile(String fileName){
		File file = new File(fileName);
		BufferedWriter bWriter = null;
		try {
			FileWriter writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			bWriter.write("Are you ok?");
			bWriter.newLine();
			bWriter.write("I'm fine! How about you？");
			bWriter.newLine();
			bWriter.write("I'm fine too!");
			bWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(bWriter !=  null)
			try {
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readerFile(String fileName){
		File  file = new File(fileName);
		BufferedReader bReader = null;
		try {
			FileReader reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			String line = bReader.readLine();
			while(line!=null){
				System.out.println(line);
				line = bReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void listAndDeleteFiles(String folderName){
		File file = new File(folderName);
		for(String fileName:file.list()){
			File newFile = new File(folderName + "/" + fileName);
			newFile.delete();
			System.out.println(fileName);
		}
	}
	
	public static void copyFile(String fileName){
		File file = new File(fileName);
		String copyFileName = fileName.substring(0,fileName.indexOf("."))+"Copy"+
				fileName.substring(fileName.indexOf("."),fileName.length());
		File copyFile = new File(copyFileName);
		BufferedWriter bWriter = null;
		BufferedReader bReader = null;
		try {
			copyFile.createNewFile();
			FileReader fileReader = new FileReader(file);
			bReader = new BufferedReader(fileReader); 
			FileWriter fWriter = new FileWriter(copyFile);
			bWriter = new BufferedWriter(fWriter); 
			String line = bReader.readLine();
			while(line!=null){
				bWriter.write(line);
				bWriter.newLine();
				line = bReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bWriter !=  null&&bReader!=null)
			try {
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
