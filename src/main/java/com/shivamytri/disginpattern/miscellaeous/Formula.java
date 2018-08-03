package com.shivamytri.disginpattern.miscellaeous;

public interface Formula {
	double calculate(int a);
	
	default double squareRoot(int a ) {
		return Math.sqrt(a);
	}
}
