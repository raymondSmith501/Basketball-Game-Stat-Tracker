/**
 * Represents a player on the team.
 * Holding his first and last name and jersey number
 * @author Raymond Smith
 */
package edu.trident.Smith;

public class Player 
{
	private String firstName;
	private String lastName;
	private int number;
	
	/**
	 * Constructor for Player
	 * @param first
	 * @param last
	 * @param num
	 */
	public Player(String first, String last, int num)
	{
		firstName = first;
		lastName = last;
		number = num;
	}/*End Player
	
	/**
	 * Returns player's first name
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}/*End getFirstName*/
	
	/**
	 * Sets player's first name
	 * @param first
	 */
	public void setFirstName(String first)
	{
		firstName = first;
	}/*End setFirstName*/
	
	/**
	 * returns player's last name
	 * @returnlastName
	 */
	public String getLastName()
	{
		return lastName;
	}/*End getLastName*/
	
	/**
	 * sets player's last name
	 * @param last
	 */
	public void setLastName(String last)
	{
		lastName = last;
	}/*End setLastName*/
	
	/**
	 * Returns player's jersey number
	 * @return number
	 */
	public int getNumber()
	{
		return number;
	}/*End getNumber*/
	
	/**
	 * Sets player's jersey number
	 * @param num
	 */
	public void setNumber(int num)
	{
		number = num;
	}/*End setNumber*/
	
	
}
