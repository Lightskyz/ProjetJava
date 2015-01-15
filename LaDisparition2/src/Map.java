import java.awt.Color;


public class Map {

	public static int [][] map; //ma mape sera un tableau de tableau --> une grille composé de Tiles
			
	public Map(){ //constructeur de ma classe -- je définis les Tiles de ma map
		map = new int[15][7];
		
		//premiere colonne => couloir
		map[0][0]=1;
		map[0][1]=1;
		map[0][2]=1;
		map[0][3]=1;
		map[0][4]=1;
		map[0][5]=1;
		map[0][6]=1;
		
		//deuxieme colonne
		map[1][0]=0;
		map[1][1]=1;
		map[1][2]=0;
		map[1][3]=0;
		map[1][4]=0;
		map[1][5]=0;
		map[1][6]=1;
		
		//troisieme colonne
		map[2][0]=1;
		map[2][1]=1;
		map[2][2]=1;
		map[2][3]=2;
		map[2][4]=1;
		map[2][5]=1;
		map[2][6]=2;
		
		//4
		map[3][0]=0;
		map[3][1]=1;
		map[3][2]=0;
		map[3][3]=0;
		map[3][4]=0;
		map[3][5]=0;
		map[3][6]=1;
		
		//5
		map[4][0]=1;
		map[4][1]=1;
		map[4][2]=1;
		map[4][3]=1;
		map[4][4]=1;
		map[4][5]=1;
		map[4][6]=1;
		
		//6
		map[5][0]=2;
		map[5][1]=0;
		map[5][2]=0;
		map[5][3]=1;
		map[5][4]=0;
		map[5][5]=0;
		map[5][6]=0;
		
		//7
		map[6][0]=1;
		map[6][1]=1;
		map[6][2]=1;
		map[6][3]=2;
		map[6][4]=1;
		map[6][5]=1;
		map[6][6]=1;
		
		//8
		map[7][0]=0;
		map[7][1]=0;
		map[7][2]=0;
		map[7][3]=1;
		map[7][4]=0;
		map[7][5]=1;
		map[7][6]=0;

		//9
		map[8][0]=1;
		map[8][1]=1;
		map[8][2]=1;
		map[8][3]=1;
		map[8][4]=2;
		map[8][5]=1;
		map[8][6]=1;
		
		//10
		map[9][0]=1;
		map[9][1]=0;
		map[9][2]=0;
		map[9][3]=0;
		map[9][4]=1;
		map[9][5]=0;
		map[9][6]=0;
		
		//11
		map[10][0]=1;
		map[10][1]=1;
		map[10][2]=1;
		map[10][3]=1;
		map[10][4]=1;
		map[10][5]=1;
		map[10][6]=1;
		
		//12
		map[11][0]=1;
		map[11][1]=0;
		map[11][2]=0;
		map[11][3]=0;
		map[11][4]=3;
		map[11][5]=0;
		map[11][6]=0;
		
		//13
		map[12][0]=1;
		map[12][1]=1;
		map[12][2]=1;
		map[12][3]=1;
		map[12][4]=1;
		map[12][5]=1;
		map[12][6]=1;
		
		//14
		map[13][0]=1;
		map[13][1]=0;
		map[13][2]=1;
		map[13][3]=0;
		map[13][4]=0;
		map[13][5]=0;
		map[13][6]=0;
		
		//15 eme colonne
		map[14][0]=1;
		map[14][1]=1;
		map[14][2]=1;
		map[14][3]=1;
		map[14][4]=1;
		map[14][5]=1;
		map[14][6]=1;
		
	}
	

	
	public void drawMap(){//je crée la methode qui permet de dessiner ma map
		for (int i = 0; i < map.length; i++){ //double boucle qui permet de parcourir ma map (i définit les coordonnées en x et j les coordonnées en y)
			for (int j=0; j< map[i].length; j++){
				/*Je définit les conditions pour différencier chaque case 
				 * => si la case = 0 alors la case sera noir (mur)
				 * => si la case = 1 alors la case sera grise (couloir)
				 * => si la case = 2 alors la case sera jaune (lumiere)
				 * => si la case = 3 alors la case sera bleue (ordinateur)
				 */
				
				/**
			     * Draw a square of side length 2r, centered on (x, y).
			     * @param x the x-coordinate of the center of the square
			     * @param y the y-coordinate of the center of the square
			     * @param r radius is half the length of any side of the square
			     * @throws IllegalArgumentException if r is negative
			     */
				int r = (int)Game.WIDTH / 2;
				int x = (int)Game.WIDTH * i;
				int y = Game.Y_MAX - (int)Game.WIDTH *j;
				
				if (map[i][j] == 0){ 
					StdDraw.setPenColor(Color.BLACK); //permet de definir la couleur du carré
					StdDraw.filledSquare(x,y,r); //on dessine un carré dans la case
				}
				if (map[i][j] == 1){ 
					StdDraw.setPenColor(Color.GRAY); //permet de definir la couleur du carré
					StdDraw.filledSquare(x,y,r); //on dessine un carré dans la case
				}
				if (map[i][j] == 2){ 
					StdDraw.setPenColor(Color.YELLOW); //permet de definir la couleur du carré
					StdDraw.filledSquare(x,y,r); //on dessine un carré dans la case
				}
				if (map[i][j] == 3){ 
					StdDraw.setPenColor(Color.BLUE); //permet de definir la couleur du carré
					StdDraw.filledSquare(x,y,r); //on dessine un carré dans la case
				}
			}
		}
	}
}
