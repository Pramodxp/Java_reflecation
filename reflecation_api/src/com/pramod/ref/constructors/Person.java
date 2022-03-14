package com.pramod.ref.constructors;

public class Person {
	private Address address;
	private String name;
	private int age;

	Person(Address address) {
		super();
		this.address = address;
	}

	Person(String name, int age) {
		super();
		this.name = name;
		this.name = name;
	}

	public Person(Address address, String name, int age) {
		super();
		this.address = address;
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", name=" + name + ", age=" + age + "]";
	}

}

class Address {
	private String street;
	private int houseNo;

	public Address(String street, int houseNo) {
		super();
		this.street = street;
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", houseNo=" + houseNo + "]";
	}

}