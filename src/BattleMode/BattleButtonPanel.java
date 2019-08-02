package BattleMode;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import main.Attack;
import main.Controller;
import main.Pokemon;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BattleButtonPanel extends JPanel{
	
	private ArrayList<JButton> buttons;
	private ArrayList<Pokemon> pokemon;
	private int pokeNum;
	
	public BattleButtonPanel(Controller c) {
		pokeNum = 0;
		this.pokemon = c.getPlayersPokemonList();
		setButtons(c);
		setPreferredSize(new Dimension(120, 400));
		setBackground(new Color(232, 78, 19));
	}
	
	public void changePokemon(){
		if(pokeNum+1<pokemon.size()){
			pokeNum++;
		}
	}
	
	public void setButtons(Controller c){
		ArrayList<Attack> moves = pokemon.get(pokeNum).getMoves();
		for(int i = 0; i <moves.size(); i++){
			JButton j = new JButton(moves.get(i).getName());
			j.addActionListener(c);
			this.add(j);
			buttons.add(j);
		}
		
		JButton potion = new JButton("Potion");
		potion.addActionListener(c);
		this.add(potion);
		buttons.add(potion);
	}
	
	public JButton getButton(int index){
		return buttons.get(index);
	}
}
