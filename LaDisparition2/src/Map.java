import java.awt.Color;


public class Map {

	public static int [][] map; //ma mape sera un tableau de tableau --> une grille composé de Tiles
			
	public Map(){ //constructeur de ma classe -- je définis les Tiles de ma map
		map = new int[17][9];
		
		//premiere colonne => limite de la carte a gauche !
		map[0][0]=4;
		map[0][1]=4;
		map[0][2]=4;
		map[0][3]=4;
		map[0][4]=4;
		map[0][5]=4;
		map[0][6]=4;
		map[0][7]=4;
		map[0][8]=4;
		
		//deuxieme colonne
		map[1][0]=4;
		map[1][1]=1;
		map[1][2]=1;
		map[1][3]=1;
		map[1][4]=1;
		map[1][5]=1;
		map[1][6]=1;
		map[1][7]=1;
		map[1][8]=4;
		
		//troisieme colonne
		map[2][0]=4;
		map[2][1]=0;
		map[2][2]=1;
		map[2][3]=0;
		map[2][4]=0;
		map[2][5]=0;
		map[2][6]=0;
		map[2][7]=1;
		map[2][8]=4;
		
		//4
		map[3][0]=4;
		map[3][1]=1;
		map[3][2]=1;
		map[3][3]=1;
		map[3][4]=2;
		map[3][5]=1;
		map[3][6]=1;
		map[3][7]=2;
		map[3][8]=4;
		
		//5
		map[4][0]=4;
		map[4][1]=0;
		map[4][2]=1;
		map[4][3]=0;
		map[4][4]=0;
		map[4][5]=0;
		map[4][6]=0;
		map[4][7]=1;
		map[4][8]=4;
		
		//6
		map[5][0]=4;
		map[5][1]=1;
		map[5][2]=1;
		map[5][3]=1;
		map[5][4]=1;
		map[5][5]=1;
		map[5][6]=1;
		map[5][7]=1;
		map[5][8]=4;
		
		//7
		map[6][0]=4;
		map[6][1]=2;
		map[6][2]=0;
		map[6][3]=0;
		map[6][4]=1;
		map[6][5]=0;
		map[6][6]=0;
		map[6][7]=0;
		map[6][8]=4;
		
		//8
		map[7][0]=4;
		map[7][1]=1;
		map[7][2]=1;
		map[7][3]=1;
		map[7][4]=2;
		map[7][5]=1;
		map[7][6]=1;
		map[7][7]=1;
		map[7][8]=4;
		
		//9
		map[8][0]=4;
		map[8][1]=0;
		map[8][2]=0;
		map[8][3]=0;
		map[8][4]=1;
		map[8][5]=0;
		map[8][6]=1;
		map[8][7]=0;
		map[8][8]=4;
		
		//10
		map[9][0]=4;
		map[9][1]=1;
		map[9][2]=1;
		map[9][3]=1;
		map[9][4]=1;
		map[9][5]=2;
		map[9][6]=1;
		map[9][7]=1;
		map[9][8]=4;
		
		//11
		map[10][0]=4;
		map[10][1]=1;
		map[10][2]=0;
		map[10][3]=0;
		map[10][4]=0;
		map[10][5]=1;
		map[10][6]=0;
		map[10][7]=0;
		map[10][8]=4;
		
		//12
		map[11][0]=4;
		map[11][1]=1;
		map[11][2]=1;
		map[11][3]=1;
		map[11][4]=1;
		map[11][5]=1;
		map[11][6]=1;
		map[11][7]=1;
		map[11][8]=4;
		
		//13
		map[12][0]=4;
		map[12][1]=1;
		map[12][2]=0;
		map[12][3]=0;
		map[12][4]=0;
		map[12][5]=3;
		map[12][6]=0;
		map[12][7]=0;
		map[12][8]=4;
		
		//14
		map[13][0]=4;
		map[13][1]=1;
		map[13][2]=1;
		map[13][3]=1;
		map[13][4]=1;
		map[13][5]=1;
		map[13][6]=1;
		map[13][7]=1;
		map[13][8]=4;
		
		//15 eme colonne
		map[14][0]=4;
		map[14][1]=1;
		map[14][2]=0;
		map[14][3]=1;
		map[14][4]=0;
		map[14][5]=0;
		map[14][6]=0;
		map[14][7]=0;
		map[14][8]=4;
		
		//16eme colonne
		map[15][0]=4;
		map[15][1]=1;
		map[15][2]=1;
		map[15][3]=1;
		map[15][4]=1;
		map[15][5]=1;
		map[15][6]=1;
		map[15][7]=1;
		map[15][8]=4;
		
		//17eme colonne --> limite de la carte (à droite)
		map[16][0]=4;
		map[16][1]=4;
		map[16][2]=4;
		map[16][3]=4;
		map[16][4]=4;
		map[16][5]=4;
		map[16][6]=4;
		map[16][7]=4;
		map[16][8]=4;
		
	}
	

	
	public void drawMap(){//je crée la methode qui permet de dessiner ma map
		for (int i = 0; i < map.length; i++){ //double boucle qui permet de parcourir ma map (i définit les coordonnées en x et j les coordonnées en y)
			for (int j=0; j< map[i].length; j++){
				/*Je définit les conditions pour différencier chaque case 
				 * => si la case = 0 alors la case sera noir (mur)
				 * => si la case = 1 alors la case sera grise (couloir)
				 * => si la case = 2 alors la case sera jaune (lumiere)
				 * => si la case = 3 alors la case sera bleue (ordinateur)
				 * 
				 * => si la case = 4 alors c'est la limité de la carte -- couleur verte // 2eme possibilité pour delimiter la carte, car le fichier ne veut pas prendre en compte les murs et les limites en meme temps, par contre elle accepte les deux en meme temps...
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
				if (map[i][j] == 4){ 
					StdDraw.setPenColor(Color.GREEN); //permet de definir la couleur du carré
					StdDraw.filledSquare(x, y, r);
				}
			}
		}
	}
}
