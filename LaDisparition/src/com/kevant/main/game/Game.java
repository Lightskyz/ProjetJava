package com.kevant.main.game;

import org.lwjgl.opengl.GL11;

import com.kevant.main.game.level.Level;

public class Game { // classe où on va s'occuper uniquement du Gameplay
	
	Level level;
	
	public static float xScroll, yScroll;
	
	public Game() {
		level = new Level (64,64);
		xScroll = level.getBounds(0);
		yScroll = level.getBounds(1);
	}
	
	public void translateView(float xa, float ya){
		if (xScroll > level.getBounds(0) || xScroll < level.getBounds(2)
				|| yScroll > level.getBounds(1) || yScroll < level.getBounds(3)){
			return;
		}
			xScroll += xa;
			yScroll += ya;
	}
	
	public void init() {
		level.init();
	}
	
	
	float xa = 1, ya = 1;
	public void update(){
		if (xScroll == level.getBounds(0) || xScroll == level.getBounds(2)){
			xa = -xa;
		}
		if (yScroll == level.getBounds(0) || yScroll == level.getBounds(2)){
			ya = -ya;
		}
		translateView(xa, ya);
		level.update();
	}
	
	public void render() {
		GL11.glTranslatef(xScroll, yScroll, 0);
		level.render();
	}
	
}

/* for (int x = 0; x < Component.width/16; x++){ // si on ne divise pas par 16 alors 1 cube = 1 pixel donc on ne fait pas la distinction
	for (int y = 0; y < Component.height/16; y++){
		Renderer.renderQuad(x*17, y*17, 16, 16, new float [] {1, 0, 1, 1}); */
