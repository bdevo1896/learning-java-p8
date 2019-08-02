package main;
import java.awt.Graphics;
import java.awt.Image;

public class MovableObject {

	private int x, y;
	private Image img;
	private boolean moving;
	private boolean visible;

	public MovableObject(int x, int y, Image img, boolean moving,
			boolean visible) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.moving = moving;
	}

	public void draw(Graphics page) {
		page.drawImage(img, x, y, null);
	}

	public void moveBy(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return img;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}