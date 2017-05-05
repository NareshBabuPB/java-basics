package com.naresh.threads;

import java.util.ArrayList;
import java.util.List;

public class Consumer {

	private List<String> goods = new ArrayList<String>();
	
	public boolean isEmpty(){
		return goods.isEmpty();
	}
	
	public String get(){
		return goods.remove(goods.size() - 1);
	}
	
	public void put(String item){
		goods.add(item);
	}
	
	public void display(){
		System.out.println("Current Goods:");
		for(String item : goods){
			System.out.println(item);
		}
	}
	
	public int size(){
		return goods.size();
	}
}
