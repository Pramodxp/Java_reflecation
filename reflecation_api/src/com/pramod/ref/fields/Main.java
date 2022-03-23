package com.pramod.ref.fields;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// printDelaredFieldsInfo(Category.class);
		Movie movie = new Movie("Lord of the rings", 2001, true, Category.ADEVNTURE, 12.99);
		printDelaredFieldsInfo(movie.getClass(), movie);

		// accessing the static final variable form Movie class.
		Field minPriceStaticField = Movie.class.getDeclaredField("MINIMUM_PRICE");
		// if we try to access the value of the non static variable we will get a
		// NUllPointerException.
		System.out.println(String.format("static MINIMUM_PRICE value is : %f", minPriceStaticField.get(null)));

	}

	//
	public static <T> void printDelaredFieldsInfo(Class<? extends T> clazz, T instance)
			throws IllegalArgumentException, IllegalAccessException {
		for (Field field : clazz.getDeclaredFields()) {
			System.out.println(String.format("field name : %s , field Type : %s , is Synthetic : %b", field.getName(),
					field.getType().getName(), field.isSynthetic()));
			System.out.println(String.format("value of the field is : %s", field.get(instance)));
		}
	}

	public static class Movie extends Product {
		public static final double MINIMUM_PRICE = 10.99;

		private boolean isReleased;
		private Category category;
		private double actualPrice;

		public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
			super(name, year);
			this.isReleased = isReleased;
			this.category = category;
			this.actualPrice = actualPrice;
		}

		/*
		 * synthetic fields : [additional fields other than declared in the class,the
		 * java compiler generates artifical fields for internal usage].
		 * 
		 * -[we dont see those fields unless we use reflecation to discover them at
		 * runtime].
		 * 
		 * -[synthetic fields and their names are compiler specific]
		 * 
		 * -[most of time we should not touch or modify them].
		 * 
		 * -[to find out we Field.isSynthetic].
		 */

		// non static moviestats class
		public class MovieStats {
			private double timesWatched;

			public MovieStats(double timesWatched) {
				super();
				this.timesWatched = timesWatched;
			}

			public double getRevenue() {
				return actualPrice * timesWatched;
			}
		}

	}

	// superclass
	public static class Product {
		protected String name;
		protected int year;
		protected double actualPrice;

		public Product(String name, int year) {
			super();
			this.name = name;
			this.year = year;
		}

	}

	public enum Category {
		ADEVNTURE, ACTION, COMEDY
	}

}
