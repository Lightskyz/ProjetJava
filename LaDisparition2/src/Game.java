import java.awt.event.KeyEvent;

public class Game {

	public static final int scale = 2; // echelle
	public static final int X_MAX = 720 / scale; // taille de ma fenetre suivant x
	public static final int Y_MAX = 480 / scale; // taille de ma fenetre suivant y
	public static final float WIDTH = 28f; // taille d'un carré de ma map

	private static Map map; // j'appelle la map dans Game
	private static Infiltrant infiltrant;// j'appelle le joueur1 dans Game
	public static Gardien gardien;
	private static Timer timer;// j'ai besoin du chrono dans Game
	private static Bulleti bi;
	private static Bulletg bg;

	// Mes booleens
	public boolean isOff; // si la lumiere est allumé ou pas 
	public boolean isHacking; // hacker l'ordinateur
	public boolean isFreezing; // supprimer les deplacements du joueurs
	public boolean isContact; // si les 2 joueurs sont à côté
	public boolean isTouched;//si une balle touche la lumiere

	// List<Entity> entities = new ArrayList<Entity>();

	public Game() throws InterruptedException {
		StdDraw.setCanvasSize(2 * 120 + X_MAX * (scale + 1), Y_MAX * (scale + 1)); // permet de modifier la taille de la fenetre
		StdDraw.setXscale(0, X_MAX + 3 * WIDTH); // permet de définir la taille de notre map (suivant X)
		StdDraw.setYscale(0, Y_MAX); // permet de definir la taille de notre map (suivant Y)

		map = new Map();
		infiltrant = new Infiltrant(1, 1);
		gardien = new Gardien(15, 1);
		timer = new Timer();
		bi = new Bulleti(infiltrant.getX(), infiltrant.getY());
		bg = new Bulletg(gardien.getX(), gardien.getY());

		while (true) {// boucle infinie
			timer.start(); // on lance le chrono

			// deplacement
			Infiltrant.movePlayer(infiltrant);
			Gardien.movePlayer(gardien);
			bi.movePulse(bi);
			//bg.movePulse(bg);
			
			// affichage
			map.drawMap(); // je dessine la map
			infiltrant.drawPlayer(); // je dessine le joueur par dessus la carte
			gardien.drawPlayer(); // ça dessine la map quand c'est allumé
			
			// si je tire alors je les dessine et il bouge tout seul dans la
			// direction demandé
			// créer une methode "shoot"
			// if (StdDraw.isKeyPressed(KeyEvent.VK_G) &&
			// StdDraw.isKeyPressed(KeyEvent.VK_Z)){
			 
			  //où move up c'est de se deplacer sur 4 cases sauf
			// si ça touche un mur
			// b1.movePulse(b1);
			// si ça touche un mur alors
			// remove (entity)
			
			//Hacker l'ordinateur
			Hack();
						
			//Eteindre la lumiere
			Blackout();

			//Detruire les lumieres
			Destroy();
			
			
			StdDraw.show(0);
			;// permet d'afficher des animations où 0 = le nombre de
				// milliseconde

			timer.stop();

			long time = 300 - timer.getElapsedTime(); // sensibilité, temps de reponse à partir du moment ou on lui ordonne une action
			if (time < 300) {
				Thread.sleep(time); // pause || thread = pille
			}
		}
	}

	private void Blackout() {
		// TODO Auto-generated method stub
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
	}

	private void Destroy() {
			
		//remplacé tous les infiltrants par bi et gardien par bg
		//boolean pas tres utile, marche aussi sans
		
		if     (infiltrant.getX() == 3 && infiltrant.getY() == 4 || gardien.getX() == 3 && gardien.getY() == 4
				){
			map.destroyLight1();
			isTouched = true;
			}
			
	
			if (infiltrant.getX() == 3 &&infiltrant.getY() == 7 || bg.getX() == 3 && bg.getY() == 7 ){
				map.destroyLight2();
			isTouched = true;
				}
			if (infiltrant.getX() == 6 && infiltrant.getY() == 1 || bg.getX() == 6 && bg.getY() == 1 ){
				map.destroyLight3();
			isTouched = true;
				}
			if (infiltrant.getX() == 7 && infiltrant.getY() == 4 || bg.getX() == 7 && bg.getY() == 4 ){
				map.destroyLight4();
			isTouched = true;
				}
			if (infiltrant.getX() == 9 && infiltrant.getY() == 5  || bg.getX() == 9 && bg.getY() == 5 ){
				map.destroyLight5();
			isTouched = true;
				}
			
			}
				
	private void Hack() {
		if(infiltrant.getX() == 12 && infiltrant.getY() == 5){ //map[][] = 3
			boolean isHacking = true;
			
		if (isHacking){
			//lancer le chrono
			Timer timer = new Timer();
			timer.start();
			System.out.println(isHacking);
			System.out.println(infiltrant.getX() + "," + infiltrant.getY() + " --> " + timer.getElapsedTime());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException { // throws InterruptedException necessaire pour "Thread"
		new Game();
	}
}
