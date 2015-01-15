package map.tiles;


import java.awt.Color;

//Ce sont les cases autour des bornes lumineuses

public class Glow extends Tile{

	public Glow(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.GRAY;
	}

}
