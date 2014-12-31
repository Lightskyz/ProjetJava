package com.kevant.main;
	
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;



public class Component {

		public boolean running = false; //booleen qui nous permet de créer notre boucle
	
		public static String title = "La Disparition"; //on nomme notre fenetre (donc notre jeu)
		public static int scale = 3;//nous n'avons pas besoin d'autant de pixels pour notre jeu en 2D
		public static int width = 720/scale ; //largeur de notre fenêtre 
		public static int height = 480/scale ; //haute de notre fenêtre
		
		DisplayMode mode = new DisplayMode( width * scale ,  height * scale ); //création de la fenetre "mode"
	
		public Component ( ) { 
			try{
				Display.setDisplayMode(mode); //afficher la fenetre "mode" qu'on a crée précedemment
				Display.setResizable(true); //pour pouvoir modifier la taille de la fenetre de jeu
				Display.setFullscreen(false); //pour ne pas que la fenetre du jeu soit en plein ecran lorsqu'on l'ouvre
				Display.setTitle(title); //affiche le titre de notre jeu
				Display.create( ); //creation de notre fenetre mais elle se ferme aussi tôt, on doit créer une boucle pour qu'elle reste ouverte
				
				initGL( );
			} catch (LWJGLException e){
				e.printStackTrace( );
			}
		}
		
		private void initGL( ){ //on initialise OpenGL pour pouvoir afficher quelque chose dans notre fenetre
			glMatrixMode(GL_PROJECTION); //définit les propriété de la vue de notre camera qui nous montre nos objets
			glLoadIdentity( ); //remettre à jour nos entités		-- remettre à 0 les compteurs
			GLU.gluOrtho2D(0, width, height, 0);// la largeur à l'ecran
			glMatrixMode(GL_MODELVIEW); //définit comme nos objets vont se transformer (translation, rotation, homothétie) - on retourne à la vue d'origine
			glLoadIdentity( ); //reloader les identités ?
		}
		
		public void start ( ) { //démarrer la boucle
			running = true; 
			loop(); //la boucle démarre comme running = true
		}
		
		public void stop( ){ //arreter la boucle
			running = false;
		}
		
		public void exit( ){ //quitter le jeu
			Display.destroy( ); //on detruit la fenetre
			System.exit(0); //on quitte le jeu
		}
		
		public void loop( ){ //fonction de la boucle
			while(running) { // tant que running = true faire la boucle
				if (Display.isCloseRequested( )) stop(); //lorsqu'on demande de quitter (croix rouge en haut à droite) la fenêtre alors running = false (on fait stop)
				Display.update(); // on met à jour l'argument running en false alors la boucle est stopper
				
				render ( );
			}
			exit( ); //on quitte le jeu
		}
		
	// problème lorsque je boucle la fenetre, vitesse de rafraichissement trop lent, on voit la fenetre clignoter au lieu de rester fixe
	// recherche d'une solution sur internet
		
		public void render ( ){ //dessiner quelque chose à l'ecran
			
			int x = 16;
			int y = 16;
			int size = 16;
			glBegin (GL_QUADS);
				glColor3f( 0.5f, 1.0f, 0.8f);
				glVertex2f(x , y);
				glVertex2f(x  + size, y);
				glVertex2f(x + size, y + size);
				glVertex2f(x, y+size);
			glEnd( );
		}
		
		
		
		public static void main (String [ ]  args) {
			Component main = new Component( ); //on ouvre la fenêtre
			
			main.start( ); //on appelle la boucle qui laisse ouvert la fenetre
			}
}
