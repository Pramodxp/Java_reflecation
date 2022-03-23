package com.pramod.ref.fields.arrays;

import java.lang.reflect.Array;

public class InspectArrays {
	public static void main(String[] args) {

		int[] oneDimentionalArray = { 10, 20, 30 };
		int[][] twoDimentionalArray = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };

//		insopectArrayObject(twoDimentionalArray);
		inspectArrayValues(twoDimentionalArray);
	}

	public static void inspectArrayValues(Object arrayObject) {
		int length = Array.getLength(arrayObject);

		System.out.print("[");

		for (int i = 0; i < length; i++) {
			Object element = Array.get(arrayObject, i);

			if (element.getClass().isArray()) {
				// recursively calling the inspectvalues method to processmultidimentional
				// array.
				inspectArrayValues(element);
			} else {
				System.out.print(element);
			}
			if (i != length - 1) {
				System.out.print(" , ");
			}
		}

		System.out.print("]");

	}

	public static void insopectArrayObject(Object object) {
		Class<?> clazz = object.getClass();
		System.out.println(String.format("the given object is and array : %b", clazz.isArray()));

		Class<?> componentType = clazz.getComponentType();

		System.out.println(String.format("This is array of Type : %s ", componentType.getSimpleName()));
	}
}
