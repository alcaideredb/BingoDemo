package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BingoCardGenerator {
	private static final int FREE_SPACE_NUMBER = -1;

	public int[][] generateBingoCard() {
		// row-wise 0th index is B, 1st index is I, 2nd index is N ... 4th index
		// is O
		int[][] bgcard = new int[5][5];
		for (int i = 0; i < 5; i++) {
			int[] cardRow = retrieveShuffledRowForIndex(i);
			bgcard[i] = cardRow;
		}

		bgcard[2][2] = FREE_SPACE_NUMBER;
		return bgcard;
	}

	private int[] retrieveShuffledRowForIndex(int i) {
		final int ROW_LENGTH = 15;
		int cardRow[] = new int[5];
		List<Integer> rowForShuffling = new ArrayList<>();

		for (int j = 1 + (i * ROW_LENGTH); j <= ROW_LENGTH * (i + 1); j++) {
			rowForShuffling.add(j);
		}

		Collections.shuffle(rowForShuffling, new Random(Bingo.RANDOM_SEED));

		for (int j = 0; j < 5; j++) {
			cardRow[j] = rowForShuffling.remove(j);
		}
		return cardRow;
	}

}
