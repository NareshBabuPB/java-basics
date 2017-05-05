package com.naresh.coding;

public class CyclicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input ={-1000, 3, -562, 9, 1000, 6};
//		int[] input ={3, 8, 9, 7, 6, 4};
		int[] input = {};
		int rotation = 96;
		
		if(input.length == 0)
			return;
		
		int[] output = new int[input.length];
		
		int j = 0;
		int rot = input.length - (rotation % input.length);
		for(int i=0;i<input.length;i++){
			if(rot + i < input.length){
				output[i] = input[rot + i];
			} else{
				output[i] = input[j++];
			}
		}
		
		for(int i : output){
			System.out.println(i);
		}

	}

}
