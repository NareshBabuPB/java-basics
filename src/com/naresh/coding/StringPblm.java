package com.naresh.coding;

public class StringPblm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*System.out.println(isUnique("Naresh"));
		System.out.println(isUnique("Babu"));*/
		
		/*System.out.println(isPermutation("Naresh $", "$reh Nas"));
		System.out.println(isPermutation("Babu", "buab"));
		System.out.println(isPermutation("", ""));*/
		
		urlify("implementing in Java");
	}

	private static boolean isUnique(String s){
		int[] asciiChars = new int[128];
		for(int i=0;i<s.length();i++){
			int index = Character.toUpperCase(s.charAt(i));
			if(asciiChars[index] != 0)
				return false;
			asciiChars[index] = index;
		}
		
		return true;
	}
	
	private static boolean isPermutation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		return computeHash(s1) == computeHash(s2);			
		
	}

	private static int computeHash(String s){
		int hashCode = 0;
		for(int i=0;i<s.length();i++){
			int ascii = s.charAt(i);
			hashCode += ascii;
		}
		
		return hashCode;
	}
	
	
	private static void urlify(String s){
		char[] chars = new char[s.length() * 3];	
		s.getChars(0, s.length(), chars, 0);		
		shift(chars, 0, s.length(), 0);
		chars[s.length()+4] = '\0';
		System.out.println(chars);
	}

	private static void shift(char[] chars, int begin, int end, int shiftCount){
		int i=begin;
		while(i<end){
			if(chars[i] == ' '){
				shift(chars, i+1, end, shiftCount + 1);				
				chars[i] = '%';
				chars[i+1] = '2';
				chars[i+2] = '0';
				i=end;
			}		
			i++;		
		}
		
		for(int j = chars.length-3;j>=begin && shiftCount > 0;j--){
			chars[j+2] = chars[j];
		}
	}
}
