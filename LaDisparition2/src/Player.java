import java.awt.Color;


public class Player {
	private int x; //coordonnée de mon joueur suivant x
	private int y;//coordonnée suivant y
	
	public Player (int x, int y){//constructeur de ma classe Player
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



}

