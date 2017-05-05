package com.naresh.coding;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = 3;
		int Y = 1000000000;
		int D = 2;
		
		/*float diff =Y-X;
		if(diff == 0)
			System.out.println(0);
		int count = (int) Math.ceil(diff/D);*/
		
		int diff =Y-X;
		if(diff == 0)
			System.out.println(0);
		int count = (int) Math.ceil(diff/D);
		
		System.out.println(count);

	}

}
