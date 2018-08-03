package com.shivamytri.disginpattern.miscellaeous;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExtensionMethods {

	public static void main(String args[]) {
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return squareRoot(a * 10);
			}

		};

		// formula.calculate(10);
		formula.squareRoot(10);
		System.out.println(formula.calculate(10));
		System.out.println(formula.squareRoot(10));

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");		
		

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		// using lambda expression
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});

		// much better version
		Collections.sort(names, (String a, String b) -> b.compareTo(a));

		// best
		Collections.sort(names, (a, b) -> b.compareTo(a));

		// converter using function interface

		Converter<String, Integer> converter = (form) -> Integer.valueOf(form);

		Integer converted = converter.convert("123");

		System.out.println(converted);

		Converter<String, Integer> converter2 = Integer::valueOf;
		converted = converter2.convert("100");
		System.out.println(converted);

		//
		SomeClass someClass = new SomeClass();
		Converter<String, String> stringCon = someClass::startsWith;
		String strCon = stringCon.convert("shiva");
		System.out.println(strCon);

		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("shiva", "kumar");
		
		System.out.println(person.toString());
		
		//final int num = 4;
		int num = 8;
		Converter<Integer, String> strConv = (form) -> String.valueOf(form + num);
		System.out.println(strConv.convert(2));
		
		//Predicate are boolean valued functions of one argument. The interface contains various default methods for 
		//composing preidcate to complex logical terms (and, or, negate)
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		
		// function acecpt one argument and produce a result. defautl methods can be used to chain multiple functions together (compose andThen)
		
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String>  backToString = toInteger.andThen(String::valueOf);
		
		System.out.println(toInteger.apply("123") instanceof Integer);
		
		System.out.println(backToString.apply("123") instanceof String);
		
		// supplier produces a result of a given generic type. unlike functions, suppliers don't accept arguments. 
		
		Supplier<Person> personSupplier = Person::new;
		
		personSupplier.get();
		
		// consumer represents operations to be performed on a single input argument.
		
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
		
		greeter.accept(new Person("shiva", "Kumar"));		
			
		
	}

}

class SomeClass {
	String startsWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}

class Person {
	private String firstName;
	private String LastName;

	Person() {
	}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.LastName = lastName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.firstName + ":" + this.LastName; 
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
}

interface PersonFactory<P extends Person> {
	P create(String firstName, String LastName);
}
