package com.alcaideredb.bingo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BingoTest {

	@Test
	public void when_player_shouts_bingo_game_is_won() {
		Bingo bingo = new Bingo();
		int[][] card = new BingoCardGenerator().generateBingoCard();
		Player player = new Player(card, bingo);

		for (int i = 1; i <= 75; i++) {
			bingo.callNextNumber();

			if (i == 74) {
				player.shoutBingo();
			}
		}

		assertTrue(bingo.isGameWon());
	}

	@Test
	public void when_multiple_player_shouts_bingo_game_is_won() {
		Bingo bingo = new Bingo();
		int[][] card = new BingoCardGenerator().generateBingoCard();
		int[][] card2 = new BingoCardGenerator().generateBingoCard();
		Player player1 = new Player(card, bingo);
		Player player2 = new Player(card2, bingo);

		for (int i = 1; i <= 75; i++) {
			bingo.callNextNumber();

			if (i == 74) {
				player1.shoutBingo();
				player2.shoutBingo();
			}
		}
		final int NUM_OF_WINNERS = 2;
		assertEquals(NUM_OF_WINNERS, bingo.getWinners().size());
		assertTrue(bingo.isGameWon());
	}

}
