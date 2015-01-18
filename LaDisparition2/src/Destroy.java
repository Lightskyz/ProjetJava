/*
 * Quand le pulse touche la lumiere alors on transforme la lumiere en case classique
 * Si il fait noir alors tout s'eteind
 * Mettre un boolean pour savoir si la lumiere est eteint ou pas 
 * SwitchOff = false;
 */

public class Destroy {
	//detruire c'est changer les caracteristiques de la case lumiere ainsi que celle adjacente
	
	private static Map map;
	private static Bulletg g;
	private static Bulleti i;
	
		public void destroyLight(){
			map = new Map ();
			if ()
				
				
			for (int i = 0; i < map.length; i++){ //double boucle qui permet de parcourir ma map (i d�finit les coordonn�es en x et j les coordonn�es en y)
				for (int j=0; j< map[i].length; j++){
					if (map[i][j] == 1){//passé toutes les valeurs de 1 à 0 (toutes les cases grises, deviennent noir, or en plus de devenir noir elle recupere aussi les caracteristiques du couloir (ne pas se deplacer)
						map[i][j] = 5;
							}
					if(map[i][j] == 3){
						map[i][j] = 7;
						}
					}
		}
	
}
}