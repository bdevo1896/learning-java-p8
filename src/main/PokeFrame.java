package main;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PokeFrame extends JFrame{
	private ArrayList<Pokemon> pokemon;
	private PokeDisplay pokeD;
	private JPanel mainPanel;
	private Controller c;
	public PokeFrame(String title,Controller c){
		super(title);
		this.c = c;
		start();
	}

	public void start() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setPreferredSize(new Dimension(400,400));
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400,400));
//		ArrayList<Pokemon> test = new ArrayList<Pokemon>();
//		for(int i = 0; i < 6; i++){
//		test.add(new Pokemon("Lol",Types.Rock,DisplayPanel.findImage("images/stoneP.png")));
//		}
		pokeD = new PokeDisplay(c.getPlayersPokemonList());
		mainPanel.add(pokeD);
		getContentPane().add(mainPanel);
		pack();
		setVisible(true);
	}
	
	public void refresh(){
		mainPanel.remove(pokeD);
		mainPanel.add(new PokeDisplay(c.getPlayersPokemonList()));
		pack();
	}

}
