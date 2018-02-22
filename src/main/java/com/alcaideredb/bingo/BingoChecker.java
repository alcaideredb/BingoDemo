package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.List;

public class BingoChecker {

	public boolean isWinningCard(List<Integer> calledNums, int[][] card) {
		boolean win = true;
		List<Integer> nonWinningNumbers = retrieveNonWinningNumbers(calledNums, card);

		if (!nonWinningNumbers.isEmpty()) {
			System.out.println("Numbers not in card " + nonWinningNumbers);
			return false;
		}

		return true;
	}

	private List<Integer> retrieveNonWinningNumbers(List<Integer> calledNums, int[][] card) {
		List<Integer> notInCard = new ArrayList<>();

		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {
				if (card[i][j] == -1) {
					continue;
				}

				if (!calledNums.contains(card[i][j])) {
					notInCard.add(card[i][j]);
				}
			}
		}
		return notInCard;
	}

}
