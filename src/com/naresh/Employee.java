package com.naresh;

public class Employee{

	Integer id;
	String name;
	String dept;

	public Employee(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString()
	{
		return name + dept;
	}
	
	public boolean equals(Object arg0)
	{
		return getName().equals(((Employee) arg0).getName());
	}
	
	public int hashCode()
	{
		return name.hashCode();
		
	}

	protected static void displayName(){
		System.out.println("Employee");
	}
	/*@Override
	public int compareTo(Object arg0) {
		return this.name.compareTo(((Employee) arg0).getName());
	}*/
}
