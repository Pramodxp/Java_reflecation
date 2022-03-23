package com.pramod.ref.constructorswebserver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) {

	}

	public void initConfiguration() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<ServerConfiguration> declaredConstructor = ServerConfiguration.class
				.getDeclaredConstructor(int.class, String.class);
		declaredConstructor.newInstance(8080, "pramod");
	}
}
