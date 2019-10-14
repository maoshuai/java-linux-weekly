package com.imshuai.javalinux.w2.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.imshuai.javalinux.w2.lambda.Person.Sex;

public class LambdaTest {

	public static void main(String[] args) {

		// 准备100个测试数据
		List<Person> roster = new ArrayList<Person>();
		for(int i=1;i<=100;i++) {
			Person person = new Person();
			person.age = i ;
			person.name = "P" + person.age;
			person.gender = (i%2 == 0)? Sex.MALE: Sex.FEMALE;
			person.emailAddress = person.name + "@xx.com";
			roster.add(person);
		}

		System.out.println("printPersonsOlderThan: ");
		printPersonsOlderThan(roster, 52);

		
		System.out.println("printPersonsWithinAgeRange: ");
		printPersonsWithinAgeRange(roster, 52, 60);

		
		System.out.println("TeenageBoyTester: ");
		class TeenageBoyTester implements CheckPerson{
			@Override
			public boolean test(Person p) {
				return p.gender == Sex.MALE
						&& p.age >= 13
						&& p.age <= 19;
			}
		}
		printPersons(roster, new TeenageBoyTester());

		
		System.out.println("Anonymous class: ");
		printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return p.gender == Sex.MALE
						&& p.age >= 13
						&& p.age <= 19;
			}
		});


		System.out.println("Lambda: ");
		printPersons(roster, (Person p)-> p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19
				);
		printPersons(roster, (Person p)-> { return p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19;}
				);
		
		System.out.println("printPersonsWithPredicte: ");
		printPersonsWithPredicte(roster, p -> 
		p.gender == Sex.MALE
		&& p.age >= 13
		&& p.age <= 19
				);

		
		System.out.println("processPerson: ");
		processPerson(roster, p -> p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19, 
				p->p.printPerson());

		
		System.out.println("processPersonWithFunction: ");
		processPersonWithFunction(roster,  p -> p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19, 
				p->p.emailAddress, 
				email->System.out.println(email));
		
		
		System.out.println("processElements: ");
		processElements(roster,  p -> p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19, 
				p->p.emailAddress, 
				email->System.out.println(email));
		
		
		System.out.println("aggregate function: ");
		roster.stream()
		.filter(p-> p.gender == Sex.MALE
				&& p.age >= 13
				&& p.age <= 19)
		.map(p->p.emailAddress)
		.forEach(email->System.out.println(email));
		
	}


	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithinAgeRange(
			List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}

	}


	interface CheckPerson {
		boolean test(Person p);
	}


	public static void printPersons(
			List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicte(List<Person> roster, 
			Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPerson(List<Person> roster, 
			Predicate<Person> tester,
			Consumer<Person> consumer) {
		for(Person p : roster) {
			if(tester.test(p)) {
				consumer.accept(p);
			}
		}
	}

	public static void processPersonWithFunction(List<Person> roster, 
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> consumer) {
		for(Person p : roster) {
			if(tester.test(p)) {
				String data = mapper.apply(p);
				consumer.accept(data);
			}
		}
	}

	
	public static<X, Y> void processElements(Iterable<X> source, 
			Predicate<X> tester,
			Function<X, Y> mapper, Consumer<Y> consumer) {
		for(X p : source) {
			if(tester.test(p)) {
				Y data = mapper.apply(p);
				consumer.accept(data);
			}
		}
	}


}
