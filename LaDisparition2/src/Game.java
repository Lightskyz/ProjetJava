import java.awt.event.KeyEvent;

public class Game {

	public static final int scale = 2; // echelle
	public static final int X_MAX = 720 / scale; // taille de ma fenetre suivant
													// x
	public static final int Y_MAX = 480 / scale; // taille de ma fenetre suivant
													// y
	public static final float WIDTH = 28f; // taille d'un carré de ma map

	private static Map map; // j'appelle la map dans Game
	private static Infiltrant infiltrant;// j'appelle le joueur1 dans Game
	public static Gardien gardien;
	private static Timer timer;// j'ai besoin du chrono dans Game
	private static Bulleti b1;
	private static Bulletg b2;

	// Mes booleens
	public boolean isOff; //
	public boolean isHacking; //
	public boolean isFreezing; //
	public boolean isMoving; //
	public boolean isContact; //

	// List<Entity> entities = new ArrayList<Entity>();

	public Game() throws InterruptedException {
		StdDraw.setCanvasSize(2 * 120 + X_MAX * (scale + 1), Y_MAX
				* (scale + 1)); // permet de modifier la taille de la fenetre
		StdDraw.setXscale(0, X_MAX + 3 * WIDTH); // permet de définir la taille
													// de notre map (suivant X)
		StdDraw.setYscale(0, Y_MAX);// permet de definir la taille de notre map
									// (suivant Y)

		map = new Map();
		infiltrant = new Infiltrant(1, 1);
		gardien = new Gardien(15, 1);
		timer = new Timer();
		b1 = new Bulleti(infiltrant.getX(), infiltrant.getY());
		b2 = new Bulletg(gardien.getX(), gardien.getY());

		while (true) {// boucle infinie

			timer.start(); // on lance le chrono

			// deplacement
			Infiltrant.movePlayer(infiltrant);
			Gardien.movePlayer(gardien);

			// affichage
			map.drawMap(); // je dessine la map

			// si je tire alors je les dessine et il bouge tout seul dans la
			// direction demandé
			// créer une methode "shoot"
			// if (StdDraw.isKeyPressed(KeyEvent.VK_G) &&
			// StdDraw.isKeyPressed(KeyEvent.VK_Z)){
			//b1.drawPulse();
			// b1.move(up); //où move up c'est de se deplacer sur 4 cases sauf
			// si ça touche un mur
			// b1.movePulse(b1);
			// si ça touche un mur alors
			// remove (entity)

			infiltrant.drawPlayer(); // je dessine le joueur par dessus la carte
			gardien.drawPlayer(); // ça dessine la map quand c'est allumé

			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {

				map.switchOff();
				isOff = true;
				System.out.println(isOff);
				// recouvrir la map SwitchOn par un voile noir sauf les cases
				// grises , jaune et l'ordi et les limittes
				// les personnages deviennent invisible meme à la lumiere...
			} else {

				map.switchOn();
				isOff = false;
			}

			StdDraw.show(0);
			;// permet d'afficher des animations où 0 = le nombre de
				// milliseconde

			timer.stop();

			long time = 300 - timer.getElapsedTime(); // sensibilité, temps de
														// reponse à partir du
														// moment ou on lui
														// ordonne une action
			if (time < 300) {
				Thread.sleep(time); // pause || thread = fill
			}
		}
	}

	/*
	 * public void update(){
	 * 
	 * }
	 * 
	 * public void render(){
	 * 
	 * }
	 * 
	 * public void addEntity(Entity e){ entities.add(e); }
	 * 
	 * public void drawEntity(){ String perso = null; addEntity(new
	 * Gardien1(1,0, perso)); }
	 */

	public static void main(String[] args) throws InterruptedException { // throws
																			// InterruptedException
																			// necessaire
																			// pour
																			// "Thread"
		new Game();
	}
}
