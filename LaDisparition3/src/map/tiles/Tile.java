package map.tiles;


import java.awt.Color;

//C'est mon objet qui me permet de créer une case

public abstract class Tile {
		protected int x;
		protected int y;
		protected Color color;
		
		public Tile (int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX(){ 
			return x;
		}
		public int getY(){
			return y;
		}
		
		public Color getColor(){
			return color;
		}
		
	}

