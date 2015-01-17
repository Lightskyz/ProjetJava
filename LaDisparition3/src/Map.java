import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	protected ArrayList<Tile> listeCarres;

	public Map(String filename) {
		listeCarres = new ArrayList<Tile>();
		FromFile("Map.txt");
		drawMap(listeCarres);

	}

	public void FromFile(String fileName) {
		ArrayList<ArrayList<Integer>> tempLayout = new ArrayList<ArrayList<Integer>>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String currentLine;

			int ligne = 0;

			while ((currentLine = br.readLine()) != null) {

				ArrayList<Integer> row = new ArrayList<>();

				String[] values = currentLine.trim().split(";");

				for (int colonne = 0; colonne < values.length; colonne++) {
					if (Integer.parseInt(values[colonne]) == 0) {
						listeCarres.add(new Wall(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 1) {
						listeCarres.add(new Hall(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 2) {
						listeCarres.add(new Light(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 3) {
						listeCarres.add(new Ordi(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 4) {
						listeCarres.add(new Glow(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 5) {
						listeCarres.add(new Blackout(colonne, ligne));
					}
					if (Integer.parseInt(values[colonne]) == 6) {
						listeCarres.add(new Limit(colonne, ligne));
					}
					// System.out.println(values[colonne]);
				}
				tempLayout.add(row);

				ligne++;
				
			}
		} catch (IOException e) {

		}
	}

	public void drawMap(ArrayList<Tile> listTiles) {
		for (Tile t : listTiles) {
			
			t.y = 16 - t.y;
			
			StdDraw.setPenColor(t.color);
			StdDraw.filledSquare(t.x  *Game.scale , t.y * Game.scale, Game.WIDTH/27.5f);

			System.out.println(t.x + "," + t.y);
		}
	}

}