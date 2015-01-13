package com.kevant.main.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.Display;

import com.kevant.main.Component;
import com.kevant.main.game.level.tiles.Tile;
import com.kevant.main.game.level.tiles.Tile.Tiles;

public class Level {

	public int width, height;
	
	List<Tile> tiles = new ArrayList<Tile>(); //notre level est un tableau de tile (tuile)
	Tile [][] solidTile;//tuiles solides (mur)
	Tile [][] bgTile;//bg : background -> fond d'ecran de notre jeu
	
	private int [] bounds = new int [4];//les 4 cotes de notre ecran
	
	public Level(int width, int height) { //le level prend en argument la hauteur et la largeur de la fenetre
		
		loadLevel ("level_dispa");
	}
	
	public void loadLevel (String name) {
		int [] pixels; //on fait un tableau de pixels de cette image
		BufferedImage image = null;//puis on va la chercher/recuperer
		try{
		image = ImageIO.read(Level.class.getResource("/levels/" + name + ".png"));
		} catch (IOException e){
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		
		bounds[0]=-16;
		bounds[1]=-16;
		bounds[2]=-width*16 + 16 + Display.getWidth() / Component.scale;
		bounds[3]=-height*16 + 16 + Display.getHeight() / Component.scale;
		
		
		pixels = new int [width * height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
		
		solidTile = new Tile [width] [height];
		bgTile = new Tile [width] [height];
		
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				if (pixels [x + y * width] == 0xFFffffff){//[x + y * width] nous permet de naviguer dans l'image, ici on met une condition quand l'image est blanche
					solidTile[x][y]=new Tile (x,y, Tiles.SOLID_MUR);//si l'image est blanche alors mettre la texture du mur
				}
				if (pixels [x + y * width] == 0xFF000000){//[x + y * width] nous permet de naviguer dans l'image, ici on met une condition quand l'image est blanche
					bgTile[x][y]=new Tile (x,y, Tiles.BG_COULOIR);//si l'image est blanche alors mettre la texture du mur
				}
			if (	pixels[x + y * width] == 0xFF4157a7 || //couleur de spawn du garde et du joueur
					pixels[x + y * width] == 0xFFee1f34){
				bgTile[x][y]=new Tile (x,y, Tiles.BG_COULOIR);
				}
			
			// Si cela marché ne pas oublier aussi les lampes !
			}
		}
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
				addTiles (x,y);
			}
		}
	}
		/*for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				if (solidTile[x][y] != null){
				tiles.add(solidTile[x][y]);
				//tiles.add(bgTile[x][y]);
				}*/
				/*	if(Math.random() >0.8f){ //génération aléatoire des tiles pour avoir des niveaux différents à chaque fois !
					tiles.add(new Tile(x,y, Tiles.COULOIR));
				}
				if (Math.random() > 0.95f){
				tiles.add(new Tile(x,y, Tiles.MUR));
			} 
				
		} 
	}*/
	
	public void addTiles(int x, int y){
		if (solidTile[x][y] != null){
			tiles.add(solidTile[x][y]);
			}
		else if(bgTile[x][y] != null) {
			tiles.add(bgTile[x][y]);
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
	
	public int getBounds(int index){
		return bounds[index];
	}

}
