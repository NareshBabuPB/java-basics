package com.naresh.coding;

public class BinaryGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =66561;
//		i=1041;
		String binString = Integer.toBinaryString(i);
		System.out.println(binString);
		
		boolean begin =false;
		int count = 0;
		int max = 0;
		for(char c: binString.toCharArray()){
			if(c=='1') {
				if(!begin){
					begin = true;
				} else if(count != 0){
					max = max < count ?count:max;
					count = 0;
//					begin=false;
				}
			} else if(begin){
				count++;
			}
		}
		System.out.println(max);
	}

}
