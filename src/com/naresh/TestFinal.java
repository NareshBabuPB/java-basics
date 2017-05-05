package com.naresh;

public class TestFinal {
	private final static Employee employee = new Employee(1, "Naresh", "IT");
	
	public static void main(String[] args) {
		/*System.out.println("Employee before change: " + employee.toString());
		employee.setName("Babu");
		System.out.println("Employee after change: " + employee.toString());*/
//		employee = new Employee(2, "Babu", "IT");  Compile error. final fields cannot be assigned again.
		
		testStatic();
	}

	private static void testStatic(){
		Employee emp = new Manager(1, "Naresh", "IT");
		emp.displayName();
		
		Manager man = new Manager(2, "Babu", "IT");
		man.displayName();
	}
}
