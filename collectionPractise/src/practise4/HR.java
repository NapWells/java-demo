package practise4;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private List<Employee> listEmployee =new ArrayList<Employee>();
	public HR(){
		listEmployee.add(new Employee("员工1","1",1000));
		listEmployee.add(new Employee("员工2","2",1300));
		listEmployee.add(new Employee("员工3","3",1600));
		listEmployee.add(new Employee("员工4","4",1200));
		listEmployee.add(new Employee("员工5","5",1700));
		listEmployee.add(new Employee("员工6","6",2000));
		listEmployee.add(new Employee("员工7","8",1050));
		listEmployee.add(new Employee("员工8","9",1800));
		listEmployee.add(new Employee("员工9","10",1900));
		listEmployee.add(new Employee("员工10","11",2100));
		listEmployee.add(new Employee("员工12","12",2100));
		listEmployee.add(new Employee("员工13","13",1650));
		listEmployee.add(new Employee("员工14","14",3100));
		listEmployee.add(new Employee("员工15","15",1290));
		listEmployee.add(new Employee("员工16","16",2400));
		listEmployee.add(new Employee("员工17","17",2900));
		listEmployee.add(new Employee("员工18","18",1605));
		listEmployee.add(new Employee("员工19","19",1745));
		listEmployee.add(new Employee("员工20","20",1870));
	}
	
	public List<Employee> getEmployees(){
		return listEmployee;
	}
	
	public Employee getTopSalaryEmployee(){
		int maxSalary = 0;
		Employee topSalaryEmployee = null;
		for(int i=0;i<listEmployee.size();i++){
			if(listEmployee.get(i).getSalary()>=maxSalary){
				maxSalary = listEmployee.get(i).getSalary();
				topSalaryEmployee = listEmployee.get(i);
			}
		}
		return topSalaryEmployee;
	}
	
	public Employee[] getTop10SalaryEmployees(){
		Employee [] Top10employee = new Employee[10];
		List<Employee> list = listEmployee;
		for(int i=0;i<10;i++){
			Top10employee[i]=getTopSalaryEmployee();
			list.remove(getTopSalaryEmployee());
		}
		return Top10employee;
	}
	
	public void enrollEmployee(Employee e){
		listEmployee.add(e);
	}
	
	public void resignEmployee(String employeeID){
		Employee employee=null;
		for(Employee e:listEmployee)
			if(e.getId()==(employeeID))
				employee = e;
		listEmployee.remove(employee);
	}
	
	public boolean isOurEmployee(Employee employee){
		if(listEmployee.contains(employee))
			return true;
		else
			return false;
	}
}
