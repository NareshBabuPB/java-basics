package com.naresh;

public class Manager extends Employee {

	public Manager(int id, String name, String dept) {
		super(id, name, dept);
	}

	protected static void displayName(){
		System.out.println("Manager");
	}
}
