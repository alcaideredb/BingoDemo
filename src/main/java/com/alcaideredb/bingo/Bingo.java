package com.alcaideredb.bingo;

import java.util.ArrayList;
import java.util.List;

public class Bingo {

	public static int RANDOM_SEED = 3;
	private BingoCaller bingoCaller;
	private BingoChecker bingoChecker;
	private List<Player> winners;

	public Bingo() {
		this(new BlackoutPatternStrategy());
	}

	public Bingo(BingoPatternStrategy bingoPatternStrategy) {
		this.bingoCaller = new BingoCaller();
		this.bingoChecker = new BingoChecker(bingoPatternStrategy);
		this.winners = new ArrayList<>();
	}

	public int callNextNumber() {
		return bingoCaller.callNextNumber();
	}

	public List<Integer> calledNumbers() {
		return bingoCaller.getCalledNumbers();
	}

	public boolean isGameWon() {
		return !winners.isEmpty();
	}

	public List<Player> getWinners() {
		return winners;
	}

	public void listenToBingo(Player player) {
		if (bingoChecker.isWinningCard(bingoCaller.getCalledNumbers(), player.getCard())) {
			winners.add(player);
		}
	}
}
