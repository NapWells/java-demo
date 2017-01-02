package learnSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentMain {

	public static void main(String[] args) {
		try {
			Student stu = new Student();
			stu.setAge(11);
			stu.setId(1);
			stu.setName("学生1");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.output"));
			oos.writeObject(stu);
			oos.close();
			
			ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("student.output"));
			Student newStu = (Student)ooi.readObject();
			System.out.println(newStu);
			System.out.println(newStu == stu);
			ooi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
