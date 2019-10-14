package com.imshuai.javalinux.w2.lambda;

import java.util.function.Consumer;

public class LmabdaScopeTest {
	public static void main(String[] args) {
		// 定义一个局部变量
		int age = 3;

		Consumer<String> consumer2 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				int age = 4; // 覆盖局部变量定义
			}
		};

		Consumer<String> consumer = str->{
			/*
			 * 编译报错:
			 * Lambda expression's local variable age cannot redeclare
			 * another local variable defined in an enclosing scope.
			 */
//			int age = 4; // lambda没有引入新的scope,相当于重复定义.
		};

		/*
		 * Variable declarations

Assignments

Return statements

Array initializers

Method or constructor arguments

Lambda expression bodies

Conditional expressions, ?:

		 */

		Consumer<String> consumer1 = str -> {};
		
		lambdaParameter(str->{});
		
		
		// Cast expressions
		Object a = (Consumer<String>)str -> {

		};

	}
	
	public static void lambdaParameter(Consumer<String> consumer) {
	}
	
	public static Consumer<String> returnLambda(){
		return str->{};
	}
}
