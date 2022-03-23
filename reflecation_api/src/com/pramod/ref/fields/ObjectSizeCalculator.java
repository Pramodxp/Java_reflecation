package com.pramod.ref.fields;

import java.lang.reflect.Field;

public class ObjectSizeCalculator {

	private static final long HEADER_SIZE = 12;
	private static final long REFERENCE_SIZE = 4;

	public long sizeOfObject(Object input) throws IllegalArgumentException, IllegalAccessException {
		long size = HEADER_SIZE + REFERENCE_SIZE;
		for (Field field : input.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.getType().isPrimitive()) {
				size += sizeOfPrimitiveType(field.getType());
			} else {
				size += sizeOfString((String) field.get(input));
			}
		}
		return size;
	}

	/*************** Helper methods ********************************/
	private long sizeOfPrimitiveType(Class<?> primitiveType) {
		if (primitiveType.equals(int.class)) {
			return 4;
		} else if (primitiveType.equals(long.class)) {
			return 8;
		} else if (primitiveType.equals(float.class)) {
			return 4;
		} else if (primitiveType.equals(double.class)) {
			return 8;
		} else if (primitiveType.equals(byte.class)) {
			return 1;
		} else if (primitiveType.equals(short.class)) {
			return 2;
		} else if (primitiveType.equals(boolean.class)) {
			return 1;
		} else if (primitiveType.equals(char.class)) {
			return 2;
		}
		throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
	}

	private long sizeOfString(String inputString) {
		int stringBytesSize = inputString.getBytes().length;
		return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
	}

	
	//client code
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ObjectSizeCalculator calculator = new ObjectSizeCalculator();

		AccountSummary accountSummary = new AccountSummary("Pramod", "Kumar", (short) 11, 10, 25);
		System.out.println(String.format("size of the object is : %d", calculator.sizeOfObject(accountSummary)));
	}
}