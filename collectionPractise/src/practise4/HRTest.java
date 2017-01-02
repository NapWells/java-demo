package practise4;

public class HRTest {
	public static  void main(String []args){
		HR hr = new HR();
		System.out.println("工资最高的员工："+hr.getTopSalaryEmployee());
		System.out.println("工资前十名的是：");
		Employee [] e = hr.getTop10SalaryEmployees();
		for(Employee employee:e)
			System.out.println(employee);
		
		Employee e21 = new Employee("员工21", "21" ,4234);
		hr.enrollEmployee(e21);
		
		System.out.println("是否存在21号员工："+hr.isOurEmployee(e21));
		
		System.out.println("移除21号员工");
		hr.resignEmployee("21");
		System.out.println("是否存在21号员工："+hr.isOurEmployee(e21));
	}
}
