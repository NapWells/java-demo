package binding;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JaxbSample {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId("123");
		student.setName("Jaxb");
		student.setGender("M");
		student.setAge("M");
		
		try {
			JAXBContext ctx = JAXBContext.newInstance(Student.class);
			ctx.createMarshaller().marshal(student, new File("student.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

}
