package com.pramod.ref;

import java.util.HashSet;
import java.util.Set;

public class Exercise {

	/**
	 * Returns all the interfaces that the current input class implements. Note: If
	 * the input is an interface itself, the method returns all the interfaces the
	 * input interface extends.
	 */
	static Set<Class<?>> allImplementedInterfaces = new HashSet<>();
	public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {

		Class<?>[] inputInterfaces = input.getInterfaces();
		for (Class<?> currentInterface : inputInterfaces) {
			allImplementedInterfaces.add(currentInterface);
			allImplementedInterfaces.addAll(findAllImplementedInterfaces(currentInterface));
		}

		return allImplementedInterfaces;
	}
}