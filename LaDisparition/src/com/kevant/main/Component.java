package com.kevant.main;
	
import org.lwjgl.LWJGLException; //Utilisation de la bibliotheque OpenGL
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import com.kevant.main.graphics.Renderer;

import static org.lwjgl.opengl.GL11.*;



public class Component {

		public boolean running = false; //booleen qui nous permet de créer notre boucle
	
		public static String title = "La Disparition"; //on nomme notre fenetre (donc notre jeu)
		public static int scale = 3;//nous n'avons pas besoin d'autant de pixels pour notre jeu en 2D
		public static int width = 720/scale ; //largeur de notre fenêtre 
		public static int height = 480/scale ; //haute de notre fenêtre
		
		int time = 0; //initialisation du temps
		
		public static boolean tick =  false;
		public static boolean render = false;
		
		DisplayMode mode = new DisplayMode( width * scale ,  height * scale ); //création de la fenetre "mode"
	
		public Component ( ) { 
			try{
				Display.setDisplayMode(mode); //afficher la fenetre "mode" qu'on a crée précedemment
				Display.setResizable(true); //pour pouvoir modifier la taille de la fenetre de jeu
				Display.setFullscreen(false); //pour ne pas que la fenetre du jeu soit en plein ecran lorsqu'on l'ouvre
				Display.setTitle(title); //affiche le titre de notre jeu
				Display.create( ); //creation de notre fenetre mais elle se ferme aussi tôt, on doit créer une boucle pour qu'elle reste ouverte
				
				view2D(width, height);
			} catch (LWJGLException e){
				e.printStackTrace( );
			}
		}
		
		private void view2D( int width , int height ){ //on initialise OpenGL pour pouvoir afficher quelque chose dans notre fenetre
			glViewport (0, 0, width *  scale , height * scale );
			
			
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
			
			long timer = System.currentTimeMillis();
			
			
			long before = System.nanoTime(); //on récupere un "grand" entier qui est le temps juste avant 
			double elapsed = 0; //temps entre maintenant et avant
			double nanoSeconds = 1000000000.0/ 60.0; //on veut 60 images par secondes
			
			int ticks = 0;
			int frames = 0;
			
			while(running) { // tant que running = true faire la boucle
				if (Display.isCloseRequested( )) stop(); //lorsqu'on demande de quitter (croix rouge en haut à droite) la fenêtre alors running = false (on fait stop)
				Display.update(); // on met à jour l'argument running en false alors la boucle est stopper
				width = Display.getWidth() / scale; //rend dynamique la largeur
				height = Display.getHeight() / scale; //rend dynamique la hauteur
				// "KISS" grâce à OpenGL sans pour rendre la fenetre dynamique, difficile ! 
				
				
				tick = false;
				render = false;
				
				long now = System.nanoTime();
				elapsed = now - before;
				
				if (elapsed > nanoSeconds){ //si elapsed est plus grand que ns alors on fait la boucle
					before += nanoSeconds; //remise à 0 de elapsed pour recommencer la boucle
					tick = true;
					ticks ++; //compteur de ticks
				}
				else{
					render = true; //s'il y a des ticks alors faire render
					frames ++; //compteurs de frames (img/s)
				}
				
								
				if (tick) update( ); //"tick" permet de normaliser la vitesse de rafraichissement (on normalise à 60 fps) -- onupdate le jeu 60 fois par seconde
				if (render) render ( ); //on veut le plus de fps possible avec render
				
				if (System.currentTimeMillis() - timer > 1000){
					timer += 1000; //remise à zéro
					Display.setTitle(title + " || Ticks :  " + ticks + "," + "Fps : " + frames);
					ticks = 0;
					frames = 0;
				}
			}
			exit( ); //on quitte le jeu
		}
		
	// problème lorsque je boucle la fenetre, vitesse de rafraichissement trop lent, on voit la fenetre clignoter au lieu de rester fixe
	// recherche d'une solution sur internet
		
		public void update( ){ //fait tous les calculs du jeu
			time ++;
		}
		
		
		public void render ( ){ //dessiner quelque chose à l'ecran
			view2D(width , height ); //taille de la fenetre 
			
			glClear(GL_COLOR_BUFFER_BIT);  //on enleve les residus du cube ! (sans ça, on le voit trainer)
			
			float [] color = new float []{0.5f, 0.8f, 0.1f, 1.0f};
			
			Renderer.renderQuad( 50 , 50 , 16 , 16 , color); //remplace tout ce qu'il y a ci-dessus
			
			/*   
			 * 		Si elles n'etaient pas statiques : 
			 * 		Renderer r = new Renderer();
			 * 		r.renderQuad(x,y,w,h);
			 */
		}
		
		
		
		public static void main (String [ ]  args) {
			Component main = new Component( ); //on ouvre la fenêtre
			
			main.start( ); //on appelle la boucle qui laisse ouvert la fenetre
			}
}
