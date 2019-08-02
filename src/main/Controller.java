package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Controller implements ActionListener {

	private View myView;
	private ButtonPanel bPanel;
	private DisplayPanel dPanel;
	private Model player;
	private ArrayList<Model> npcs;
	private Timer time;
	private ArrayList<Pokemon> playerPokemon;
	private boolean canBuy;
	private int playerMoney;
	private int potions;
	private boolean isStore;
	private int pokeballs;
	private PokeFrame pokeD;

	public Controller() {
		myView = new View(this);
		bPanel = myView.getButtonPanel();
		dPanel = myView.getDisplayPanel();
		player = new Model(this, dPanel.getPlayer());
		dPanel.printCheckedSquare();
		npcs = createNPCModelList();
		// This will create an object that controls movement of the NPCs.
		NPCMover moveNPCs = new NPCMover();
		time = new Timer(750, moveNPCs);
		time.start();
		playerPokemon = createPokemonList(2);
		canBuy = false;
		playerMoney = 0;
		potions = 0;
		pokeballs = 0;
		isStore = false;
		pokeD = new PokeFrame("My Pokemon",this);
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (!player.getM().isMoving()) {
			if (player.getX() + 50 < 750) {
				if (arg0.getSource() == bPanel.getRightButton()) {
					move(player, 2, 0);
				}
			}

			if (player.getX() > 0) {
				if (arg0.getSource() == bPanel.getLeftButton()) {
					move(player, -2, 0);
				}
			}

			if (player.getY() > 0) {
				if (arg0.getSource() == bPanel.getUpButton()) {
					move(player, 0, -2);
				}
			}

			if (player.getY() + 50 < 750) {
				if (arg0.getSource() == bPanel.getDownButton()) {
					move(player, 0, 2);
				}
			}
			
			if(arg0.getSource() == bPanel.getSeePokemon()){
				pokeD.setVisible(true);
			}
		}
		
		if(isStore){
			bPanel.addStoreButtons(this);
			if(arg0.getSource()==bPanel.getBuyPokeball()&&playerMoney>20){
				pokeballs++;
				bPanel.setPokeballsLabel(this);
			}
			
			if(arg0.getSource()==bPanel.getBuyPotion()&&playerMoney>50){
				potions++;
				bPanel.setPotionLabel(this);
			}
			
			bPanel.setMoneyLabel(this);
		}
	}

	/**
	 * Moves an object by one square.
	 * 
	 * @param m
	 * @param speedX
	 * @param speedY
	 */
	public void move(Model m, int speedX, int speedY) {
		Runnable run = new Runnable() {
			public void run() {
				m.getM().setMoving(true);
				int i = 0;
				while (i < 25) {
					m.move(speedX, speedY);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					m.setMPosition();
					dPanel.update();
					if (m == player) {
						TerrainType block = dPanel.printCheckedSquare();
						if(block == TerrainType.Store)
							isStore = true;
						else if(isStore){
							bPanel.removeButtons();
							isStore = false;
						}
						
					}
					i++;
				}
				m.getM().setMoving(false);
			}
		};

		Thread thr = new Thread(run);
		thr.start();
	}

	/**
	 * Creates models for the npcs created.
	 * 
	 * @return
	 */
	public ArrayList<Model> createNPCModelList() {
		ArrayList<Model> rtnArray = new ArrayList<Model>();

		ArrayList<MovableObject> npcData = dPanel.getMovableList();

		for (int i = 0; i < npcData.size(); i++) {
			Model m = new Model(this, npcData.get(i));
			m.setMPosition();
			rtnArray.add(m);
		}

		return rtnArray;
	}

	/**
	 * Will create list of a specified number of Pokemon.
	 * @return 
	 */
	public ArrayList<Pokemon> createPokemonList(int numOfPokemon){
		ArrayList<Pokemon> rtnList = new ArrayList<Pokemon>();
		for(int i = 0; i < numOfPokemon; i++){
			int randType = (int)(Math.random()*4);
			Pokemon p = new Pokemon("Lol",Types.Rock,DisplayPanel.findImage("images/stoneP.png"));
			switch(randType){
			case 0:
				p = new Pokemon(("ID 0"+((int)Math.random()*35)),Types.Fire,DisplayPanel.findImage("images/fireP.png"));
				break;
			case 1:
				p = new Pokemon(("ID 0"+((int)Math.random()*35)),Types.Water,DisplayPanel.findImage("images/waterP.png"));
				break;
			case 2:
				p = new Pokemon(("ID 0"+((int)Math.random()*35)),Types.Grass,DisplayPanel.findImage("images/grassP.png"));
				break;
			case 3:
				p = new Pokemon(("ID 0"+((int)Math.random()*35)),Types.Rock,DisplayPanel.findImage("images/stoneP.png"));
				break;
			}
			rtnList.add(p);
		}
		return rtnList;
	}

	/**
	 * This class allows for movement of the NPCs.
	 */
	private class NPCMover implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (int i = 0; i < npcs.size(); i++) {
				if (!npcs.get(i).getM().isMoving()) {
					int direction = (int) (Math.random() * 5);
					switch (direction) {
					case 0:
						if (npcs.get(i).getX() > 0)
							move(npcs.get(i), -2, 0);
						break;
					case 1:
						if (npcs.get(i).getX() + 50 < 750)
							move(npcs.get(i), 2, 0);
						break;
					case 2:
						if (npcs.get(i).getY() > 0)
							move(npcs.get(i), 0, -2);
						break;
					case 3:
						if (npcs.get(i).getY() + 50 < 750)
							move(npcs.get(i), 0, 2);
						break;
					default:
						move(npcs.get(i), 0, 0);
						npcs.get(i);
					}
				}
			}
		}

	}
	
	public ArrayList<Pokemon> getPlayersPokemonList(){
		return playerPokemon;
	}
	
	public int getPlayerMoney(){
		return playerMoney;
	}
	
	public int getPotions(){
		return potions;
	}
	
	public int getPokeBalls(){
		return pokeballs;
	}


}
