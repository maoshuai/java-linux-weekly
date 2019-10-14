package com.imshuai.javalinux.w2.lambda;

public class Person {

    public enum	 Sex {
        MALE, FEMALE
    }

    String name;
    int age;
    Sex gender;
    String emailAddress;

    public int getAge() {
    	return age;
    }

	public void printPerson() {
		System.out.println("Person [name=" + name + ", age=" + age + 
				", gender=" + gender + 
				", emailAddress=" + emailAddress + "]");
	}
	
	public static int compareByAge(Person a, Person b) {
        return Integer.compare(a.age, b.age);
    }
}