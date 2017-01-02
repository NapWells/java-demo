package singleton;

import java.util.HashMap;
import java.util.Map;

//饿汉单例模式
//在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		return instance;
	}
}

//懒汉式单例模式
//比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢
class Singleton1 {
	private static Singleton1 instance = null;
	
	private Singleton1(){}
	
	public static synchronized Singleton1 getInstance(){
		if(instance == null)
			instance = new Singleton1();
		return instance;
	}
}

//登记模式
class Singleton2 {
	private static Map<String,Singleton2> instanceMap = new HashMap<>();
	
	private Singleton2(){}

	public static synchronized Singleton2 getInstance(String indetifier){
		if(instanceMap.get(indetifier) == null){
			instanceMap.put(indetifier,new Singleton2());
		}
		return instanceMap.get(indetifier);
	}
}
