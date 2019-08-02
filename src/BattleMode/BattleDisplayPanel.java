package BattleMode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.Controller;
import main.Pokemon;

public class BattleDisplayPanel extends JPanel{

	private ArrayList<Pokemon> pokemon;
	private int pokeNum;
	private boolean canFight;

	public BattleDisplayPanel(Controller c,ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
		pokeNum = 0;
		canFight = true;
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.black);
	}

	public ArrayList<Pokemon> getPokemon(){
		return pokemon;
	}

	public void paintComponent(Graphics page){
		super.paintComponent(page);
		pokemon.get(pokeNum).draw(page, 0, 0);
	}

	public void changePokemon(){
		if(pokeNum++<pokemon.size()){
			pokeNum++;
		}else{
			canFight = false;
		}
	}
	
	public boolean canFight(){
		return canFight;
	}

}
