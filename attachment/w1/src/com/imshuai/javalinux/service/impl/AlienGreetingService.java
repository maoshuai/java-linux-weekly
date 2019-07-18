package com.imshuai.javalinux.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imshuai.javalinux.service.IGreetingService;

public class AlienGreetingService implements IGreetingService {

	private static final Logger logger = LoggerFactory.getLogger(AlienGreetingService.class);
	@Override
	public void greet(String name) {
		logger.info("{} is saying hello: @#s*>?{,@=???", name);
	}

}
