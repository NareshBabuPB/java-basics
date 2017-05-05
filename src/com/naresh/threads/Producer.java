package com.naresh.threads;

import java.util.ArrayList;
import java.util.List;

public class Producer {

	private List<String> produce = new ArrayList<String>();
	
	public boolean isEmpty(){
		return produce.isEmpty();
	}
	
	public String get(){
		return produce.remove(produce.size() - 1);
	}
	
	public void put(String item){
		produce.add(item);
	}
	
}
