package com.kevant.main.game.level;

import java.util.ArrayList;
import java.util.List;

import com.kevant.main.game.level.tiles.Tile;
import com.kevant.main.game.level.tiles.Tile.Tiles;

public class Level {

	public int width, height;
	
	List<Tile> tiles = new ArrayList<Tile>(); //notre level est un tableau de tile (tuile)
	Tile [][] solidTile;//tuiles solides (mur)
	Tile [][] bgTile;//bg : background -> fond d'ecran de notre jeu
	
	public Level(int width, int height) { //le level prend en argument la hauteur et la largeur de la fenetre
		this.width = width;
		this.height = height;
		solidTile = new Tile [width] [height];
		bgTile = new Tile [width] [height];
		
		
		setTiles();
	}
	
	public void setTiles(){
		for (int x=0; x < width -15; x++){
			for (int y=0; x < height -15; y++){ 
					/*if (Math.random() > 0.8 ){
					solidTiles[x][y] = new Tile (x,y, Tiles.COULOIR);
					if (Math.random() > 0.9 ){
						solidTiles[x][y] = new Tile (x,y, Tiles.MUR);
					}
				} */
				if (x-1 < 0 || y -1 < 0 || x+1 >= width || y + 1 >= height) continue;
				boolean vu = false, vd= false, vl= false, vr= false;
				boolean vur= false, vdr= false, vul= false, vdl= false;
				
				
				if (solidTile[ x +1 ][y] == null){
					vr = true;
				}
				if (solidTile[ x - 1 ][y] == null){
					vl = true;
				}
				if (solidTile[ x][y +1 ] == null){
					vd = true;
				}
				if (solidTile[ x][ y - 1] == null){
					vu = true;
				}
				//
				
				if (solidTile[ x +1 ][y +1 ] == null){
					vdr = true;
				}
				if (solidTile[ x - 1 ][y -1] == null){
					vul = true;
				}
				if (solidTile[ x -1] [y +1 ] == null){
					vdl = true;
				}
				if (solidTile[ x +1][ y - 1] == null){
					vur = true;
				}
				
				if (solidTile[x][y] != null){
					solidTile[x][y].setTiles(vr, vl, vd, vu, vur, vul, vdr, vdl);
				}
			}
		}
		
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				tiles.add(solidTile[x][y]);
				tiles.add(bgTile[x][y]);
				
		
				/*	if(Math.random() >0.8f){ //génération aléatoire des tiles pour avoir des niveaux différents à chaque fois !
					tiles.add(new Tile(x,y, Tiles.COULOIR));
				}
				if (Math.random() > 0.95f){
				tiles.add(new Tile(x,y, Tiles.MUR));
			} */
				
		} 
	}
	}
	
	public void addTiles(int x, int y){
		
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
