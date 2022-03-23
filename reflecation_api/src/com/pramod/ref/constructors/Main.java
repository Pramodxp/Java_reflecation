package com.pramod.ref.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// printConstructors(Person.class);
		// printConstructors(Address.class);

		// will create and instance of Person class constructor with arguments
		Address address = createInstanceWithArgument(Address.class, "Banglore", 1);
		System.out.println(address);

//		// will create and instance of Person class constructor with no arguments
//		Person person = (Person) createInstanceWithArgument(Person.class);
//		System.out.println(person);

		// will create and instance of Person class constructor with arguments
		Person person = createInstanceWithArgument(Person.class, address,"Banglore", 1);
		System.out.println(person);
	}

	// helps to find the constructor of the class.
	static <T> void printConstructors(Class<T> inputClass) {
		// declared Constructors will get you all the constructors declared in the
		// class.
		Constructor<?>[] declaredConstructors = inputClass.getDeclaredConstructors();
		System.out.println(String.format("class is %s and constructor size is %d ", inputClass.getSimpleName(),
				declaredConstructors.length));
		for (int i = 0; i < declaredConstructors.length; i++) {
			// getParameterTypes will get you all the parameters for the constructor.
			Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
			List<String> parameterTypeNames = Arrays.stream(parameterTypes).map(type -> type.getSimpleName())
					.collect(Collectors.toList());

			System.out.println(parameterTypeNames);
		}
	}

	// used to find the constructor of the class and create and object of it.
	static <T> T createInstanceWithArgument(Class<T> inputClass, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Constructor<?> constructor : inputClass.getDeclaredConstructors()) {
			if (constructor.getParameterCount() == args.length) {
				// is used to invoke to create and object using the parameters
				return (T)constructor.newInstance(args);
			}
		}
		System.out.println("An appropriate constructon wasnot found::");
		return null;
	}

}
