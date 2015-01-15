


import java.awt.Color;

//Ce sont les cases des couloirs (où les personnage peuvent se deplacer)

public class Hall extends Tile{

	public Hall(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.GRAY;
	}

}
