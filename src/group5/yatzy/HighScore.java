package group5.yatzy;

import java.util.*;
import java.io.*;

import android.content.Context;

/**
 * @author Emma Bogren
 * Class for representing a Highscore list.
 */

public class HighScore {

	ArrayList<Entry<String,Integer>> winners;
	int HS_PLACES = 3;
	Context c;
	
	/**
	 * Constructor. Loads the highscorelist from
	 * a file, and creates empty scores if necessary.
	 */
	public HighScore(Context c)
	{
		this.c = c;
		try{
			winners = RWHighscore.readHighScore(c);
		}
		catch(IOException e)
		{
			try{
				winners = RWHighscore.newFile(c); //FileNotFoundException
			}
			catch(IOException e2){}
		}	
	}
	
	/**
	 * Returns all names on the highscorelist.	 
	 */
	public String[] getWinnerNames()
	{
		String[] names = new String[HS_PLACES];
		int i = 0;
		for(Entry e : winners)
		{
			names[i] = (String) e.getKey();
			i++;
		}
		return names;
		
	}
	
	/**
	 * Returns all scores on the highscorelist.	 
	 */
	public int[] getWinnerScores()
	{
		int[] scores = new int[HS_PLACES];
		int i = 0;
		for(Entry e : winners)
		{
			scores[i] = (Integer) e.getValue();
			i++;
		}
		return scores;
		
	}
	
	/**
	 * Takes a name and a score. Updates the highscore
	 * list if score is good enough.
	 */
	public void update(String name,int score)
	{
		int i = 0;
		for(Entry e:winners)
		{
			if((Integer)e.getValue() <= score)
			{
				winners.add(i,new Entry(name,score));
				winners.remove(winners.size()-1);
				saveHS();
				break;
			}	
			i++;
		}
		
	}
	
	/**
	 * Clear the highscorelist and add empty scores.
	 */
	public void clear()
	{
		winners.clear();
		for(int i = 0; i<HS_PLACES; i++)
			winners.add(new Entry("Empty",0));
		saveHS();
	}
	
	/**
	 * Saves the highscore list to a file.
	 */
	private void saveHS()
	{
		try{
			RWHighscore.saveHighScore(winners,c);
		}
		catch(IOException e)
		{
			//File does not exist -> what to do?
		}
	}
}
