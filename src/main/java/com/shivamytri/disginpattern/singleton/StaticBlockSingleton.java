package com.shivamytri.disginpattern.singleton;

public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance;
	
	//to avoid client application use contructor 
	private StaticBlockSingleton () {}
	
	static {
		try {
			instance = new StaticBlockSingleton();			
		}catch(Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance.");
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}
