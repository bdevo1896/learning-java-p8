package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private JButton leftButton;
	private JButton upButton;
	private JButton rightButton;
	private JButton downButton;
	private JButton seePokemon;
	private JLabel playerMoney;
	private JLabel potions;
	private JLabel pokeballs;
	private JButton buyPotion;
	private JButton buyPokeball;

	public ButtonPanel(Controller c) {
		super();
		leftButton = null;
		upButton = null;
		rightButton = null;
		downButton = null;
		seePokemon = null;
		leftButton = new JButton("Move Left");
		leftButton.addActionListener(c);
		add(leftButton);

		upButton = new JButton("Move Up");
		upButton.addActionListener(c);
		add(upButton);

		rightButton = new JButton("Move Right");
		rightButton.addActionListener(c);
		add(rightButton);

		downButton = new JButton("Move Down");
		downButton.addActionListener(c);
		add(downButton);
		
		seePokemon = new JButton("See Pokemon");
		seePokemon.addActionListener(c);
		add(seePokemon);
		
		playerMoney = new JLabel("Money: "+c.getPlayerMoney());
		playerMoney.setForeground(Color.white);
		add(playerMoney);
		
		potions = new JLabel("Potions: "+c.getPotions());
		potions.setForeground(Color.white);
		add(potions);
		
		pokeballs = new JLabel("Pokeballs: "+c.getPokeBalls());
		pokeballs.setForeground(Color.white);
		add(pokeballs);
		
		buyPotion = new JButton("Buy a Potion?");
		buyPotion.setVisible(false);
		buyPotion.addActionListener(c);
		add(buyPotion);
		
		buyPokeball = new JButton("Buy a Pokeball?");
		buyPokeball.setVisible(false);
		buyPokeball.addActionListener(c);
		add(buyPokeball);

		setPreferredSize(new Dimension(150, 750));
		setBackground(new Color(83, 79, 162));
	}
	
	public void addStoreButtons(Controller c){
		buyPotion.setVisible(true);
		buyPokeball.setVisible(true);
		update(null);
	}
	
	public void removeButtons(){
		buyPotion.setVisible(false);
		buyPokeball.setVisible(false);
		update(null);
	}

	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getUpButton() {
		return upButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public JButton getDownButton() {
		return downButton;
	}
	
	public JButton getSeePokemon() {
		return seePokemon;
	}

	public JButton getBuyPotion() {
		return buyPotion;
	}

	public JButton getBuyPokeball() {
		return buyPokeball;
	}

	public void setMoneyLabel(Controller c){
		playerMoney.setName("Money: "+ c.getPlayerMoney());
	}
	
	public void setPotionLabel(Controller c){
		potions.setName("Potions: "+ c.getPotions());
	}
	
	public void setPokeballsLabel(Controller c){
		pokeballs.setName("Pokeballs: "+ c.getPokeBalls());
	}
}
