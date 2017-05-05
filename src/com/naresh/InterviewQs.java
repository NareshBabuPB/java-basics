package com.naresh;

public class InterviewQs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(tryFinallyCheck());

	}
	
	private static int tryFinallyCheck(){
		try{
			System.out.println("inside try");
			return 2;
		 } finally {
		   return 1;
		 }
	}

}
