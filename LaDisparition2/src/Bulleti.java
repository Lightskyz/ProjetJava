import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Bulleti {
	private int x;
	private int y;
	private static Infiltrant infiltrant;
	private static Gardien gardien;
	protected static int [][] map;
	
	public static ArrayList<Bulletg> bullets = new ArrayList<Bulletg>();
	

	public Bulleti(int x, int y) {
		this.x = x; // ce x c'est la position du joueur qui tire
		this.y = y;
	}

	/* public void updatePosition() {
		for (int i = 0; i < bullets.size(); i++) {
			Bulleti b = bullets.get(i);
			if (b.x >= 2000) {
				// si la position de b = mur ou limit alors supprimer
				// si c'est egale � joueur alors freeze
				// si c'est egale � lampe alors detruire
				bullets.remove(b);
			}
		}
	} */

	public int getX() { // je recupere (garder en memoire) le x de mon personnage
		return x;
	}

	public int getY() {// je recupere (garder en memoire) le y de mon personnage
		return y;
	}

	// mes "setteur"
	public void setX(int value) {
		x = value;
	}

	public void setY(int value) {
		y = value;
	}

	public void drawPulse() { // methode qui me permet de dessiner mon joueur
		StdDraw.setPenColor(Color.CYAN);

		int x = (int) Game.WIDTH * getX();
		int y = Game.Y_MAX - (int) Game.WIDTH * getY();
		int r = (int) Game.WIDTH / 3;

		StdDraw.filledCircle(x, y, r); // mon impulsion est une boule bleue
	}

	/* public void shootPulse(){
		int compteur = 0;
		int ammo = 8;
		int portee = 4;
		int p = 0; //compteur de port�e
		infiltrant = new Infiltrant(infiltrant.getX(), infiltrant.getY());
		
		if (compteur < ammo){
			if (StdDraw.isKeyPressed(KeyEvent.VK_G) && StdDraw.isKeyPressed(KeyEvent.VK_Q) && infiltrant.getX() >0 ){
				while (infiltrant.getX() > 0 && 
						p < portee && 
						map[infiltrant.getY()][infiltrant.getX() -1] != 0 &&
						infiltrant.getX() != gardien.getX()){
					//map[infiltrant.getY()][infiltrant.getX() -1] = 8;
					
				//	infiltrant.getX() = infiltrant.getX() -1;
					p ++;
					
				}
				//infiltrant.getX() = infiltrant.getX() + p;
				p = 0;
				
			}
		}
		
		
	} */


	
	
	
	
	
	
	
	
	
	
	
	
	
	/*	public void movePulse(Bulleti pulse) {
		
		Infiltrant inf = new Infiltrant(getX(),getY());
		int nextX = inf.getX();
		int nextY = inf.getY();

		int portee = 4;
		
			//for (int i = 0; i < 4; i++){
		
				if (StdDraw.isKeyPressed(KeyEvent.VK_G) && StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
					// implementer avec le temps pour que ça puisse avancer
					pulse.drawPulse();
					// tout seul sans action
					for (int i = 0; i < 4; i++){
					nextY = nextY - i;
					}
					//remove la balle
					}

				if (StdDraw.isKeyPressed(KeyEvent.VK_G) && StdDraw.isKeyPressed(KeyEvent.VK_S)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					pulse.drawPulse();
					for (int i = 0; i < 4; i++){
					nextY = nextY + i;}
					}

				if (StdDraw.isKeyPressed(KeyEvent.VK_G)
						&& StdDraw.isKeyPressed(KeyEvent.VK_D)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					pulse.drawPulse();
					for (int i = 0; i < 4; i++){
					nextX = nextX + i;
					
					System.out.println(getX() + "," + getY()); 
					/*
					 * (1,1) -> (7,1)
					 * 
					 * 
					 */
/*				
					}
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_G)
						&& StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					pulse.drawPulse();
					for (int i = 0; i < 4; i++){
					nextX = nextX - i;
					}
				}

				if (Map.map[nextX][nextY] == 0 || Map.map[nextX][nextY] == 4)
				
				if (nextX >= 0 && nextX <= Game.scale * Map.map[0].length)// je donne les limites de la map (horizontalement  de part  et  d'autre de   la map)                 
						pulse.setX(nextX);

				if (nextY >= 0 && nextY < Map.map[0].length)// je donne les
															// limites de la map
															// (verticalement de
															// part et d'autre
															// de la map)
					pulse.setY(nextY);

			} */
		
	
	
	/*
	 * J'ai crée l'impulsion qui peut se deplacer sur la carte (get/set)
	 * 
	 * Lui mettre les conditions necessaires c'est à dire : --> munitions
	 * limités (8) --> direction suivant celle du deplacement du joueur --> ne
	 * peut se deplacer que de 4 cases --> si le personnage est touché (les
	 * coordonnées de player 1/2 et de impulsion sont identiues ) alors il ne
	 * peut plus se deplacer pendant 4 secondes (utilisr le chrono) --> si la
	 * borne (2) se fait toucher alors elle est detruite et devient un couloir
	 * (0 si c'est toujours allumé) ou (5 sinon), il faut aussi transformé les
	 * cases adjacentes (6) en cases normal ( 5)) --> définir un etat quand la
	 * map est eteinte --> quand la map est eteinte, lorsque l'impulsion se
	 * deplace alors ça s'allume (devient gris si c'est un couloir, noir mur)
	 * // pas de condition pour les murs/couloir
	 */

}
