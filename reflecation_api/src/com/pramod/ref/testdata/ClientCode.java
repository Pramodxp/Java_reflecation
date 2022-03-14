package com.pramod.ref.testdata;

import com.pramod.ref.Exercise;

public class ClientCode {

	public static void main(String[] args) {
		Exercise exercise = new Exercise();
		exercise.findAllImplementedInterfaces(A.class);
	}
}
