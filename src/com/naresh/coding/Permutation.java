package com.naresh.coding;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation(new StringBuilder(), "Naresh");

	}

	private static void permutation(StringBuilder prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++){
	        	StringBuilder buff = new StringBuilder(prefix.toString());
	            permutation(buff.append(str.charAt(i)), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
}
