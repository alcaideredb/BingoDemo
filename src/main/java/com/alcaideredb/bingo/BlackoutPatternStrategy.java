package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.List;

public class BlackoutPatternStrategy implements BingoPatternStrategy {
	public List<Integer> retrieveNonWinningNumbers(List<Integer> calledNums, int[][] card) {
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
