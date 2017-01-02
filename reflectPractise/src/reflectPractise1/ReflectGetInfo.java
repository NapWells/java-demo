package reflectPractise1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectGetInfo {
	public static void getPersonClass(){
		System.out.println("获取Person的class对象--------------------");
		System.out.println("方法一：Class.forName()");
		String name = "reflectPractise1.Person";
		try {
			Class<Person> p1 = (Class<Person>) Class.forName(name);
			System.out.println(p1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("方法二:Person.class");
		Class<Person> p2 = Person.class;
		System.out.println(p2);
		
		System.out.println("方法三:getClass()");
		Person person = new Person();
		Class<Person> p3 = (Class<Person>) person.getClass();
		System.out.println(p3);
 	}
	public static void getNewInstance(){
		System.out.println("\n创建Person对象实例--------------------");
		System.out.println("方法一：newInstance()");
		String name = "reflectPractise1.Person";
		try {
			Class<Person> p1 = (Class<Person>) Class.forName(name);
			Person person1 = p1.newInstance();
			System.out.println(person1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("方法二:construct.newInstance()");
		Class<Person> p2 = Person.class;
		try {
			Constructor c = p2.getConstructor(new Class[]{String.class,int.class});
			Person person2 = (Person) c.newInstance("张三",20);
			System.out.println(person2);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("方法三:new Person()");
		Person person = new Person();
		System.out.println(person);
	}
	public static void callSetGet(){
		System.out.println("\n调用set和get方法--------------------");
		Class<Person> p2 = Person.class;
		try {
			Constructor c = p2.getConstructor(new Class[]{String.class,int.class});
			Person person2 = (Person) c.newInstance("张三",20);
			Method[] methods = p2.getDeclaredMethods();
			for(Method m : methods)
				System.out.println(m);
			Method getName = p2.getMethod("getName",new Class[]{});
			System.out.println(getName.invoke(person2));
			Method setName = p2.getMethod("setName",new Class[]{String.class});
			setName.invoke(person2, "李四");
			System.out.println(person2.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public static void changeFieldValue(){
		System.out.println("\n改写属性的值--------------------");
		Class<Person> p2 = Person.class;
		try {
			Constructor c = p2.getConstructor(new Class[]{String.class,int.class});
			Person person2 = (Person) c.newInstance("张三",20);
			Field f1 = p2.getDeclaredField("name");
			f1.setAccessible(true);
			f1.set(person2, "王五");
			System.out.println(person2.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	public static void getDeclaredMethod(){
		System.out.println("\n获取chinese的所有自定义方法---------------------");
		Class<Chinese> chinese = Chinese.class;
		Method[] methods = chinese.getDeclaredMethods();
		for(Method m : methods)
			System.out.println(m.getName());
		
		System.out.println("\n获取chinese的所有公开方法---------------------");
		Method[] methods1 = chinese.getMethods();
		for(Method m : methods1)
			System.out.println(m.getName());
		
		System.out.println("\n获取chinese的父类信息---------------------");
		System.out.println(chinese.getSuperclass());
		
		System.out.println("\n获取chinese的接口类信息---------------------");
		for(int i = 0;i <chinese.getInterfaces().length;i++)
			System.out.println(chinese.getInterfaces()[i].getName());
	}
	public static void main(String [] args){
		getPersonClass();
		getNewInstance();
		callSetGet();
		changeFieldValue();
		getDeclaredMethod();
		Chinese c = new Chinese("张三",23);
	}
}
