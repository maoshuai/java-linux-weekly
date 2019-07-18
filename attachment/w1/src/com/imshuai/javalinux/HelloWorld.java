package com.imshuai.javalinux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imshuai.javalinux.service.IGreetingService;
import com.imshuai.javalinux.service.impl.AlienGreetingService;
import com.imshuai.javalinux.service.impl.CatGreetingService;
import com.imshuai.javalinux.service.impl.DogGreetingService;
import com.imshuai.javalinux.service.impl.HumanGreetingService;

public class HelloWorld {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		IGreetingService greetingService = null;

		if(args.length<=0) {
			logger.error("Nobody at home!");
			return;
		}

		String name = args[0];
		switch (name) {
		case "XiaoBai":
			greetingService = new CatGreetingService();
			break;
		case "DaHuang":
			greetingService = new DogGreetingService();
			break;
		case "XiaoMing":
			greetingService = new HumanGreetingService();
			break;
		default:
			greetingService = new AlienGreetingService();
			break;
		}
		greetingService.greet(name);
	}

}
