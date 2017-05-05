package com.naresh.coding;

import java.util.Arrays;

public class UnpairedElement {

	public static void main(String[] args) {
//		int[] input = {9,3,9,3,9,7,9};
		int[] input = {9,3,7,3,7};
		
		Arrays.sort(input);
		int currentElement = 0;
		int count=0;
		for(int i : input){
			if(currentElement == i){
				count++;
				continue;
			} else if(count%2 == 1){
				System.out.println(currentElement);
				return;
			}
			currentElement = i;
			count = 1;
		}
		
		if(count%2 == 1){
			System.out.println(currentElement);
			return;
		}
		System.out.println(0);
				
	}
}
