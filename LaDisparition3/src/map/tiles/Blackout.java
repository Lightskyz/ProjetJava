package map.tiles;


import java.awt.Color;

//Ce sont mes cases lorsqu'on �teind le couloir - �a reste des couloirs mais �a change de couleur

public class Blackout extends Tile{

	public Blackout(int x, int y) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.BLACK;
	}

}
