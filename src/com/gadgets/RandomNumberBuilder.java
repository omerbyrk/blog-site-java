package com.gadgets;

import java.util.Random;

public class RandomNumberBuilder {
	
	private static final Random random = new Random();

	public static int build(int bound) {
		// TODO Auto-generated method stub
		return random.nextInt(bound);
	}

}
