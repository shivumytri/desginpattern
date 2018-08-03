package com.shivamytri.disginpattern.singleton;

public class EagerInitializedSingleton {
	
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	//private constructor to avoid client applications to use contructor
	private EagerInitializedSingleton () {}
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

}
