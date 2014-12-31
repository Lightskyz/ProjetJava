
public class Map {

     private int nbLigne;
     private int nbColonne;
     private char [][] grille;
    
     //Constructeur
     
     public Map (int l, int c){
    	 
    	 nbLigne = c;
    	 nbColonne = l;
    	 grille = new char [nbLigne][nbColonne];
    	 
    /* On fait une double boucle for pour remplir lignes et colonnes. quand J++ alors i++ 
     00
     01
     02
     03
     ..
     10
     11
     12
     ..
     1010 
    */
    	 
    	 for (int i=0; i<nbLigne ;i++){
    		 for(int j=0; j<nbColonne ; j++){
    		 
    			 grille[i][j] = 'x';	 
    		 }
    	 }
     }
    //Pour mettre remplir la case par x
    			

	public void afficher() {
	
		System.out.println();
		for (int i=0; i<nbLigne ;i++){
    		 for(int j=0; j<nbColonne ; j++){
    			 
    //Pour delimiter la grille		
    			 System.out.print(" | " + grille[i][j]);
    	 }
    //On termine la grille par une barre | 
    		 
    		 System.out.println(" | ");		
	}		
	//Pour faire un espace 	
		
		System.out.println();
      }	
   
 }
	

