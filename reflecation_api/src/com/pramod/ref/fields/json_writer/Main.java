package com.pramod.ref.fields.json_writer;

import java.lang.reflect.Field;

import com.pramod.ref.fields.json_writer.data.Address;
import com.pramod.ref.fields.json_writer.data.Company;
import com.pramod.ref.fields.json_writer.data.Person;

public class Main {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Address address = new Address("Banglore Hrbr", (short) 1);
		Company company = new Company("Udemy", "San-fransisco", new Address("Chilli", (short) 0));
		Person person = new Person("john", true, 45, 100, address, company);

		System.out.println(objectToJson(person, 0));
	}

	public static String objectToJson(Object instance, int indentSize)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] declaredFields = instance.getClass().getDeclaredFields();
		StringBuilder builder = new StringBuilder();
		builder.append(indent(indentSize));
		builder.append("{");
		builder.append("\n");

		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			field.setAccessible(true);

			if (field.isSynthetic()) {
				continue;
			}

			builder.append(indent(indentSize + 1));

			builder.append(formatStringValue(field.getName()));
			builder.append(":");
			if (field.getType().isPrimitive()) {
				builder.append(formatPrimitiveValues(field, instance));
			} else if (field.getType().equals(String.class)) {
				builder.append(formatStringValue(field.get(instance).toString()));
			} else {
				builder.append(objectToJson(field.get(instance), indentSize + 1));
			}

			if (i != declaredFields.length - 1) {
				builder.append(",");
			}
			builder.append("\n");
		}

		builder.append(indent(indentSize));
		builder.append("}");

		return builder.toString();
	}

	// helper methods
	private static String formatPrimitiveValues(Field field, Object parentInstance)
			throws IllegalArgumentException, IllegalAccessException {
		if (field.getType().equals(boolean.class) || field.getType().equals(int.class)
				|| field.getType().equals(long.class) || field.getType().equals(short.class)) {
			return field.get(parentInstance).toString();
		} else if (field.getType().equals(double.class) || field.getType().equals(float.class)) {
			return String.format("%.02f", field.get(parentInstance));
		}

		throw new RuntimeException(String.format("Type : %s is unsupported", field.getType().getName()));
	}

	public static String formatStringValue(String value) {
		return String.format("\"%s\"", value);
	}

	private static String indent(int indentsize) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < indentsize; i++) {
			stringBuilder.append("\t");
		}
		return stringBuilder.toString();
	}
}
