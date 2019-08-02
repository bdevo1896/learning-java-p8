package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PokeDisplay extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pokemon> pokemon;
	private Image fIcon,gIcon,wIcon,sIcon;
	
	public PokeDisplay(ArrayList<Pokemon> pokemon){
		this.pokemon = pokemon;
		fIcon = DisplayPanel.findImage("images/firePIcon.png");
		gIcon = DisplayPanel.findImage("images/grassPIcon.png");
		wIcon = DisplayPanel.findImage("images/waterPIcon.png");
		sIcon = DisplayPanel.findImage("images/stonePIcon.png");
		setPreferredSize(new Dimension(400,400));
		setBackground(new Color(247, 48, 26));
		System.out.print(pokemon.size());

	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		for(int i = 1; i < pokemon.size()+1; i++){
			switch(pokemon.get(i-1).getType()){
			case Fire:
				page.drawImage(fIcon,32,i*32,null);
				page.setColor(Color.white);
				page.drawString(pokemon.get(i-1).toString(),70,32+(i*32));
				break;
			case Water:
				page.drawImage(wIcon,32,i*32,null);
				page.setColor(Color.white);
				page.drawString(pokemon.get(i-1).toString(),70,32+(i*32));
				break;
			case Grass:
				page.drawImage(gIcon,32,i*32,null);
				page.setColor(Color.white);
				page.drawString(pokemon.get(i-1).toString(),70,32+(i*32));
				break;
			case Rock:
				page.drawImage(sIcon,32,i*32,null);
				page.setColor(Color.white);
				page.drawString(pokemon.get(i-1).toString(),70,32+(i*32));
				break;
			default:
				break;
			}
		}
	}
}