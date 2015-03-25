/**
 * GameTrackerUI is the user interface to track game stats
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameTrackerUI extends JFrame implements PlayerAlert, ActionListener, ItemListener
{
	private final int HEIGHT = 200;
	private final int WIDTH = 400;
	private ArrayList<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
	private JTextField text1 = new JTextField(15);
	private JTextField text2 = new JTextField(15);
	private JTextField number = new JTextField(2);
	private JLabel label1 = new JLabel("Enter Player's First Name");
	private JLabel label2 = new JLabel("Enter Player's Last Name"); 
	private JLabel num = new JLabel("Enter Player's Number");
	private JLabel roster = new JLabel(players.size() + " of 12 Players Loaded");
	private JButton start = new JButton("Start Game");
	private JButton load = new JButton("Load Player");
	private JPanel first = new JPanel();
	private JPanel second = new JPanel();
	private JPanel jerseyNum = new JPanel();
	private JPanel loadStart = new JPanel();
	private JPanel rosterPanel = new JPanel();
	private JButton made2 = new JButton("Made 2 Point Shot");
	private JButton missed2 = new JButton("Missed 2 Point Shot");
	private JButton made3 = new JButton("Made 3 Point Shot");
	private JButton missed3 = new JButton("Missed 3 Point Shot");
	private JButton madeFree = new JButton("Made Free Throw");
	private JButton missedFree = new JButton("Missed Free Throw");
	private JButton block = new JButton("Blocked Shot");
	private JButton assist = new JButton("Assist");
	private JButton steal = new JButton("Steal");
	private JButton foul = new JButton("Foul");
	private JButton rebound = new JButton("Rebound");
	private JButton summary = new JButton("End Game/Compile Summary");
	private JLabel points = new JLabel("");
	private JLabel fieldgoals = new JLabel("");
	private JLabel fieldgoalPerc = new JLabel();
	private JLabel threePointers = new JLabel();
	private JLabel threePointPerc = new JLabel();
	private JLabel freeThrows = new JLabel();
	private JLabel freeThrowPerc = new JLabel();
	private JLabel blockStats = new JLabel();
	private JLabel assistStats = new JLabel();
	private JLabel stealStats = new JLabel();
	private JLabel foulStats = new JLabel();
	private JLabel reboundStats = new JLabel();
	private JPanel box = new JPanel();
	private JPanel shots = new JPanel();
	private JPanel threes = new JPanel();
	private JPanel frees = new JPanel();
	private JPanel blkAsst = new JPanel();
	private JPanel stlFoul = new JPanel();
	private JPanel reboundEnd = new JPanel();
	private JComboBox<BasketballPlayer> playerBox = new JComboBox<BasketballPlayer>();
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	public GameTrackerUI()
	{
		
		super("Smith GameTracker");
		//setDefaultLookAndFeelDecorated(true);
		setSize(WIDTH, HEIGHT);
		
		/*Set Layouts for panels*/
		first.setLayout(new GridLayout(1,2,3,3));
		second.setLayout(new GridLayout(1,2,3,3));
		jerseyNum.setLayout(new GridLayout(1,2,3,3));
		loadStart.setLayout(new GridLayout(1,2,3,3));
		box.setLayout(new GridLayout(2,1));
		shots.setLayout(new GridLayout(2,2,2,2));
		threes.setLayout(new GridLayout(2,2,2,2));
		frees.setLayout(new GridLayout(2,2,2,2));
		blkAsst.setLayout(new GridLayout(2,2,2,2));
		stlFoul.setLayout(new GridLayout(2,2,2,2));
		reboundEnd.setLayout(new GridLayout(2,2,2,2));
		
		/*Add components to correct panels*/
		first.add(text1);
		first.add(label1);
		second.add(text2);
		second.add(label2);
		jerseyNum.add(number);
		jerseyNum.add(num);
		rosterPanel.add(roster);
		loadStart.add(load);
		loadStart.add(start);
		box.add(playerBox);
		box.add(points);
		shots.add(made2);
		shots.add(missed2);
		shots.add(fieldgoals);
		shots.add(fieldgoalPerc);
		frees.add(madeFree);
		frees.add(missedFree);
		frees.add(freeThrows);
		frees.add(freeThrowPerc);
		threes.add(made3);
		threes.add(missed3);
		threes.add(threePointers);
		threes.add(threePointPerc);
		blkAsst.add(block);
		blkAsst.add(assist);
		blkAsst.add(blockStats);
		blkAsst.add(assistStats);
		stlFoul.add(steal);
		stlFoul.add(foul);
		stlFoul.add(stealStats);
		stlFoul.add(foulStats);
		reboundEnd.add(rebound);
		reboundEnd.add(summary);
		reboundEnd.add(reboundStats);
		
		
		/*Add Action Listeners*/
		load.addActionListener(this);
		start.addActionListener(this);
		made2.addActionListener(this);
		missed2.addActionListener(this);
		made3.addActionListener(this);
		missed3.addActionListener(this);
		madeFree.addActionListener(this);
		missedFree.addActionListener(this);
		block.addActionListener(this);
		assist.addActionListener(this);
		steal.addActionListener(this);
		foul.addActionListener(this);
		rebound.addActionListener(this);
		summary.addActionListener(this);
		playerBox.addItemListener(this);
		
		/*Load Frame*/
		setLayout(new GridLayout(5,1,3,3));
		add(first);
		add(second);
		add(jerseyNum);
		add(rosterPanel);
		add(loadStart);
		
		/*Set Window Characteristics*/
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	/**
	 * alerts the user when the player has foul trouble
	 */
	@Override
	public void alert(String title, String msg) 
	{	
		JLabel label = new JLabel(msg);  
        label.setFont(new Font("serif", Font.PLAIN, 20));
		JOptionPane.showMessageDialog(null, label, title,JOptionPane.WARNING_MESSAGE, null);
	}/*End Alert*/
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source == load)
		{
			loadPlayer();
		}
		else if(source == start)
		{
			if(players.size() < 5)
			{
				JLabel label = new JLabel("Must have at least 5 players on roster!");  
		        label.setFont(new Font("serif", Font.PLAIN, 20));
				JOptionPane.showMessageDialog(null, label, "Error",JOptionPane.WARNING_MESSAGE, null);
			}
			else
			{
				setSize(500,500);
				setLocation(400, 100);
				setLayout(new GridLayout(7,1,3,3));
				
				for (int p = 0; p < players.size(); p++)
				{
					playerBox.addItem(players.get(p));
				}
				
				/*Set Alert*/
				
				
				/*Remove old panels*/
				remove(first);
				remove(second);
				remove(jerseyNum);
				remove(rosterPanel);
				remove(loadStart);
				
				/*Add new Panels*/
				add(box);
				add(shots);
				add(threes);
				add(frees);
				add(blkAsst);
				add(stlFoul);
				add(reboundEnd);
				
				updateStats();
			}
		}
		else if(source == made2)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.made2();
			updateStats();
		}
		else if(source == missed2)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.missed2();
			updateStats();
		}
		else if(source == made3)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.made3();
			updateStats();
		}
		else if(source == missed3)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.missed3();
			updateStats();
		}
		else if(source == madeFree)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.freeMade();
			updateStats();
		}
		else if(source == missedFree)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.missedFree();
			updateStats();
		}
		else if(source == block)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.block();
			updateStats();
		}
		else if(source == assist)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.assist();
			updateStats();
		}
		else if(source == steal)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.steal();
			updateStats();
		}
		else if(source == foul) 
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.commitFoul();
			updateStats();
		}
		else if(source == rebound)
		{
			int index = playerBox.getSelectedIndex();
			BasketballPlayer chosen = players.get(index);
			chosen.rebound();
			updateStats();
		}
		else if(source == summary)
		{
			this.setVisible(false);
			SummaryUI sumUI = new SummaryUI(players);
		}
	}
	
	/**
	 * When comboBox Item is selected, changes stats to currently selected
	 */
	@Override
	public void itemStateChanged(ItemEvent i) 
	{ 
		updateStats();		
	}/*End itemStateChanged*/
	
	/**
	 * Loads player into ArrayList
	 */
	public void loadPlayer()
	{
		String fn = text1.getText(); 
		String ln = text2.getText();
		if(fn.isEmpty() || ln.isEmpty())
		{
			JLabel label = new JLabel("Must enter a first and last name!");  
	        label.setFont(new Font("serif", Font.PLAIN, 20));
			JOptionPane.showMessageDialog(null, label, "Error",JOptionPane.WARNING_MESSAGE, null);
			return;
		}
		int jn;
		try
		{
		  jn = Integer.parseInt(number.getText());
		} catch (NumberFormatException e)
		{
			JLabel label = new JLabel("Please enter a number!");  
	        label.setFont(new Font("serif", Font.PLAIN, 20));
			JOptionPane.showMessageDialog(null, label, "Error",JOptionPane.WARNING_MESSAGE, null);
			return;
		}
		for (BasketballPlayer p : players)
		{
			if(jn == p.getNumber())
			{
				JLabel label = new JLabel("Cannot have two players with same number!");  
		        label.setFont(new Font("serif", Font.PLAIN, 20));
				JOptionPane.showMessageDialog(null, label, "Error",JOptionPane.WARNING_MESSAGE, null);
				
				number.setText(null);
				
				return;
			}/*End if to handle players with same number*/
		}/*End For Loop*/
		
		/*Test for roster too big*/
		if(players.size() < 12)
		{
		BasketballPlayer bp = new BasketballPlayer(fn, ln, jn);
		players.add(bp);
		roster.setText((players.size() + " of 12 Players Loaded"));
		text1.setText(null);
		text2.setText(null);
		number.setText(null);
		bp.setAlert(this);
		}
		else
		{
			JLabel label = new JLabel("Can only have 12 players on roster!");  
	        label.setFont(new Font("serif", Font.PLAIN, 20));
			JOptionPane.showMessageDialog(null, label, "Error",JOptionPane.WARNING_MESSAGE, null);
		}/*End decision loop for roster too big*/
	}/*End loadPlayer*/
	
	/**
	 * Updates stats on the labels
	 */
	public void updateStats()
	{
		int index = playerBox.getSelectedIndex();
		BasketballPlayer chosen = players.get(index);
		points.setText("Points: " + chosen.getPoints());
		fieldgoals.setText("FieldGoals: " + chosen.getMadeShots() + " for " + chosen.getShotsTaken()); 
		fieldgoalPerc.setText("Fieldgoal Perc =  "+ chosen.getFieldgoalPerc() + "%");
		threePointers.setText("Three Pointers: " + chosen.getThreesMade() + " for " + chosen.getThreesTaken());
		threePointPerc.setText("3-Point Perc =  "+ chosen.getThreePointPerc() + "%");
		freeThrows.setText("Free Throws: " + chosen.getMadeFrees() + " for " + chosen.getFreesTaken());
		freeThrowPerc.setText("Free Throw Perc =  "+ chosen.getFreePerc() + "%");
		blockStats.setText("Blocks: " + chosen.getBlocks());
		assistStats.setText("Assists: " + chosen.getAssists());
		stealStats.setText("Steals: " + chosen.getSteals());
		foulStats.setText("Fouls: " + chosen.getFouls());
		reboundStats.setText("Rebounds: " + chosen.getRebounds());
		
		if(chosen.getFouls() == 5)
		{
			made2.setEnabled(false);
			missed2.setEnabled(false);
			made3.setEnabled(false);
			missed3.setEnabled(false);
			madeFree.setEnabled(false);
			missedFree.setEnabled(false);
			block.setEnabled(false);
			assist.setEnabled(false);
			steal.setEnabled(false);
			foul.setEnabled(false);
			rebound.setEnabled(false);
		}else
		{
			made2.setEnabled(true);
			missed2.setEnabled(true);
			made3.setEnabled(true);
			missed3.setEnabled(true);
			madeFree.setEnabled(true);
			missedFree.setEnabled(true);
			block.setEnabled(true);
			assist.setEnabled(true);
			steal.setEnabled(true);
			foul.setEnabled(true);
			rebound.setEnabled(true);
		}
		
	}/*End updateStats*/
	

}
