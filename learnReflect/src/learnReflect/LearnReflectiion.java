package learnReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LearnReflectiion {
	public static void main(String [] args){
		Dog d = new Dog();
		getClassFullName(d);
		getClassInstance();
		getClassInfo();
		getInstance();
		changeFiled();
		callMethod();
	}
	
	public static void getClassFullName(Dog d){
		System.out.println("1.获取包名和类名");
		Class c = d.getClass();
		System.out.println("类名： "+c.getName());
		System.out.println("包名： "+c.getPackage().getName());
	}
	public static void getClassInstance(){
		System.out.println("2.获得类实例 - 3种方法");
		String className = "learnReflect.Dog";
		try {
			Class c = Class.forName(className);
			System.out.println("method 2:"+c.getName());
			
			Class d = Dog.class;
			System.out.println("method 3:"+c.getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void getClassInfo(){
		System.out.println("3、获得类的各种信息：方法，变量，构造函数，父类，借口等========");
		Class<Dog> dogClazz = Dog.class;
		Method[] methods = dogClazz.getMethods();
		System.out.println("getMethods方法如下：");
		for(Method m: methods){
			System.out.println(m.getName());
		}
		
		Method[] methods2 = dogClazz.getDeclaredMethods();
		System.out.println("getDeclaredMethods方法如下");
		for(Method m:methods2)
			System.out.println(m.getName());
		System.out.println("获取父类信息：");
		System.out.println(dogClazz.getSuperclass());
		System.out.println("获取接口信息：");
		System.out.println(dogClazz.getInterfaces());
	}

	public static void getInstance(){
		System.out.println("4.创建对象实例======");
		Class<Dog> dogClazz = Dog.class;
		try {
			Object o = dogClazz.newInstance();
			System.out.println("创建的对象是:"+o);
			
			//方法2
			Constructor c = dogClazz.getConstructor(new Class[]{String.class,int.class});
			Dog o2 = (Dog) c.newInstance("大黄",4);
			System.out.println("创建的对象是:"+o2.name);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void changeFiled(){
		System.out.println("5.改变成员变量======");
		Class<Dog> dogClazz = Dog.class;
		try {
			Object o = dogClazz.newInstance();
			//方法2
			Constructor c = dogClazz.getConstructor(new Class[]{String.class,int.class});
			Dog o2 = (Dog) c.newInstance("大黄",4);
			
			Field[] fields = dogClazz.getFields();
			for(Field f : fields){
				System.out.println(f.getName());
			}
			Field[] fields2 = dogClazz.getDeclaredFields();
			for(Field f : fields2){
				System.out.println(f.getName());
			}
			Field f = dogClazz.getField("name");
			f.set(o2, "大黑");
			System.out.println(f.get(o2));
			
			Field f2 = dogClazz.getDeclaredField("owner");
			f2.setAccessible(true);
			f2.set(o2, "张三");
			System.out.println(f2.get(o2));
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void callMethod(){
		System.out.println("6、调用方法======");
		Class<Dog> dogClazz = Dog.class;
		try {
			Object o = dogClazz.newInstance();
			//方法2
			Constructor c = dogClazz.getConstructor(new Class[]{String.class,int.class});
			Dog o2 = (Dog) c.newInstance("大黄",4);
			
			Method m = dogClazz.getMethod("bark", new Class[]{});
			m.invoke(o,new Object[]{});
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
