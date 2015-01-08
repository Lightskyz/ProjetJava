package com.kevant.main.game.level.tiles;

//import java.util.Random;

import com.kevant.main.graphics.Renderer;
import com.kevant.main.graphics.Texture;
import static org.lwjgl.opengl.GL11.*;

public class Tile { //tuile du jeu pour pouvoir structurer notre niveau 
	
	public int x,y; //position des tuiles
	int xo = 0, yo = 0;
	boolean hasTileSet = false;
	public int size = 16; //taille des tuiles
	public int halfSize = size/2;//taille de la texture
	public int [] tileSprite;// = new int  []{1,1,1,1,1,1,1,1};
	
	
	float [] color = new float []{1,1,1,1};
	
	//Random random = new Random();
	Tiles tile;
	
	public enum Tiles { // 2 types de tuiles : couloir, mur
		BG_COULOIR, SOLID_MUR
	}
	
	public Tile(int x, int y, Tiles tile){
		this.x = x;
		this.y = y;
		this.tile = tile;
		tileSprite = new int [8];
		
		if (tile == Tiles.SOLID_MUR) {
			xo = 0;//couleur des couloirs
			yo =0;
			hasTileSet = true;
		}
		else if (tile == Tiles.BG_COULOIR) {
			xo = 3;
			yo = 2;//couleur des murs
		}
		//color = new float []{random.nextFloat(),random.nextFloat(),random.nextFloat(),1}; //donner une couleur aleatoire lorsqu'on afficher des toiles au hasard
	}
	
	public void setTiles(boolean vr,boolean vl,boolean vd,boolean vu,boolean vur,boolean vul,boolean vdr,boolean vdl){
		if (hasTileSet)return;
	}
	
	public void render(){
		Texture.tiles.bind();
			glBegin(GL_QUADS);
				Renderer.quadData(x*size, y*size, halfSize, halfSize, color, xo + tileSprite[0], yo + tileSprite[1]); //les tuiles sont des carrées qu'on rend
				Renderer.quadData(x*size +8 , y*size, halfSize, halfSize, color, xo + tileSprite[2], yo + tileSprite[3]);
				Renderer.quadData(x*size +8 , y*size +8 , halfSize, halfSize, color, xo + tileSprite[4], yo + tileSprite[5]);
				Renderer.quadData(x*size, y*size +8, halfSize, halfSize, color, xo + tileSprite[6], yo + tileSprite[7]);
			glEnd();
		Texture.tiles.unbind();
	}
}
