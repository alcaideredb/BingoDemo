package com.alcaideredb.bingo;

import java.util.List;

public interface BingoCheckerStrategy {
	public boolean isWinningCard(List<Integer> calledNums, int[][] card);
}
