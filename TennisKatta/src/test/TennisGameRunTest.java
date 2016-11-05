package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.TennisGame;

public class TennisGameRunTest {

	TennisGame tg;
	String player1 = "Bjorn Borg";// any other name also
	String player2 = "John McEnroe";// any other name also

	@Before
	public void setUp() throws Exception {
		tg = new TennisGame(player1, player2);
	}

	@Test
	public void testNewGame() {
		String score = tg.getScore();

		Assert.assertEquals("", "Love all", score);
	}

	@Test
	public void testPlayer1wonPoint() {
		tg.wonPoint(player1);

		String score = tg.getScore();
		Assert.assertEquals("", player1+"-Fifteen, "+player2+"-Love", score);
	}

	@Test
	public void testEachOnePointl() {
		tg.wonPoint(player1);
		tg.wonPoint(player2);

		String score = tg.getScore();
		Assert.assertEquals("", "Fifteen all", score);
	}

	@Test
	public void testPlayer2won2Pts() {
		createScore(0, 2);

		String score = tg.getScore();
		Assert.assertEquals("", player1+"-Love, "+player2+"-Thirty", score);
	}

	@Test
	public void testPlayer1won3Pts() {
		createScore(3, 0);
		String score = tg.getScore();
		Assert.assertEquals("", player1+"-Forty, "+player2+"-Love", score);
	}

	@Test
	public void testPlayerUnequalScore() {
		createScore(1, 3);
		String score = tg.getScore();
		Assert.assertEquals("", player1+"-Fifteen, "+player2+"-Forty", score);
	}

	@Test
	public void test3Dueuce() {
		createScore(3, 3);

		String score = tg.getScore();
		Assert.assertEquals("", "Deuce", score);
	}

	@Test
	public void testPlayer1WinsGame() {
		createScore(4, 0);

		String score = tg.getScore();
		Assert.assertEquals("", "Win for "+player1, score);
	}

	@Test
	public void testPlayer2WinsGame() {
		createScore(1, 4);

		String score = tg.getScore();
		Assert.assertEquals("", "Win for "+player2, score);
	}

	@Test
	public void testPlayers4Duce() {
		createScore(4, 4);
		String score = tg.getScore();
		Assert.assertEquals("", "Deuce", score);
	}

	@Test
	public void testPlayers14Duce() {
		createScore(15, 15);
		String score = tg.getScore();
		Assert.assertEquals("", "Deuce", score);
	}
	@Test
	public void testPlayer2Advantage() {
		createScore(4, 5);

		String score = tg.getScore();
		Assert.assertEquals("", "Advantage "+player2, score);
	}

	@Test
	public void testPlayer1Advantage() {
		createScore(5, 4);

		String score = tg.getScore();
		Assert.assertEquals("", "Advantage "+player1, score);
	}

	@Test
	public void testPlayer2Wins() {
		createScore(2, 4);
		String score = tg.getScore();
		Assert.assertEquals("", "Win for "+player2, score);
	}

	@Test
	public void testPlayer2WinsAdvantage() {
		createScore(6, 8);
		String score = tg.getScore();
		Assert.assertEquals("", "Win for "+player2, score);
	}

	@Test
	public void testPlayer1WinsAdvantage() {
		createScore(8, 6);
		String score = tg.getScore();
		Assert.assertEquals("", "Win for "+player1, score);
	}

	private void createScore(int playerOneBalls, int playerTwoBalls) {
		for (int i = 0; i < playerOneBalls; i++) {
			tg.wonPoint(player1);
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			tg.wonPoint(player2);
		}
	}

}
