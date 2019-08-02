package main;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StructureMaker {

	private Random rand;
	private DisplayPanel d;

	public StructureMaker(DisplayPanel d) {
		rand = new Random();
		this.d = d;
	}

	public StaticObject[][] makePaths(StaticObject[][] data) {

		int sPathFileNum = 0;
		boolean sPathFound = false;

		do {
			sPathFileNum = 1 + rand.nextInt(9);
			if (sPathFileNum % 2 > 0)
				sPathFound = true;
		} while (!sPathFound);

		String[][] sPath = StructReader.structureFileRead("paths/path_"
				+ sPathFileNum);

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				String symbol = sPath[i][j];
				switch (symbol) {
				case "d":
					if (data[i][j] == null) {
						data[i][j] = new StaticObject(i * 50, j * 50,
								d.findImage("images/dirt.png"),
								TerrainType.Dirt);
					}
					break;
				case "s":
					if (data[i][j] == null) {
						data[i][j] = new StaticObject(i * 50, j * 50,
								d.findImage("images/store.png"),
								TerrainType.Store);
					}
					break;
				default:
					int gOrT = (int) (Math.random() * 2);

					if (gOrT == 0) {
						data[i][j] = new StaticObject(i * 50, j * 50,
								d.findImage("images/grass.png"),
								TerrainType.Grass);
					} else {
						data[i][j] = new StaticObject(i * 50, j * 50,
								d.findImage("images/tree.png"),
								TerrainType.Tree);
					}
				}
			}
		}

		return data;
	}

	/**
	 * This class is only used to read in the structure files.
	 * 
	 * @author User
	 *
	 */
	private static class StructReader {

		public static String[][] structureFileRead(String fileName) {
			String[][] rtnArray = new String[15][15];
			try {
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				String str;
				str = in.readLine();
				int row = 0;
				while (str != null) {
					String[] rawData = str.split(",");
					rtnArray[row] = rawData;
					str = in.readLine();
					row++;
				}
				in.close();
			} catch (IOException e) {
				System.out.println("File Read Error");
			}

			return rtnArray;
		}
	}

}
