package map;
import java.util.ArrayList;
import java.util.List;

import map.tiles.Tile;

//Ma map ou je recupere toutes les cases une par une

public class Map {
	protected List<Tile> tiles;
	
	public Map(ArrayList<Tile> tiles){
		tiles = new ArrayList<Tile>();
	}
	
}
