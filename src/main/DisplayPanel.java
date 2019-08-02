package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaticObject[][] staticList;
	private ArrayList<MovableObject> movableList;
	private MovableObject player;

	public DisplayPanel() {
		staticList = new StaticObject[15][15];
		staticList = createGrid();
		movableList = createNPCList();
		setPreferredSize(new Dimension(750, 750));
		setBackground(Color.BLACK);
		player = new MovableObject(350, 350, findImage("images/player.png"),
				false, true);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		for (int i = 0; i < staticList.length; i++) {
			for (int j = 0; j < staticList[i].length; j++) {
				staticList[i][j].draw(page);
			}
		}

		for (int i = 0; i < movableList.size(); i++) {
			movableList.get(i).draw(page);
		}

		player.draw(page);
	}

	/**
	 * This method will create the grid.
	 * 
	 * @return
	 */
	public StaticObject[][] createGrid() {
		// StructureMaker struct = new StructureMaker(this);
		StaticObject[][] rtnList = new StaticObject[15][15];
		Random rand = new Random();

		boolean isStoreMade = false;
		boolean isHosMade = false;
		for (int y = 0; y < 15; y++) {
			StaticObject[] tmpList = new StaticObject[15];
			for (int x = 0; x < 15; x++) {
				boolean objectMade = false;
				do {
					int chance = rand.nextInt(5);
					switch (chance) {
					case 0:
						tmpList[x] = new StaticObject(x * 50, y * 50,
								findImage("images/grass.png"),
								TerrainType.Grass);
						objectMade = true;
						break;
					case 1:
						tmpList[x] = (new StaticObject(x * 50, y * 50,
								findImage("images/tree.png"), TerrainType.Tree));
						objectMade = true;
						break;
					case 2:
						tmpList[x] = (new StaticObject(x * 50, y * 50,
								findImage("images/dirt.png"), TerrainType.Dirt));
						objectMade = true;
						break;
					case 3:
						if (!isHosMade) {
							tmpList[x] = (new StaticObject(x * 50, y * 50,
									findImage("images/hospital.png"),
									TerrainType.Hospital));
							isHosMade = true;
							objectMade = true;
						}
						break;
					case 4:
						if (!isStoreMade) {
							tmpList[x] = (new StaticObject(x * 50, y * 50,
									findImage("images/store.png"),
									TerrainType.Store));
							isStoreMade = true;
							objectMade = true;
						}
						break;
					}
				} while (!objectMade);
			}
			rtnList[y] = (tmpList);
		}

		rtnList[7][7] = new StaticObject(7 * 50, 7 * 50,
				findImage("images/dirt.png"), TerrainType.Dirt);
		// rtnList = struct.makePaths(rtnList);

		return rtnList;

	}

	/**
	 * This method creates a list of randomly placed npc's.
	 * 
	 * @return
	 */
	public ArrayList<MovableObject> createNPCList() {
		ArrayList<MovableObject> rtnArray = new ArrayList<MovableObject>();

		Random rand = new Random();

		for (int i = 0; i < (1 + rand.nextInt(6)); i++) {

			int x = rand.nextInt(15);
			int y = rand.nextInt(15);

			MovableObject npc = new MovableObject(x * 50, y * 50,
					findImage("images/npc.png"), false, true);
			rtnArray.add(npc);
		}

		return rtnArray;
	}

	/**
	 * This will return an Image by searching for an image file under the
	 * 'filename'
	 * 
	 * @param filename
	 * @return
	 */
	public static Image findImage(String filename) {
		Image img = null;

		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("lol fail");
			e.printStackTrace();
		}

		return img;
	}

	/**
	 * Returns the StaticObject list (the grid).
	 */
	public StaticObject[][] getStaticList() {
		return staticList;
	}

	public ArrayList<MovableObject> getMovableList() {
		return movableList;
	}

	public MovableObject getPlayer() {
		return player;
	}

	public void update() {
		repaint();
	}

	/**
	 * Checks what square the player is over.
	 */
	public TerrainType printCheckedSquare() {
		TerrainType rtnType = null;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				StaticObject o = staticList[i][j];
				if (player.getX() >= o.getX()
						&& player.getX() + 50 <= o.getX() + 50) {
					if (player.getY() >= o.getY()
							&& player.getY() + 50 <= o.getY() + 50) {

						TerrainType type = o.getType();
						switch (type) {
						case Tree:
							System.out.println("You are standing on a Tree");
							rtnType = TerrainType.Tree;
							break;
						case Dirt:
							System.out.println("You are standing on a Dirt");
							rtnType = TerrainType.Dirt;
							break;
						case Grass:
							System.out.println("You are standing on a Grass");
							rtnType = TerrainType.Grass;
							break;
						case Hospital:
							System.out.println("You are standing on a Hospital");
							rtnType = TerrainType.Hospital;
							break;
						case Store:
							System.out.println("You are standing on a Store");
							rtnType = TerrainType.Store;
							break;
						}
					}
				}
			}
		}
		return rtnType;
	}
}
