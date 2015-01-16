import java.awt.Color;
import java.awt.event.KeyEvent;


public class Impulsion {
	private int x;
	private int y;
	
	public Impulsion(int x, int y){
		this.x = x; //ce x c'est la position du joueur qui tire
		this.y = y;
		}
	
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
	
	public void drawPulse(){ //methode qui me permet de dessiner mon joueur
		StdDraw.setPenColor(Color.CYAN);
		
		int x = (int)Game.WIDTH * getX();
		int y = Game.Y_MAX - (int)Game.WIDTH * getY();
		int r = (int)Game.WIDTH / 3;
			
		StdDraw.filledCircle(x, y, r); // mon impulsion est une boule bleue
		}
	
<<<<<<< HEAD
	
		public void movePulse(Impulsion pulse){
			int nextX = pulse.getX();
			int nextY = pulse.getY();
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_G)){
				//implementer avec le temps pour que ça puisse avancer tout seul sans action
				
				nextY = nextY -1;
				nextY = nextY +1;
				nextX = nextX +1;
				nextX = nextX -1;
			}
			
			for (int i = nextX;i <nextX+4; nextX++){//portée de 4 cases suivant x
				for (int j = nextY; j < nextY + 4; nextY ++){
					
				}
			}
		}
	
=======
	public static void move (Impulsion pulse){
		int nextX = pulse.getX();// je prend en memoire la case ou je vais suivant x
		int nextY = pulse.getY(); // idem suivant y
		
		
		if (StdDraw.isKeyPressed(KeyEvent.VK_G)){
			nextY = nextY -1;
		}
		
		if (nextX >=0 && nextX <= Game.scale * Map.map[0].length)//je donne les limites de la map (horizontalement de part et d'autre de la map)
			pulse.setX(nextX);
		
		
		if (nextY >=0 && nextY < Map.map[0].length)//je donne les limites de la map (verticalement de part et d'autre de la map)
			pulse.setY(nextY);
		
		
	}
>>>>>>> 85f46cccf36c3ebecd33914062a81b35e4f5bdc8
	/* J'ai crée l'impulsion qui peut se deplacer sur la carte (get/set)
	 * 
	 * 			Lui mettre les conditions necessaires c'est à dire :
	 *  --> munitions limités (8)
	 *	--> direction suivant celle du deplacement du joueur
	 *  -->  ne peut se deplacer que de 4 cases
	 *   -->  si le personnage est touché (les coordonnées de player 1/2 et de impulsion sont identiues ) alors il ne peut plus se deplacer pendant 4 secondes (utilisr  le chrono)
	 *  --> si la borne (2) se fait toucher alors elle est detruite et devient un couloir (0 si c'est toujours allumé) ou (5 sinon), il faut aussi transformé les cases adjacentes (6) en cases normal ( 5)) --> définir un etat quand la map est eteinte
	 *   --> quand la map est eteinte, lorsque l'impulsion se deplace alors ça s'allume (devient gris si c'est un couloir, noir mur) // pas de condition pour les murs/couloir
	 */
	
	
}
