package main;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Pokemon {

	private String name, moveUsed;
	private Types type;
	private int str, def, hp;
	private Random rand;
	private ArrayList<Attack> moves;
	private Image img;

	public Pokemon(String name, Types type, Image img) {
		this.name = name;
		this.type = type;
		this.img = img;
		rand = new Random();
		moves = new ArrayList<Attack>();
		moves.add(new Attack("Tackle",30));
		hp = 50 + rand.nextInt(50);
		def = rand.nextInt(9) + 1;
		str = 10 + rand.nextInt(10);
		moveUsed = "";
	}

	public Image getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public Types getType() {
		return type;
	}

	public int getStrength() {
		return str;
	}

	public int getDefense() {
		return def;
	}

	public int getHealth() {
		return hp;
	}

	public String getMoveUsed() {
		return moveUsed;
	}

	public ArrayList<Attack> getMoves() {
		return moves;
	}

	public void setMove(String moveUsed) {
		this.moveUsed = moveUsed;
	}

	public void hurt(int hitpoints) {
		hp -= hitpoints;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Prints out the stats of the Pokemon.
	 */
	public String toString() {
		return "Name: " + name + " HP: " + hp + " DEF: " + def + " STR: " + str
				+ " Type: " + type;
	}

	/**
	 * Lists out every move the Pokemon currently has.
	 * 
	 * @return
	 */
	public String listMoves() {
		String list = "";

		for (int i = 0; i < moves.size(); i++) {
			list += (i + 1) + ". " + moves.get(i).getName() + " ";
		}

		return list;
	}

	/**
	 * This method will add a move to the current list of moves
	 * 
	 * @param move
	 */
	public void addMove(Attack move) {
		moves.add(move);
	}

	/**
	 * This will draw out the Pokemon.
	 * 
	 * @param page
	 * @param x
	 * @param y
	 */
	public void draw(Graphics page, int x, int y) {
		page.drawImage(img, x, y, null);
	}

}
