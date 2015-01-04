package com.kevant.main.game.level.tiles;

//import java.util.Random;

import com.kevant.main.graphics.Renderer;

public class Tile { //tuile du jeu pour pouvoir structurer notre niveau 
	
	public int x,y; //position des tuiles
	public int size = 16; //taille des tuiles
	
	float [] color;
	
	//Random random = new Random();
	Tiles tile;
	
	public enum Tiles { // 2 types de tuiles : couloir, mur
		COULOIR, MUR
	}
	
	public Tile(int x, int y, Tiles tile){
		this.x = x;
		this.y = y;
		this.tile = tile;
		
		if (tile == Tiles.COULOIR) color = new float [] {1, 1, 1, 1}; //couleur des couloirs
		if (tile == Tiles.MUR) color = new float [] {0, 0, 0, 1}; //couleur des murs
		//color = new float []{random.nextFloat(),random.nextFloat(),random.nextFloat(),1}; //donner une couleur aleatoire lorsqu'on afficher des toiles au hasard
	}
	
	public void render(){
		Renderer.renderQuad(x*size, y*size, size, size, color); //les tuiles sont des carrées qu'on rend
	}
}
