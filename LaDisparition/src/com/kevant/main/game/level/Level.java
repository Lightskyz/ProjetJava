package com.kevant.main.game.level;

import java.util.ArrayList;
import java.util.List;

import com.kevant.main.game.level.tiles.Tile;
import com.kevant.main.game.level.tiles.Tile.Tiles;

public class Level {

	public int width, height;
	
	List<Tile> tiles = new ArrayList<Tile>(); //notre level est un tableau de tile (tuile)
	
	public Level(int width, int height) { //le level prend en argument la hauteur et la largeur de la fenetre
		this.width = width;
		this.height = height;
		
		generate();
	}
	
	public void generate(){
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				if(Math.random() >0.8f){ //génération aléatoire des tiles pour avoir des niveaux différents à chaque fois !
					tiles.add(new Tile(x,y, Tiles.COULOIR));
				}
				if (Math.random() > 0.95f){
				tiles.add(new Tile(x,y, Tiles.MUR));
			}
		}
	}
	}
	
	public void init() {
		
	}
	
	public void update(){
		
	}
	
	public void render() {
		for (Tile tile : tiles){ //equivalent de "foreach" en php
			tile.render(); //rend les tuiles visibles à l'ecran 
		}
	}
	

}
