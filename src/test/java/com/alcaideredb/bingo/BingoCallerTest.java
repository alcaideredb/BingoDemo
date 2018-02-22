package com.alcaideredb.bingo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BingoCallerTest {

	@Test
	public void bingo_callers_numbers_should__range() {
		int uBound = 75;
		int lBound = 1;
		BingoCaller bingo = new BingoCaller();
		String assertMessage = "Bingo Number should be greater than 1 and less than or equal to 75 number was actually : ";

		for (int i = 0; i < 5; i++) {
			int cnum = bingo.callNextNumber();

			assertTrue(assertMessage + cnum, cnum > lBound);
			assertTrue(assertMessage + cnum, cnum <= uBound);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void all_numbers_expect_throw_exception() {
		int uBound = 75;
		int lBound = 1;
		BingoCaller bingo = new BingoCaller();
		String assertMessage = "Bingo Number should be greater than or equal to  1 and less than or equal to 75 number was actually : ";
		for (int i = 0; i < 76; i++) {
			int cnum = bingo.callNextNumber();

		}
	}

}