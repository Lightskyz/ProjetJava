package com.kevant.main.game;

import com.kevant.main.Component;
import com.kevant.main.game.level.Level;

public class Game { // classe où on va s'occuper uniquement du Gameplay
	
	Level level;
	
	public Game() {
		level = new Level (Component.width / 16, Component.height / 16);
	}
	
	public void init() {
		level.init();
	}
	
	public void update(){
		level.update();
	}
	
	public void render() {
		level.render();
	}
	
}

/* for (int x = 0; x < Component.width/16; x++){ // si on ne divise pas par 16 alors 1 cube = 1 pixel donc on ne fait pas la distinction
	for (int y = 0; y < Component.height/16; y++){
		Renderer.renderQuad(x*17, y*17, 16, 16, new float [] {1, 0, 1, 1}); */
