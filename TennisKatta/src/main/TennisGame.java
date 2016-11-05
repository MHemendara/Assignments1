package main;

public class TennisGame {

	Player plyr1;
	Player plyr2;

	public TennisGame(String player1Name, String player2Name) {
		plyr1 = new Player(player1Name);
		plyr2 = new Player(player2Name);
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(plyr1.getPlyrName())) {
			plyr1.incrementScore();
		} else if (playerName.equals(plyr2.getPlyrName())) {
			plyr2.incrementScore();
		} else {
			throw new RuntimeException("Unkown player : " + playerName);
		}

	}

	public String getScore() {
		return formatScores();
	}

	private String formatScores() {
		StringBuilder sb = new StringBuilder();
		if (isDuce()) {
			sb.append("Deuce");
		} else if (isGameWon()) {
			sb.append("Win for ");
			sb.append(getLeadingPlayer().getPlyrName());
		} else if (isAdvantage()) {
			sb.append("Advantage ");
			sb.append(getLeadingPlayer().getPlyrName());
		} else if (isEqualScore()) {
			sb.append(spellScore(plyr1.getScore()));
			sb.append(" all");
		} else {
			sb.append(plyr1.getPlyrName());
			sb.append("-");
			sb.append(spellScore(plyr1.getScore()));
			sb.append(", ");
			sb.append(plyr2.getPlyrName());
			sb.append("-");
			sb.append(spellScore(plyr2.getScore()));
		}
		return sb.toString();
	}

	private Object spellScore(int score) {
		switch (score) {
		case 0:
			return "Love";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		case 3:
			return "Forty";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}

	private boolean isEqualScore() {
		return plyr1.getScore() == plyr2.getScore();
	}

	private boolean isAdvantage() {
		if(plyr1.getScore()>3 && plyr2.getScore()>3 && Math.abs(plyr1.getScore()-plyr2.getScore())==1){
			return true;
		}else{
			return false;
		}
	}

	private Player getLeadingPlayer() {
		if(plyr1.getScore()>plyr2.getScore()){
			return plyr1;
		}else if(plyr1.getScore()<plyr2.getScore()){
			return plyr2;
		}else{
			return null;
		}
	}

	private boolean isGameWon() {
		if(plyr1.getScore()>3 && Math.abs(plyr1.getScore()-plyr2.getScore())>1){
			return true;
		}
		if(plyr2.getScore()>3 && Math.abs(plyr1.getScore()-plyr2.getScore())>1){
			return true;
		}
		return false;
	}

	private boolean isDuce() {
		if(isEqualScore() && plyr1.getScore()>=3){
			return true;
		}else{
			return false;
		}
	}

}
