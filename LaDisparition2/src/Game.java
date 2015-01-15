import java.awt.event.KeyEvent;



public class Game {
	
	public static final int scale = 2; //echelle
	public static final int X_MAX = 720 / scale; //taille de ma fenetre suivant x
	public static final int Y_MAX = 480 / scale; //taille de ma fenetre suivant y
	public static final float WIDTH = 28f; //taille d'un carr de ma map
	
	private static Map map; //j'appelle la map dans Game
	private static Player player1;//j'appelle le joueur1 dans Game
	public static Player player2;
	private static Timer timer;//j'ai besoin du chrono dans Game

		
	public static void move (Player player1){
		int versX = player1.getX();// je prend en memoire la case ou je vais suivant x
		int versY = player1.getY(); // idem suivant y
		
		
		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
			versY = versY -1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
			versY = versY +1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
			versX = versX +1;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
			versX = versX -1;
		}
				
		if(Map.map[versX][versY] == 0 || Map.map[versX][versY] == 3) //condition, si c'est un mur alors ne rien faire (pas de getteur, ni de setteur)
			return; //ATTENTION ERREUR [versX][versY] position en direct --> une fois que je suis dans un mur a ne marche plus (comme prevu / or je veux delimitter les murs
		
				
		if (versX >=0 && versX <= scale * Map.map[0].length)//je donne les limites de la map (horizontalement de part et d'autre de la map)
			player1.setX(versX);

		if (versY >=0 && versY < Map.map[0].length){//je donne les limites de la map (verticalement de part et d'autre de la map)
			player1.setY(versY);
			}

		
		
		}
	

		
		
	
		
public static void main(String[] args) throws InterruptedException { //throws InterruptedException necessaire pour "Thread"
		StdDraw.setCanvasSize(X_MAX * (scale +1), Y_MAX * (scale +1)); //permet de modifier la taille de la fenetre
		StdDraw.setXscale(0, X_MAX + WIDTH); //permet de dfinir la taille de notre map (suivant X)
		StdDraw.setYscale(0, Y_MAX );//permet de definir la taille de notre map (suivant Y)
		
		map = new Map ();
		player1 = new Player (0,0);
		timer = new Timer();
		
		while(true){//boucle infinie
			timer.start(); //on lance le chrono
			
			move(player1);
			map.drawMap(); //je dessine la map
			player1.drawPlayer(); //je dessine le joueur par dessus la carte
			StdDraw.show(0);//permet d'afficher des animations o 0 = le nombre de milliseconde
			
			timer.stop();
			
			long time = 140 - timer.getElapsedTime();  //sensibilit, temps de reponse ˆ partir du moment ou on lui ordonne une action
			if (time < 140){
				Thread.sleep(time); //pause || thread = fill
			}
		}
	}






}
