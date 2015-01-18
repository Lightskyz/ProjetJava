
//Classe qui permet de hacker le PC (condition de fin -- 5 secondes √† c√¥t√©)
//if les coordonnées de "infiltrant" et "ordi" sont les memes lancées le chrono, si le joueur est sur la case
//Apres 5 secondes le jeu est fini (ouvrir une pop-up "Vous avez hacké l'ordinateur"
//Quand je suis sur l'ordinateur alors la case clignote (je fais changer de proprio ) ma case

public class Hack {
	public boolean isHacking = false;
	private static Infiltrant i;
		
	public Hack(){
		
		if(i.getX() == 12 && i.getY() == 5){ //map[][] = 3
			boolean isHacking = true;
			
		if (isHacking){
			//lancer le chrono
			System.out.println(isHacking);
			System.out.println(i.getX() + "," + i.getY());
		}
	}	
	


		
	}
	
			//run timer
			//apres 5 secondes de timer, fin du game
			//System.out.println("Vous avez gagné")
	
			

	
}
