
//Classe qui définit l'action lorsque un joueur se fait touché par le PIE
// If coord.pulse = coord.joueur

public class Freeze {
	
	private static Timer timer;
	private static Infiltrant i;
	private static Gardien g;
	private static Bulleti bi;
	private static Bulletg bg;
	private boolean freeze = false;
	
	public Freeze(){
		
		
		if (i.getX() == bi.getX() && i.getY() == bi.getY()){ //si la balle touche le joueur alors freeze 
			freeze = true; //si la position de la balle est la meme que celle du joueur alors...
			//interdir le personnage de bouger pendant 4secondes 
			while(freeze){
				//arreter les deplacements
				
				//lancer le chrono, apres 4 secondes : freeze = false;
				
				
				
			}
			
		}
		
		if (g.getX() == bg.getX() && g.getY() == bg.getY()){
			
			
			
		}
		
		}
	}

	
}