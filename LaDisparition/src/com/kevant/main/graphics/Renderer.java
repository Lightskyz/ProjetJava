package com.kevant.main.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
	public static void quadData(int x, int y, int w, int h, float [] color) { //dessine le carré
		glColor4f(color [0], color[1], color [2], color [3]);
		glVertex2f(x,y);
		glVertex2f(x + w, y );
		glVertex2f(x + w, y + h);
		glVertex2f(x, y + h);
		}
	
	public static void renderQuad (int x, int y, int w, int h, float [] color){ //on a crée deux fonctions statiques pour éviter de faire une nouvelle instance dans la fonction component mais les appeler direct  
		glBegin(GL_QUADS);
			Renderer.quadData(x, y, w, h, color);
		glEnd();
	}
}

/* 		Code précedemment situé dans "component.java"
* 
*
*  		glClearColor(0.8f, 0.9f, 1.0f , 1.0f); //on colore le fond de la page (4eme valeur : opacité) 
*
*
*		 int x = 16 + time / 4; //deplacement du cube suivant x
*	 	int y = 16 + time / 4 ; //deplacement du cube suivant y
*	 	int size = 16; 
*
*		glBegin (GL_QUADS); //pour dessiner le cube
*		Renderer.quadData(16, 16, 16, 16); //remplace tout ce qu'il y a ci-dessous
*
*		glColor3f( 0.2f, 0.1f, 0.0f); //couleur des 2 points haut
*		glVertex2f(x , y); //haut gauche
*  	  	glVertex2f(x  + size, y); //haut droite
*	
*		glColor3f( 2.0f, 0.0f, 0.0f); //couleur des 2 points bas
*		glVertex2f(x + size, y + size); //bas droite
*		glVertex2f(x, y+size); //bas gauche		 
*
*
*		glEnd( ); */