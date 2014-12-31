package com.kevant.main.game;

import com.kevant.main.Component;
import com.kevant.main.graphics.Renderer;

public class Game { // classe où on va s'occuper uniquement du Gameplay
	
	public Game() {
		
	}
	
	public void init() {
		
	}
	
	public void update(){
		
	}
	
	public void render() {
		for (int x = 0; x < Component.width/16; x++){ // si on ne divise pas par 16 alors 1 cube = 1 pixel donc on ne fait pas la distinction
			for (int y = 0; y < Component.height/16; y++){
				Renderer.renderQuad(x*17, y*17, 16, 16, new float [] {1, 0, 1, 1});
			}
		}
	}
	
}
