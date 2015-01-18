
//Classe qui permet de hacker le PC (condition de fin -- 5 secondes √† c√¥t√©)
//if les coordonnées de "infiltrant" et "ordi" sont les memes lancées le chrono, si le joueur est sur la case
//Apres 5 secondes le jeu est fini (ouvrir une pop-up "Vous avez hacké l'ordinateur"
//Quand je suis sur l'ordinateur alors la case clignote (je fais changer de proprio ) ma case

public class Hack {
	public boolean isHacking = false;
	private static Infiltrant i;
	private static Map map;
	
	public Hack(){
		if (isHacking){
			//lancer le chrono
		}
	}	
	

	if(i.getX == 12 && i.getY == 5){ //map[][] = 3
	
		boolean isHacking = true;
		
		
		for (int i = 0; i < map.length; i++){ //double boucle qui permet de parcourir ma map (i dÔøΩfinit les coordonnÔøΩes en x et j les coordonnÔøΩes en y)
			for (int j=0; j< map[i].length; j++){
		
				map[i][j] = 8; //si nous sommes sur la case de l'ordi alors la case s'eclaire 
			}
		}
	}
	
			//run timer
			//apres 5 secondes de timer, fin du game
			//System.out.println("Vous avez gagné")
	
			

	
}
