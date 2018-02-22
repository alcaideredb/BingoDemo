package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BingoCaller {

	public List<Integer> bingoCaller;
	public List<Integer> calledNumbers;

	public BingoCaller() {
		bingoCaller = new ArrayList<>();
		for (int i = 1; i <= 75; i++) {
			bingoCaller.add(i);
		}

		calledNumbers = new ArrayList<>();
		Collections.shuffle(bingoCaller, new Random(Bingo.RANDOM_SEED));
	}

	public int callNextNumber() {
		int next = bingoCaller.remove(0);
		calledNumbers.add(next);
		return next;
	}

	public List<Integer> getCalledNumbers() {
		return calledNumbers;
	}

}