//Created by Clayton Paplaczyk

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel{
	
	private int width, height;
	private JPanel leftPanel, rightPanel;
	private JButton start, reset;
	private JLabel pwLabel, scoreLabel;
	String winner = "Game has not started yet";
	String score = "0:0";
	boolean stopGame = true;
	int scoreP1 =0;
	int scoreP2 =0;
	
	public ControlPanel(int width, int height){
		
		this.width = width;
		this.height = height;
		
		//creation of rightPanel
		rightPanel = new JPanel();
		//setting layout for rightPanel
		rightPanel.setLayout(new GridLayout(2,1));
		
		//creating JButtons
		start = new JButton("Put Ball in Play");
		reset = new JButton("Reset");
		
		//creating button listeners
		start.addActionListener(new ButtonListener());
		reset.addActionListener(new ButtonListener());
		
		//creating JLabels
		pwLabel = new JLabel(winner, JLabel.CENTER);
		scoreLabel = new JLabel("Game Score: "+ scoreP1 + ":" + scoreP2, JLabel.CENTER);
		
		//creating left panel
		leftPanel = new JPanel();
		//sets layout for leftPanel
		leftPanel.setLayout(new GridLayout(2,1));
		//add JButtons to leftPanel
		leftPanel.add(start);
		leftPanel.add(reset);
		
		//creating rightPanel
		rightPanel = new JPanel();
		//sets layout for rightPanel
		rightPanel.setLayout(new GridLayout(2,2));
		//add JLabels to rightPanel
		rightPanel.add(pwLabel);
		rightPanel.add(scoreLabel);
		
		//organize the left panel and right panel using SplitPane
		setLayout(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension(width, 120));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		add(sp);

		setPreferredSize(new Dimension(width,height));
	}
	
	//allows actions to be created while buttons are pressed
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			//Starts game when start is pressed
			if(event.getSource() == start){
				StartGame();
				scoreLabel.setText("Game Score: "+ scoreP1 + ":" + scoreP2);
				pwLabel.setText(winner);
			}
			
			//resets game when reset is pressed
			if(event.getSource() == reset){
				ResetGame();
				scoreLabel.setText("Game Score: "+ scoreP1 + ":" + scoreP2);
				pwLabel.setText(winner);
			}
			
		}
	}

	//The algorithm of the game
	public void StartGame(){

		while(stopGame){
			//creates random numbers to determine who gets ball
			double rand1 = Math.random();
			double rand2 = Math.random();

			//decides who gets the ball, who ever gets larger number wins that round
			if(rand1 > rand2)
				scoreP1 += 1;
			else
				scoreP2 += 1;
			
			//stops game if p1 or p2 wins by 2
			if(scoreP1 -2 == scoreP2 || scoreP2 -2 == scoreP1){
				stopGame = false; 
				if(scoreP1 -2 == scoreP2)
					winner = "Winner is Player 1";
				else
					winner = "Winner is Player 2";
			}
		}
		//resets so that the game can function if start game is selected
		stopGame = true;
	}

	//resets the score of the game
	public void ResetGame(){
		scoreP1 = 0;
		scoreP2 = 0;
		winner = "New game has started";
	}
}

