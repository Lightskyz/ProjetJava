import java.awt.Color;


public class Impulsion {
	private int x;
	private int y;
	
	public Impulsion(int x, int y){
		this.x = x;
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
