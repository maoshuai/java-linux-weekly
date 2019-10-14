package com.imshuai.javalinux.w2.lambda;

import java.util.Arrays;
import java.util.Random;

import com.imshuai.javalinux.w2.lambda.Person.Sex;

public class MethodReference {
	public static void main(String [] args) {

		// 准备100个测试数据
		Person[] persons = new Person[100];
		for(int i=1;i<=100;i++) {
			Person person = new Person();
			person.age = new Random().nextInt(100);
			person.name = "P" + i;
			person.gender = (i%2 == 0)? Sex.MALE: Sex.FEMALE;
			person.emailAddress = person.name + "@xx.com";
			persons[i-1] = person;
		}

		// 静态方法引用
		Arrays.sort(persons, Person::compareByAge );

		// 任意对象的实例方法引用
		Arrays.sort(persons, new ComparisionProvider()::compareByAge);

		// 特定类型的任意对象的任意实例方法引用
		String[] stringArray = { "Barbara", "James", "Mary", "John",
				"Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);

		// 
		Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));
		
		System.out.println("constructor reference");
		printPerson(Person::new);


		
		
		
	}
	
	
	public static void printPerson(PersonFactory factory) {
		factory.get().printPerson();
	}
	
	
	
	
}

class ComparisionProvider{
	public int compareByAge(Person a, Person b) {
		return Integer.compare(a.getAge(), b.getAge());
	}
}

interface  PersonFactory  {
	Person get();
}
