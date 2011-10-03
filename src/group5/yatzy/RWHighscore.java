package group5.yatzy;

import java.util.*;
import java.io.*;
import android.content.Context;

/*
 * Class with methods to handle the 
 * file with the highscores.
 * @Emma Bogren
 */

public class RWHighscore 
{
	static String fileName = "highscores.txt";
	static final int HS_PLACES = 3;
	
	
	/*
	 * Creates an arraylist with empty scores,
	 * and creates a new file with these scores.
	 * Returns the arraylist.
	 */
	public static ArrayList<Entry<String,Integer>> newFile(Context c) throws IOException
	{
		FileOutputStream fOut = c.openFileOutput(fileName,Context.MODE_WORLD_READABLE);//PRIVATE?
		OutputStreamWriter osw = new OutputStreamWriter(fOut);
		BufferedWriter bw = new BufferedWriter(osw);
		
		ArrayList<Entry<String,Integer>> hs = new ArrayList<Entry<String,Integer>>();
		for(int i = 0; i < HS_PLACES; i++)
			hs.add(new Entry("Empty",0));
			
		for(Entry e : hs)
		{	
			bw.write(e.getKey() + " " + e.getValue() + "%");
		}
		bw.flush();
		fOut.close();
		
		return hs;
	}
	
	/*
	 * Reads the highscore list from an existing file,
	 * and returns it in an arraylist.
	 */
	public static ArrayList<Entry<String,Integer>> readHighScore(Context c) throws IOException
	{
		ArrayList<Entry<String,Integer>> hs = new ArrayList<Entry<String,Integer>>();
		FileInputStream fIn = c.openFileInput(fileName);
		InputStreamReader osr = new InputStreamReader(fIn);
		BufferedReader br = new BufferedReader(osr);
		try
		{
			String line = br.readLine();
			String[] nameScore = line.split("\\%");
			for(int i = 0; i < nameScore.length; i++){
				String[] oneWinner = nameScore[i].split("\\s");
				hs.add(new Entry(oneWinner[0],Integer.parseInt(oneWinner[1])));
			}
			return hs;
		}
		finally{
			
			fIn.close();
		}
	}
	
	/*
	 * Takes an arraylist with the highscores, and saves it to the file for the highscore list.
	 */
	public static void saveHighScore(ArrayList<Entry<String,Integer>> hs, Context c) throws IOException
	{
		FileOutputStream fOut = c.openFileOutput(fileName,Context.MODE_WORLD_READABLE);
		
		OutputStreamWriter osw = new OutputStreamWriter(fOut);
		BufferedWriter bw = new BufferedWriter(osw);
		for(Entry e : hs)
		{	
			bw.write(e.getKey() + " " + e.getValue() + "%");
		}
		bw.flush();
		fOut.close();
	}
	
}
