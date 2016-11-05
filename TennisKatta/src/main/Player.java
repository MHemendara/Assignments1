package main;

public class Player {
	
	private final String plyrName;
	private int score = 0;

	Player(String name){
		this.plyrName = name;
	}
	
	public String getPlyrName(){
		return plyrName;
	}
	
	public void incrementScore(){
		this.score++;
	}
	
	public int getScore(){
		return this.score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plyrName == null) ? 0 : plyrName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (plyrName == null) {
			if (other.plyrName != null)
				return false;
		} else if (!plyrName.equals(other.plyrName))
			return false;
		return true;
	}
	
}
