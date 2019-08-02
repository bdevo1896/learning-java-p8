package main;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	Controller myController;
	JFrame myFrame;
	JPanel mainPanel;
	DisplayPanel displayPanel;
	ButtonPanel buttonPanel;

	public View(Controller c) {
		myController = c;
		myFrame = new JFrame("This is our Frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1000, 800));
		buttonPanel = new ButtonPanel(myController);
		displayPanel = new DisplayPanel();
		mainPanel.add(displayPanel);
		mainPanel.add(buttonPanel);
		myFrame.getContentPane().add(mainPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}

	public DisplayPanel getDisplayPanel() {
		return displayPanel;
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
}
