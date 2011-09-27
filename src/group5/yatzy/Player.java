package group5.yatzy;

/**
 * @author Johan Grunden, Anmar Khazal
 * This is a class which will model a player in the game
 **/
public class Player {
	
	private String name;	
	private int score;
	
	/**
	 * A new player needs a name and his score set to zeros
	**/
	public Player(String name){ 
		this.name = name;
		this.score = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}
