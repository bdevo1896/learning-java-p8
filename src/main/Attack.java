package main;

public class Attack {
	
	private String name;
	private int maxSp;

	public Attack(String name, int maxSp) {
		this.name = name;
		this.maxSp = maxSp;
	}

	public String getName() {
		return name;
	}

	public int getMaxSp() {
		return maxSp;
	}
	
	public void use(){
		maxSp--;
	}
}
