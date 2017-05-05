package com.naresh.coding;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input = {2, 3, 1, 5};
//		input = new int[0];
		int[] input = {2,3,4,1};
		
		if(input.length == 0){
			System.out.println(0);
			return;
		}
		
		int[] output = new int[input.length + 2];
		
		for(int i: input){
			output[i] = i;
		}
		
		for(int i = 1; i<output.length;i++){
			if(output[i]==0){
				System.out.println(i);
			}
		}

	}

}
