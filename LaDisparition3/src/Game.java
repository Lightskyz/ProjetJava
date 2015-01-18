
public class Game {

	public static final int scale = 2; //echelle
	public static final int X_MAX = 720 / scale ; //taille de ma fenetre suivant x
	public static final int Y_MAX = 480 / scale ; //taille de ma fenetre suivant y
	public static final float WIDTH = 28f; //taille d'un carré de ma map
	
	public Game(){
		StdDraw.setCanvasSize(X_MAX * scale   , Y_MAX * scale) ; //permet de modifier la taille de la fenetre
		StdDraw.setXscale(-scale  , scale + 32); //permet de définir la taille de notre map (suivant X)
		StdDraw.setYscale(scale + 12, scale + 32);//permet de definir la taille de notre map (suivant Y)
		
	}
	public static void main(String[] args) {
		new Game();
		Map m = new Map("");
		Gardien g = new Gardien(1,1,"perso");
		}

}
