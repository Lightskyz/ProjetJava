package com.kevant.main.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

public class Texture {
	
	public static Texture tiles = loadTexture("/textures/textures.png");
	
	int width, height; //taille de la texture
	int id;

	public Texture (int width, int height, int id){ //constructeur
		this.width = width;
		this.height = height;
		this.id = id;
	}
	public static Texture loadTexture(String path){//on indique le chemin de la texture --> fonction qui permet de charger la texture
		//pour qu'on puisse recuperer la texture partout ('static') et ne la charger qu'une seule fois
		BufferedImage image = null;
		try{
			image = ImageIO.read(Texture.class.getResource(path));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		int [] pixels = new int [w * h];
		image.getRGB(0, 0, w, h, pixels, 0, w);
		
		ByteBuffer buffer = BufferUtils.createByteBuffer (w * h * 4);// buffer = memoire tampon, elle permet de stocké les bytes de couleur temporairement
		
		for (int x = 0; x < w; x++){ //permet de remplir le buffer par les pixels
			for (int y = 0; y<h; y++){
				int i = pixels[x + y *w]; 
				buffer.put((byte) ((i >> 16) & 0xFF)); //R --> on va chercher dans les pixels, un multiple de 16 (>> = multiple)
				buffer.put((byte) ((i >> 8) & 0xFF)); //G
				buffer.put((byte) ((i) & 0xFF)); //B
				buffer.put((byte) ((i >> 24) & 0xFF)); //Alpha (opacité)
			}
		}
		
		buffer.flip();//on remplit notre buffer
		
		int id = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, id);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);//nous permet de placer la texture
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, w , h , 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		
		return new Texture(w, h, id);
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void bind(){
		glBindTexture(GL_TEXTURE_2D, id);
	}
	public void unbind(){
		glBindTexture(GL_TEXTURE_2D, 0); //on reset le bind
	}
}
