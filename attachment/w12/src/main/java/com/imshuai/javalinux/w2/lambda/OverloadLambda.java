package com.imshuai.javalinux.w2.lambda;

import java.util.concurrent.Callable;

public class OverloadLambda {
	public static void invoke(Runnable runnable) {
		runnable.run();
	}
	public static void invoke(Callable<String> callable) throws Exception {
		callable.call();
	}

	public static void main(String[] args) throws Exception {
		invoke(()-> System.out.println("")); // runable
		invoke(()-> "hello");// callable
	}
}
