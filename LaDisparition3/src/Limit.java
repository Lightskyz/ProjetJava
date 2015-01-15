


import java.awt.Color;

//Ce sont les cases qui délimittent ma map

public class Limit extends Tile {

	public Limit(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.GREEN;
	}

}
