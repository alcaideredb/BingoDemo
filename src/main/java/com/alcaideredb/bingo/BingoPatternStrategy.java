package com.alcaideredb.bingo;

import java.util.List;

public interface BingoPatternStrategy {
	public List<Integer> retrieveNonWinningNumbers(List<Integer> calledNums, int[][] card);
}
