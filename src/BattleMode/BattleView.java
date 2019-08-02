package BattleMode;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Controller;

public class BattleView {
	Controller myController;
	JFrame myFrame;
	JPanel mainPanel;
	BattleDisplayPanel displayPanel;
	BattleButtonPanel buttonPanel;

	public BattleView(Controller c) {
		myController = c;
		myFrame = new JFrame("This is our Frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1000, 800));
		buttonPanel = new BattleButtonPanel(myController);
		displayPanel = new BattleDisplayPanel(myController, myController.getPlayersPokemonList());
		mainPanel.add(displayPanel);
		mainPanel.add(buttonPanel);
		myFrame.getContentPane().add(mainPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}

	public BattleDisplayPanel getBattleDisplayPanel() {
		return displayPanel;
	}

	public BattleButtonPanel getBattleButtonPanel() {
		return buttonPanel;
	}
}
