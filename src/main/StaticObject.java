package main;
import java.awt.Graphics;
import java.awt.Image;

public class StaticObject {

	private int x, y;
	private Image img;
	private TerrainType type;

	public StaticObject(int x, int y, Image img, TerrainType type) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.type = type;
	}

	public TerrainType getType() {
		return type;
	}

	public void draw(Graphics page) {
		page.drawImage(img, x, y, null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImg() {
		return img;
	}

}
