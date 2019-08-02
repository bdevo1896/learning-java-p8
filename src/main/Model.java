package main;

public class Model {

	private int x, y;
	private MovableObject m;

	public Model(Controller c, MovableObject m) {
		x = m.getX();
		y = m.getY();
		this.m = m;
	}

	public MovableObject getM() {
		return m;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void setMPosition() {
		m.setX(x);
		m.setY(y);
	}

}
