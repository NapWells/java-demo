package reflectPractise2;

import java.lang.reflect.Field;

public class MyObjectFactory {
	public static Object getObject(String className){
		try {
			Class<?> clazz = Class.forName(className);
			Field [] fields = clazz.getDeclaredFields();
			Object o = clazz.newInstance();
			for(Field field: fields){
				field.setAccessible(true);
				if(field.getName().equals("name"))
					field.set(o, "name initial value");
				if(field.getName().equals("age"))
					field.set(o, 1);
			}
			return o;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void  main(String [] args){
		Dog dog = (Dog) getObject("reflectPractise2.Dog");
		System.out.println(dog.getName()+" : "+dog.getAge());
		
		Person person = (Person) getObject("reflectPractise2.Person");
		System.out.println(person.getName()+" : "+person.getAge());
		
		Book book = (Book) getObject("reflectPractise2.Book");
		System.out.println(book.getName()+" : "+book.getAge() );
		
	}
	
}
