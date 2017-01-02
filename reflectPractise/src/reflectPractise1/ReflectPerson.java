package reflectPractise1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectPerson {
	public static void reflectPerson(String className,String name,int age){
		try {
			Class clazz = Class.forName(className);
			Constructor c = clazz.getConstructor(new Class[]{String.class,int.class});
			System.out.println(c.newInstance(name,age)+" 是一个 "+clazz.getName()+"的实例");
			for(int i= 0 ; i<clazz.getInterfaces().length;i++){
				if(clazz.getInterfaces()[i].getName().equals("reflectPractise1.Fightable")){
					System.out.println("该类实现了fightable接口");
					Method f = clazz.getMethod("fight", new Class[]{});
					f.invoke(c.newInstance(name,age));
				}
			}
			Method [] methods = clazz.getDeclaredMethods();
			for(Method m : methods){
				if(m.getName().equals("pingpang"))
					m.invoke(c.newInstance(name,age));
				if(m.getName().equals("eatSusi"))
					m.invoke(c.newInstance(name,age));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("没有"+className+"这样的类");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		reflectPerson("reflectPractise1.Person","张三",20);
		reflectPerson("reflectPractise1.Chinese","李四",23);
		reflectPerson("reflectPractise1.Japanese","松下",29);
		reflectPerson("reflectPractise1.Merican","Bob",25);
	}

}
