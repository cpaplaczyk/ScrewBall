// Created by Clayton Paplaczyk

import javax.swing.*;

public class Screwball extends JApplet{
	
	private final int WIDTH = 350;
	private final int HEIGHT = 200;

	public void init()
	{
		ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
		getContentPane().add(panel);
		setSize(WIDTH,HEIGHT);
	}
}
