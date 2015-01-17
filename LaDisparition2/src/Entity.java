import java.awt.Color;


public abstract class Entity {
	protected int x, y; //coordonn�e de mon joueur suivant x - accesible par les classes filles
	protected boolean removed = false;//coordonn�e suivant y
	protected String name;
			
		public Entity (int x, int y, String name){//constructeur de ma classe Player
				this.x = x;
				this.y = y;
				this.name = name;
			}


		public abstract void update();
		public abstract void render();
		
		//mes "getteur"
		public int getX(){ // je recupere (garder en memoire) le x de mon personnage
			return x;
		}
		
		public int getY(){// je recupere (garder en memoire) le y de mon personnage
			return y;
		}
			
		//mes "setteur"
		public void setX(int value){
			x = value;
		}
		public void setY(int value){
			y = value;
		}

		public boolean getRemoved(){
			return removed;
		}
			
		public String drawEntity(){
			StdDraw.setPenColor(Color.PINK);
			
			int x = (int)Game.WIDTH * getX();
			int y = Game.Y_MAX - (int)Game.WIDTH * getY();
			//int r = (int)Game.WIDTH / 2;
			
			
			 StdDraw.picture(x,y, name +".gif");
			return name;
		}

}
