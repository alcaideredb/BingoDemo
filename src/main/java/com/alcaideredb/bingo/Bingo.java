package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bingo {

	public static int RANDOM_SEED = 3;
	public List<Integer> bingoCaller;
	public List<Integer> calledNums;

	public Bingo() {
		bingoCaller = new ArrayList<>();
		for (int i = 1; i <= 75; i++)
			bingoCaller.add(i);
		calledNums = new ArrayList<>();
		Collections.shuffle(bingoCaller, new Random(RANDOM_SEED));
	}

	public int bgCallerNext() {
		int next = bingoCaller.remove(0);
		calledNums.add(next);
		return next;
	}

	public boolean bingoShout(int[][] card) {
		boolean win = true;
		List<Integer> notInCard = new ArrayList<>();
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {
				// free space
				if (card[i][j] == -1)
					continue;

				if (!calledNums.contains(card[i][j])) {
					notInCard.add(card[i][j]);
				}
			}
		}
		if (!notInCard.isEmpty()) {
			System.out.println("NOT IN CARD " + notInCard);
			return false;
		}

		return true;
	}

	public List<Integer> getCalledNumbers() {
		return calledNums;
	}

	public static int[][] generateBingoCard() {
		// row-wise 0th index is B, 1st index is I, 2nd index is N ... 4th index
		// is O
		int[][] bgcard = new int[5][5];

		for (int i = 0; i < 5; i++) {
			int cardRow[] = new int[5];
			List<Integer> insertNum = new ArrayList<>();
			for (int j = 1 + (i * 15); j <= 15 * (i + 1); j++) {
				insertNum.add(j);
			}
			Collections.shuffle(insertNum, new Random(RANDOM_SEED));

			for (int j = 0; j < 5; j++) {
				cardRow[j] = insertNum.remove(j);
			}
			bgcard[i] = cardRow;
		}

		// this represents free space
		bgcard[2][2] = -1;
		return bgcard;
	}
}
