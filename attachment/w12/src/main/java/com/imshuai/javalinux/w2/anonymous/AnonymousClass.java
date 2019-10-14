package com.imshuai.javalinux.w2.anonymous;

public class AnonymousClass {
	
	interface HelloWord {
		void say();
	}
	
	public void sayHello() {
		HelloWord englishHello = new HelloWord() {
			
			public void say() {
				System.out.println("Hello world.");
			}
		};
		
	}
}
