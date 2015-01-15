
import java.awt.Color;

//Ce sont mes cases lorsqu'on éteind le couloir - ça reste des couloirs mais ça change de couleur

public class Blackout extends Tile{

	public Blackout(int x, int y, Color c) {
		super(x, y);
		super.x = x;
		super.y = y;
		super.color = Color.BLACK;
		
		}
	
	
}
