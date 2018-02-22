package com.alcaideredb.bingo;

import java.util.List;

public class BingoChecker {
	private BingoPatternStrategy bingoPatternCheckingStrategy;

	public BingoChecker(BingoPatternStrategy bingoPatternCheckingStrategy) {
		this.bingoPatternCheckingStrategy = bingoPatternCheckingStrategy;
	}

	public boolean isWinningCard(List<Integer> calledNums, int[][] card) {
		boolean win = true;
		List<Integer> nonWinningNumbers = bingoPatternCheckingStrategy.retrieveNonWinningNumbers(calledNums, card);

		if (!nonWinningNumbers.isEmpty()) {
			System.out.println("Numbers not in card " + nonWinningNumbers);
			return false;
		}

		return true;
	}

}
