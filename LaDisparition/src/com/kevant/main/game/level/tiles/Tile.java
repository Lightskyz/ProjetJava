package com.kevant.main.game.level.tiles;

//import java.util.Random;

import com.kevant.main.graphics.Renderer;
import com.kevant.main.graphics.Texture;
import static org.lwjgl.opengl.GL11.*;

public class Tile { //tuile du jeu pour pouvoir structurer notre niveau 
	
	public int x,y; //position des tuiles
	int xo = 0, yo = 0;
	public int size = 16; //taille des tuiles
	
	float [] color = new float []{1,1,1,1};
	
	//Random random = new Random();
	Tiles tile;
	
	public enum Tiles { // 2 types de tuiles : couloir, mur
		COULOIR, MUR
	}
	
	public Tile(int x, int y, Tiles tile){
		this.x = x;
		this.y = y;
		this.tile = tile;
		
		if (tile == Tiles.COULOIR) yo = 0;//couleur des couloirs
		if (tile == Tiles.MUR) yo = 1; //couleur des murs
		//color = new float []{random.nextFloat(),random.nextFloat(),random.nextFloat(),1}; //donner une couleur aleatoire lorsqu'on afficher des toiles au hasard
	}
	
	public void render(){
		Texture.tiles.bind();
			glBegin(GL_QUADS);
				Renderer.quadData(x*size, y*size, size, size, color, xo, yo); //les tuiles sont des carrées qu'on rend
			glEnd();
		Texture.tiles.unbind();
	}
}
