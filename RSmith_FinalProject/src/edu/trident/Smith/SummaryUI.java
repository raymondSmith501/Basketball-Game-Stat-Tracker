/**
 * New Window to summarize game stats and export to CSV
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SummaryUI extends JFrame implements ActionListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<BasketballPlayer> team;
	private JComboBox<BasketballPlayer> teamBox = new JComboBox<BasketballPlayer>();
	private JTextArea headers = new JTextArea(30,11);
	private JTextArea stats = new JTextArea(6,11);
	private JButton export = new JButton("Export");
	private JPanel box = new JPanel();
	private JPanel output = new JPanel();
	private JPanel button = new JPanel();
	private final String GAME_SUMMARY_FILE = "C:\\tmp\\gameSummary.csv";
	private FileWriter writer;
	
	/**
	 * Constructor
	 * @param pList
	 */
	public SummaryUI(ArrayList<BasketballPlayer> pList)
	{
		super("Game Summary");
		team = pList;
		/*Build window and components*/
		setSize(300,350);
		output.setLayout(new GridLayout(1,2));
		box.add(teamBox);
		output.add(headers);
		output.add(stats);
		button.add(export);	
		add(box, BorderLayout.NORTH);
		add(output, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		export.addActionListener(this);
		teamBox.addItemListener(this);
		
		
		/*Load Combo Box*/
		for (int p = 0; p < team.size(); p++)
		{
			teamBox.addItem(team.get(p));
		}
		
		/*Set Text in TextAreas*/	
		
		headers.setText("Points:"
				+ "\nFieldgoals Made:"
				+ "\nFieldgoals Taken:"
				+ "\nFieldGoal Percentage: "
				+ "\n3 Point Shots Made:"
				+ "\n3 Point Shots Taken:"
				+ "\n3 Point Shot Percentage"
				+ "\nFree Throws Made:"
				+ "\nFree Throws Taken:"
				+ "\nFree Throw Percentage:"
				+ "\nBlocks:"
				+ "\nAssists:"
				+ "\nSteals:"
				+ "\nFouls:"
				+ "\nRebounds:");
		
		
		int index = teamBox.getSelectedIndex();
		BasketballPlayer chosen = team.get(index);
		
		stats.setText(chosen.getPoints()
				+ "\n" + chosen.getMadeShots()
				+ "\n" + chosen.getShotsTaken()
				+ "\n" + chosen.getFieldgoalPerc() + "%"
				+ "\n" + chosen.getThreesMade()
				+ "\n" + chosen.getThreesTaken()
				+ "\n" + chosen.getThreePointPerc() + "%"
				+ "\n" + chosen.getMadeFrees()
				+ "\n" + chosen.getFreesTaken()
				+ "\n" + chosen.getFreePerc() + "%"
				+ "\n" + chosen.getBlocks()
				+ "\n" + chosen.getAssists()
				+ "\n" + chosen.getSteals()
				+ "\n" + chosen.getFouls()
				+ "\n" + chosen.getRebounds());
		
		/*Set Window Characteristics*/
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}/*End SumaryUI*/



	@Override
	public void actionPerformed(ActionEvent event) 
	{
		try 
		{
			writer = new FileWriter(GAME_SUMMARY_FILE, true);		
		writer.write("Number,First Name, Last Name,Points,Fieldgoals Made,Fieldgoals Taken,FieldGoal Percentage,"
				+ "3 Point Shots Made,3 Point Shots Taken,3 Point Shot Percentage,Free Throws Made,Free Throws Taken,"
				+ "Free Throw Percentage,Blocks,Assists,Steals,Fouls,Rebounds\n");
		for (BasketballPlayer p : team)
		{
			writer.write(p.getNumber() + "," + p.getFirstName() + "," + p.getLastName() + "," + p.getPoints() + "," + p.getMadeShots()
					 + "," + p.getShotsTaken() + "," + p.getFieldgoalPerc() + "," + p.getThreesMade() + "," + p.getThreesTaken()
					 + "," + p.getThreePointPerc() + "," + p.getMadeFrees() + "," + p.getFreesTaken() + "," + p.getFreePerc()
					 + "," + p.getBlocks() + "," + p.getAssists() + "," + p.getSteals() + "," + p.getFouls() + "," + p.getRebounds() + "\n");
		}
		
		writer.flush();
		writer.close();
		
		} catch (IOException e) 
		{
			System.err.println("Invalid file or file path");
			System.exit(1);
		}
	}


	/**
	 * When comboBox Item is selected, changes stats to currently selected
	 */
	@Override
	public void itemStateChanged(ItemEvent i) 
	{
		int index = teamBox.getSelectedIndex();
		BasketballPlayer chosen = team.get(index);
		
		stats.setText(chosen.getPoints()
				+ "\n" + chosen.getMadeShots()
				+ "\n" + chosen.getShotsTaken()
				+ "\n" + chosen.getFieldgoalPerc()
				+ "\n" + chosen.getThreesMade()
				+ "\n" + chosen.getThreesTaken()
				+ "\n" + chosen.getThreePointPerc()
				+ "\n" + chosen.getMadeFrees()
				+ "\n" + chosen.getFreesTaken()
				+ "\n" + chosen.getFreePerc()
				+ "\n" + chosen.getBlocks()
				+ "\n" + chosen.getAssists()
				+ "\n" + chosen.getSteals()
				+ "\n" + chosen.getFouls()
				+ "\n" + chosen.getRebounds());
		
	}/*End itemStateChanged*/
	
}/*End SummaryUI*/ 
