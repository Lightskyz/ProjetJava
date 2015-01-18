import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Bulletg {
	private int x;
	private int y;

	public static ArrayList<Bulleti> bullets = new ArrayList<Bulleti>();
	public static int ammo = 8;

	public Bulletg(int x, int y) {
		this.x = x; // ce x c'est la position du joueur qui tire
		this.y = y;
	}

	public void updatePosition() { // deplacement -- comparer avec la methode
									// move
		for (int i = 0; i < bullets.size(); i++) {
			Bulletg b = bullets.get(i);
			if (b.x >= 2000) {
				// si la position de b = mur ou limit alors supprimer
				// si c'est egale � joueur alors freeze
				// si c'est egale � lampe alors detruire
				// la balle avance tant qu'elle a pas atteint �a port�e
				// on peut toujours tirer tant qu'il ya des munitions
				bullets.remove(b);
			}
		}
	}

	public int getX() { // je recupere (garder en memoire) le x de mon
						// personnage
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
		int r = (int) Game.WIDTH / 5;

		StdDraw.filledCircle(x, y, r); // mon impulsion est une boule bleue
	}

	public void movePulse(Bulletg pulse) {
		int nextX = pulse.getX();
		int nextY = pulse.getY();

		for (int i = nextX; i < nextX + 5; nextX++) {// portée de 4 cases
														// suivant x
			for (int j = nextY; j < nextY + 5; nextY++) {

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)
						&& StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					nextY = nextY - 1;
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)
						&& StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					nextY = nextY + 1;
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)
						&& StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					nextX = nextX + 1;
				}

				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)
						&& StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
					// implementer avec le temps pour que ça puisse avancer
					// tout seul sans action
					nextX = nextX - 1;
				}

				/*
				 * if(Map.map[nextX][nextY] == 0 || Map.map[nextX][nextY] == 4)
				 * //condition, si c'est un mur alors ne rien faire (pas de
				 * getteur, ni de setteur) return;
				 * 
				 * if(Map.map[nextX][nextY] == 2) //condition, si c'est une
				 * lumiere alors detruire //DESTROY
				 * 
				 * return;
				 * 
				 * if(Map.map[nextX][nextY] == || Map.map[nextX][nextY] == )
				 * //condition, si c'est un mur alors ne rien faire (pas de
				 * getteur, ni de setteur)
				 * 
				 * 
				 * return;
				 * 
				 * //limite de ma map if (nextX >=0 && nextX <= Game.scale *
				 * Map.map[0].length)//je donne les limites de la map
				 * (horizontalement de part et d'autre de la map)
				 * pulse.setX(nextX);
				 * 
				 * 
				 * if (nextY >=0 && nextY < Map.map[0].length)//je donne les
				 * limites de la map (verticalement de part et d'autre de la
				 * map) pulse.setY(nextY);
				 * 
				 * }
				 */
			}
		}

		/*
		 * J'ai crée l'impulsion qui peut se deplacer sur la carte (get/set)
		 * 
		 * Lui mettre les conditions necessaires c'est à dire : --> munitions
		 * limités (8) --> direction suivant celle du deplacement du joueur -->
		 * ne peut se deplacer que de 4 cases --> si le personnage est touché
		 * (les coordonnées de player 1/2 et de impulsion sont identiues )
		 * alors il ne peut plus se deplacer pendant 4 secondes (utilisr le
		 * chrono) --> si la borne (2) se fait toucher alors elle est detruite
		 * et devient un couloir (0 si c'est toujours allumé) ou (5 sinon), il
		 * faut aussi transformé les cases adjacentes (6) en cases normal ( 5))
		 * --> définir un etat quand la map est eteinte --> quand la map est
		 * eteinte, lorsque l'impulsion se deplace alors ça s'allume (devient
		 * gris si c'est un couloir, noir mur) // pas de condition pour les
		 * murs/couloir
		 */

	}
}
