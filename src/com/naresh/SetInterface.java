package com.naresh;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

	public static void main(String[] args) {

//		primitiveSets();
		userDefinedSets();
	}

	private static void userDefinedSets()
	{
		Employee emp1 = new Employee(1, "Naresh", "IT");
		Employee emp2 = new Employee(15, "Naresh", "ECE");
		Employee emp3 = new Employee(1, "Balaji", "EEE");
		Employee emp4 = new Employee(1, "Perini", "CSE");
		
		Set<Employee> hashSet = new HashSet<Employee>();
		hashSet.add(emp1);
		hashSet.add(emp2);
		hashSet.add(emp3);
		hashSet.add(emp4);
		hashSet.add(null);
		
//		System.out.println("HashSet");
//		printEmployeeSet(hashSet);
		
		Set<Employee> linkedHashSet = new LinkedHashSet<Employee>();
		linkedHashSet.add(emp1);
		linkedHashSet.add(emp2);
		linkedHashSet.add(emp3);
		linkedHashSet.add(emp4);
		linkedHashSet.add(null);
		
//		System.out.println("LinkedHashSet");
//		printEmployeeSet(linkedHashSet);
		
		Set<Manager> treeSet = new TreeSet<Manager>(new Comparator<Employee>(){

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return arg0.getId().compareTo(arg1.getId());
			}
			
		});
		
//		Set<Employee> treeSet = new TreeSet<Employee>();
		
		Manager man1 = new Manager(1, "Naresh", "IT");
		Manager man2 = new Manager(15, "Naresh", "ECE");
		Manager man3 = new Manager(1, "Balaji", "EEE");
		Manager man4 = new Manager(1, "Perini", "CSE");
		
		treeSet.add(man1);
		treeSet.add(man2);
		treeSet.add(man3);
		treeSet.add(man4);
		
		System.out.println("TreeSet");
		printManagerSet(treeSet);
	}
	
	private static void printManagerSet(Set<Manager> coll) {
		for(Employee print : coll)
		{
			System.out.println(print);
		}
	}
	
	private static void printEmployeeSet(Set<Employee> coll) {
		for(Employee print : coll)
		{
			System.out.println(print);
		}
	}

	private static void primitiveSets() {
		String s = "Naresh";
		String s1 = "Naresh";
		String s2 = "Babu";
		String s3 = "Perini";
		String s4 = "Balaji";
		
//		useHashSet(s, s1, s2, s3, s4);
//		useLinkedHashSet(s, s1, s2, s3, s4);
//		useTreeSet(s, s1, s2, s3, s4);
	}

	private static void useHashSet(String s, String s1, String s2, String s3, String s4) {
		Set<String> coll = new HashSet<String>();
		coll.add(s);
		coll.add(s1);
		coll.add(s2);
		coll.add(s3);
		coll.add(s4);
		
		System.out.println("HashSet");
		printSet(coll);
	}

	private static void printSet(Set<String> coll) {
		for(String print : coll)
		{
			System.out.println(print);
		}
	}
	
	private static void useLinkedHashSet(String s, String s1, String s2, String s3, String s4) {
		Set<String> coll = new LinkedHashSet<String>();
		coll.add(s);
		coll.add(s1);
		coll.add(s2);
		coll.add(s3);
		coll.add(s4);
		
		System.out.println("LinkedHashSet");
		printSet(coll);
	}
	
	private static void useTreeSet(String s, String s1, String s2, String s3, String s4) {
		Set<String> coll = new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				return arg1.compareTo(arg0);
			}
			
		});
		coll.add(s);
		coll.add(s1);
		coll.add(s2);
//		coll.add(s3);
//		coll.add(s4);
		
		System.out.println("TreeSet 1");
		printSet(coll);
		
		Set<String> coll1 = new TreeSet<String>();
		coll1.add(s3);
		coll1.add(s4);
		
		System.out.println("TreeSet 2");
		printSet(coll1);
		
		coll1.addAll(coll);
		
		System.out.println("Combined TreeSet");
		printSet(coll1);
	}

}
