
public class Player {
	static int noOfPlayers = 0;
	private int score = 0;
	private String name = "Player # " + Integer.toString(noOfPlayers+1);
	
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
