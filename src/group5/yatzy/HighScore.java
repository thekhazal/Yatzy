package group5.yatzy;

import java.util.*;

public class HighScore {

	ArrayList<Entry<String,Integer>> winners;
	int HS_PLACES = 3;
	
	/*
	 * Constructor. Fills the highscorelist with empty scores.
	 */
	public HighScore()
	{
		winners = new ArrayList<Entry<String,Integer>>();
		for(int i = 0; i<HS_PLACES; i++)
			winners.add(new Entry("Empty",0));
	}
	
	/*
	 * Returns all names and scores on the highscorelist.
	 */
	public ArrayList<Entry<String,Integer>> getWinners()
	{
		return winners;
	}
	
	
	/*
	 * Takes a name and a score. Updates the highscore
	 * list if score is good enough, and returns the 
	 * position on the list. If the score is not good
	 * enough, zero is returned.
	 */
	public int update(String name,int score)
	{
		int i = 1;
		for(Entry e:winners)
		{
			if((Integer)e.getValue() < score)
			{
				winners.add(new Entry(name,score));
				winners.remove(winners.size());
				return i;
			}
			i++;	
		}
		return 0;
	}
	
	/*
	 * Empty the highscorelist and add empty scores.
	 */
	public void clear()
	{
		for(Entry e:winners)
			winners.remove(e);
		for(int i = 0; i<HS_PLACES; i++)
			winners.add(new Entry("Empty",0));
	}
	
}
