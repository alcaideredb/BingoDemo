package com.alcaideredb.bingo;

import java.util.Arrays;

public class Player {
	private int[][] card;
	private Bingo game;

	public Player(int[][] card, Bingo game) {
		this.card = card;
		this.game = game;
	}

	public void shoutBingo() {
		game.listenToBingo(this);
	}

	@Override
	public String toString() {
		return this.hashCode() + "_" + Arrays.deepToString(card);

	}

	public int[][] getCard() {
		return card;
	}

}
