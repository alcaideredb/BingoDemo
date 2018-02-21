package com.alcaideredb.bingo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

public class BingoTest {

	@Test
	public void retFiveBgCalls() {
		int uBound = 75;
		int lBound = 1;
		Bingo bingo = new Bingo();
		String assertMessage = "Bingo Number should be greater than 1 and less than or equal to 75 number was actually : ";

		for (int i = 0; i < 5; i++) {
			int cnum = bingo.bgCallerNext();

			assertTrue(assertMessage + cnum, cnum > lBound);
			assertTrue(assertMessage + cnum, cnum <= uBound);
		}
	}

	@Test
	public void all_numbers_expect_throw_exception() {
		int uBound = 75;
		int lBound = 1;
		Bingo bingo = new Bingo();
		String assertMessage = "Bingo Number should be greater than or equal to  1 and less than or equal to 75 number was actually : ";
		for (int i = 0; i < 76; i++) {
			int cnum = bingo.bgCallerNext();

		}
	}

	@Test
	public void generateBingoCardTest() {
		fail("NOT IMPLEMENTED");
		// int[][] expected = { { 9, 10, 1, 11, 4 }, { 24, 25, 16, 26, 19 }, {
		// 39, 40, -1, 41, 34 },
		// { 54, 55, 46, 56, 49 }, { 69, 70, 61, 71, 64 } };
		//
		// assertArrayEquals(Bingo.generateBingoCard(), expected);

	}

	@Test
	public void chkWin() {
		Bingo bingo = new Bingo();
		int[][] card = Bingo.generateBingoCard();
		for (int i = 0; i < 74; i++) {
			bingo.bgCallerNext();
		}
		System.out.println(bingo.getCalledNumbers());

		System.out.println(Arrays.deepToString(card));
		assertTrue(bingo.bingoShout(card));

	}
}
