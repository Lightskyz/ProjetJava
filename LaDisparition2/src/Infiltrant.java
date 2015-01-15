import java.awt.Color;
import java.awt.event.KeyEvent;


public class Infiltrant {
		private int x; //coordonne de mon joueur suivant x
		private int y;//coordonne suivant y
		
		public Infiltrant (int x, int y){//constructeur de ma classe Player
			this.x = x;
			this.y = y;
		}

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


	public void drawPlayer(){ //methode qui me permet de dessiner mon joueur
		StdDraw.setPenColor(Color.PINK);
		
		int x = (int)Game.WIDTH * getX();
		int y = Game.Y_MAX - (int)Game.WIDTH * getY();
		//int r = (int)Game.WIDTH / 2;
		
		
		 StdDraw.picture(x,y,"perso.gif");
		 
		 
		
		//StdDraw.filledCircle(x, y, r);
		
		}

	public static void move (Infiltrant player){
		int versX = player.getX();// je prend en memoire la case ou je vais suivant x
		int versY = player.getY(); // idem suivant y
		
		
		if (StdDraw.isKeyPressed(KeyEvent.VK_Z)){
			versY = versY -1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_S)){
			versY = versY +1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_D)){
			versX = versX +1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_Q)){
			versX = versX -1;
		}
				
		if(Map.map[versX][versY] == 0 || Map.map[versX][versY] == 3 || Map.map[versX][versY] == 4) //condition, si c'est un mur alors ne rien faire (pas de getteur, ni de setteur)
			return;//ATTENTION ERREUR [versX][versY] position en direct --> une fois que je suis dans un mur a ne marche plus (comme prevu / or je veux delimitter les murs
			
			
			//ERREUR ! Soit les murs soit les limites ! 
				
		if (versX >=0 && versX <= Game.scale * Map.map[0].length)//je donne les limites de la map (horizontalement de part et d'autre de la map)
			player.setX(versX);
		
		
		if (versY >=0 && versY < Map.map[0].length)//je donne les limites de la map (verticalement de part et d'autre de la map)
			player.setY(versY);
		

		}

	
}
