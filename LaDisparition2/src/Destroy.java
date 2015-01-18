/*
 * Quand le pulse touche la lumiere alors on transforme la lumiere en case classique
 * Si il fait noir alors tout s'eteind
 * Mettre un boolean pour savoir si la lumiere est eteint ou pas 
 * SwitchOff = false;
 */

public class Destroy {
	//detruire c'est changer les caracteristiques de la case lumiere ainsi que celle adjacente
	//transformé les lumieres et les cases adjacentes en couloir normal
	public boolean isTouched = false;
	private static Bulleti bi;
	private static Bulletg bg;
		
			public Destroy(){
				Map map = new Map();
				if     (/*bi.getX() == 3 && bi.getY() == 4 || 
						bi.getX() == 3 && bi.getY() == 7 || 
						bi.getX() == 6 && bi.getY() == 1 || 
						bi.getX() == 7 && bi.getY() == 4 ||
						bi.getX() == 9 && bi.getY() == 5 ||
						
						bg.getX() == 3 && bg.getY() == 4 || 
						bg.getX() == 3 && bg.getY() == 7 || 
						bg.getX() == 6 && bg.getY() == 1 || 
						bg.getX() == 7 && bg.getY() == 4 ||
						bg.getX() == 9 && bg.getY() == 5   */
						infiltrant.getX() == 3 && infiltrant.getY() == 4
						){
					map.destroyLight1();
					isTouched = true;
				}
				else{
					isTouched = false;
				}
			}
	

	
}
