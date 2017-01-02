package singleton;

import java.util.HashMap;
import java.util.Map;

//��������ģʽ
//�������ʱ������˳�ʼ������������ؽ���������ȡ������ٶȿ�
public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		return instance;
	}
}

//����ʽ����ģʽ
//�Ƚ������������ʱ��������ʵ�������������ٶȿ죬������ʱ��ȡ������ٶ���
class Singleton1 {
	private static Singleton1 instance = null;
	
	private Singleton1(){}
	
	public static synchronized Singleton1 getInstance(){
		if(instance == null)
			instance = new Singleton1();
		return instance;
	}
}

//�Ǽ�ģʽ
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
