


import java.awt.Color;

//Ce sont les cases des bornes lumineuses

public class Light extends Tile{

	public Light(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.YELLOW;
	}

}
