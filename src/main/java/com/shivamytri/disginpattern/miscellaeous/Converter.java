package com.shivamytri.disginpattern.miscellaeous;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F form);
}
