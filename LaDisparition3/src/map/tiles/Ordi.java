package map.tiles;


import java.awt.Color;

//C'est la case où se trouve l'ordinateur à pirater

public class Ordi extends Tile {

	public Ordi(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.BLUE;
	}

}
