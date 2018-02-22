package com.alcaideredb.bingo;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BingoCardGeneratorTest {
	@Test
	public void check_card_generation_using_default_seed() {
		int[][] expected = { { 9, 10, 1, 11, 4 }, { 24, 25, 16, 26, 19 }, { 39, 40, -1, 41, 34 },
				{ 54, 55, 46, 56, 49 }, { 69, 70, 61, 71, 64 } };

		assertArrayEquals(new BingoCardGenerator().generateBingoCard(), expected);

	}

}
