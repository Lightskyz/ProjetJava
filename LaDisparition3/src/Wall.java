


import java.awt.Color;

//Ce sont les murs qui dŽlimittent les mouvements des personnages

public class Wall extends Tile {

	public Wall(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.BLACK;
	}


}
