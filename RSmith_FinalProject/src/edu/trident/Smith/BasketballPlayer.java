package edu.trident.Smith;

import java.text.DecimalFormat;

public class BasketballPlayer extends Player
{
	private int shotsTaken;
	private int madeShots;
	private int threesTaken;
	private int made3s;
	private int freesTaken;
	private int madeFrees;
	private int points;
	private int fouls;
	private int assists;
	private int blocks;
	private int steals;
	private int rebounds;
	private PlayerAlert alert = null;
	private DecimalFormat df = new DecimalFormat("###.##");
	
	/**
	 * Constructor for BasketballPlayer
	 * @param first
	 * @param last
	 * @param num
	 */
	public BasketballPlayer(String first, String last, int num) 
	{
		super(first, last, num);
		shotsTaken = 0;
		madeShots = 0;
		threesTaken = 0;
		made3s = 0;
		freesTaken = 0;
		madeFrees = 0;
		points = 0;
		fouls = 0;
		assists = 0;
		blocks = 0;
		steals = 0;
		rebounds = 0;
	}/*End BasketballPlayer*/
	
	/**
	 * Sets alert for player's foul trouble
	 * @param p
	 */
	public void setAlert(PlayerAlert p)
	{
		alert = p;
	}/*End setAlert*/
	
	public String toString()
	{
		String str = (getNumber() + " " + getLastName() + ", " + getFirstName());
		
		return str;
	}
	
	/**
	*returns # of shots taken 
	* @return shotsTaken
	*/
	public int getShotsTaken()
	{
		return shotsTaken;
	}/*End getShots*/
	
	/**
	 * returns # of shots made
	 * @return madeShots
	 */
	 public int getMadeShots()
	 {
		 return madeShots;
	 }/*End getMadeShots*/
	
	 /**
	  * Returns number of 3 point shots taken
	  * @return threesTaken
	  */
	 public int getThreesTaken()
	 {
		 return threesTaken;
	 }/*End getThreesTaken*/
	 
	 /**
	  * Return number of 3 point shots made
	  * @return getThreesMade
	  */
	 public int getThreesMade()
	 {
		 return made3s;
	 }/*End getThreesMade*/
	 
	 /**
	  * Returns number of free throws taken
	  * @return freesTaken
	  */
	 public int getFreesTaken()
	 {
		 return freesTaken;
	 }/*End getFreesTaken*/
	 
	 /**
	  * Returns number of free throws made
	  * @return madeFrees
	  */
	 public int getMadeFrees()
	 {
		 return madeFrees;
	 }/*getMadeFrees*/
	 
	 /**
	  * Return points scored
	  * @return
	  */
	 public int getPoints()
	 {
		 return points;
	 }/*End getPoints*/
	 
	 /**
	  * Returns number of fouls player has
	  * @return fouls
	  */
	 public int getFouls()
	 {
		 return fouls;
	 }/*End getFouls*/
	 
	 /**
	  * Returns number of blocks player has
	  * @return blocks
	  */
	 public int getBlocks()
	 {
		 return blocks;
	 }/*End getBlocks*/
	 
	 /**
	  * Returns number of assists player has
	  * @return assists
	  */
	 public int getAssists()
	 {
		 return assists;
	 }/*End getAssists*/
	 
	 /**
	  * Returns number of steals player has
	  * @return steals
	  */
	 public int getSteals()
	 {
		 return steals;
	 }/*End getSteals*/
	 
	 /**
	  * Returns number of rebounds player has
	  * @return rebounds
	  */
	 public int getRebounds()
	 {
		 return rebounds;
	 }/*End getRebounds*/
	 
	/**
	 * Used to represent player making 2 point shot
	 */
	public void made2()
	{
		shotsTaken ++;
		madeShots++;
		points += 2;
	}/*End made2*/
	
	/**
	 * Used to represent player missing 2 point shot
	 */
	public void missed2()
	{
		shotsTaken ++;
	}/*End missed2*/
	
	/**
	 * Used to represent player making 3pointer
	 */
	public void made3()
	{
		threesTaken ++;
		made3s ++;
		shotsTaken ++;
		madeShots ++;
		points += 3;
	}/*End made3*/
	
	/**
	 * Used to represent player missing 3point shot
	 */
	public void missed3()
	{
		threesTaken ++;
		shotsTaken ++;
	}/*End missed3*/
	
	/**
	 * Used to represent player making Free Throw
	 */
	public void freeMade()
	{
		freesTaken ++;
		madeFrees ++;
		points += 1;
	}/*End freeMade*/
	
	/**
	 * Used to represent payer missing Free Throw
	 */
	public void missedFree()
	{
		freesTaken ++;
	}/*End missedFree*/
	
	/**
	 * Used to add foul to stats
	 * Also send warnings for foul trouble
	 */
	public void commitFoul()
	{
		fouls ++;
		
		/*Call warnings if player has one foul remaining or has fouled out*/
		if (fouls == 4)
		{
			String title = "4 Fouls";
			String msg = "Player #" + getNumber() + " has 4 fouls.\n One more till they foul out";
			alert.alert(title, msg);
		}/*End if player has 4 fouls*/
		
		if(fouls ==5)
		{
			String title = "Fouled Out";
			String msg = "Player #" + getNumber() + " has fouled out.\n They are no longer available";
			alert.alert(title, msg);			
		}/*End if player has fouled out*/
	}/*End commitFoul*/
	
	/**
	 * Used to add an assist to stats
	 */
	public void assist()
	{
		assists ++;
	}/*End assist*/
	
	/**
	 * Used to add a block to stats
	 */
	public void block()
	{
		blocks ++;
	}/*End block*/
	
	/**
	 * Used to add a steal to stats
	 */
	public void steal()
	{
		steals ++;
	}/*End steal*/
	
	/**
	 * Used to add rebound to stats
	 */
	public void rebound()
	{
		rebounds ++;
	}
	
	/**
	 * Returns player's fieldgoal percentage
	 * @return fgPerc
	 */
	public String getFieldgoalPerc()
	{
		double fgPerc;
		if(shotsTaken == 0)
		{
			return "0";
		}
		
		fgPerc = (madeShots/(double)shotsTaken)*100;
		
		return df.format(fgPerc);
	}/*End fgPerc*/
	
	/**
	 * Return 3 point shot percentage
	 * @return threePerc
	 */
	public String getThreePointPerc()
	{
		double threePerc;
		
		if(threesTaken == 0)
		{
			return "0";
		}
		threePerc = (made3s/(double)threesTaken)*100;
		
		return df.format(threePerc);
	}/*End getThreePointPerc*/
	
	/**
	 * Returns players free throw percentage
	 * @return freePerc
	 */
	public String getFreePerc()
	{
		double freePerc;
		
		if(freesTaken == 0)
		{
			return "0";
		}
		freePerc = (madeFrees/(double)freesTaken)*100;
		
		return df.format(freePerc);
	}/*End getFreePerc*/
	
}

