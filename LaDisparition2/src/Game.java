import java.awt.event.KeyEvent;

public class Game {
	
	public static final int scale = 2; //echelle
	public static final int X_MAX = 720 / scale; //taille de ma fenetre suivant x
	public static final int Y_MAX = 480 / scale; //taille de ma fenetre suivant y
	public static final float WIDTH = 28f; //taille d'un carré de ma map
	
	private static Map map; //j'appelle la map dans Game
	private static Infiltrant infiltrant;//j'appelle le joueur1 dans Game
	public static Gardien gardien;
	private static Timer timer;//j'ai besoin du chrono dans Game
	
		
	public Game() throws InterruptedException{
		StdDraw.setCanvasSize(2*120 + X_MAX * (scale +1 ), Y_MAX * (scale +1)); //permet de modifier la taille de la fenetre
		StdDraw.setXscale(0, X_MAX + 3*WIDTH ); //permet de définir la taille de notre map (suivant X)
		StdDraw.setYscale(0, Y_MAX );//permet de definir la taille de notre map (suivant Y)
		
		map = new Map ();
		infiltrant = new Infiltrant (1,1);
		gardien = new Gardien (15,1);
		timer = new Timer();
		
		
		
		while(true){//boucle infinie
			timer.start(); //on lance le chrono
			
			Infiltrant.move(infiltrant);
			Gardien.move(gardien);
			map.drawMap(); //je dessine la map
			infiltrant.drawPlayer(); //je dessine le joueur par dessus la carte
			gardien.drawPlayer();
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
			map.switchOff();
			}
			
			StdDraw.show(0);;//permet d'afficher des animations où 0 = le nombre de milliseconde
			
			timer.stop();
			
			long time = 190 - timer.getElapsedTime();  //sensibilité, temps de reponse à partir du moment ou on lui ordonne une action
			if (time < 190){
				Thread.sleep(time); //pause || thread = fill
	}
			}
	}
	
	public static void main(String[] args) throws InterruptedException { //throws InterruptedException necessaire pour "Thread"
		new Game( );
			}
		
	
}
