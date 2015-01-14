

public class Game {
	
	public static final int scale = 2;
	public static final int X_MAX = 720 / scale; //taille de ma fenetre suivant x
	public static final int Y_MAX = 480 / scale; //taille de ma fenetre suivant y
	public static final float WIDTH = 28f; //taille d'un carré de ma map
	
	private static Map map;
	
	private static Timer timer;

	
	
	
public static void main(String[] args) throws InterruptedException { //throws InterruptedException necessaire pour "Thread"
		StdDraw.setCanvasSize(X_MAX * (scale +1), Y_MAX * (scale +1)); //permet de modifier la taille de la fenetre
		StdDraw.setXscale(0, X_MAX + WIDTH); //permet de définir la taille de notre map (suivant X)
		StdDraw.setYscale(0, Y_MAX );//permet de definir la taille de notre map (suivant Y)
		
		map = new Map ();
		
		timer = new Timer();
		
		while(true){//boucle infinie
			timer.start(); //on lance le chrono
			
			map.drawMap();
			
			StdDraw.show(0);//permet d'afficher des animations où 0 = le nombre de milliseconde
			
			timer.stop();
			
			long time = 500 - timer.getElapsedTime();
			if (time < 500){
				Thread.sleep(time); //pause || thread = fill
			}
		}
	}






}
