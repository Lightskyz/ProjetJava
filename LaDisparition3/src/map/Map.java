package map;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;

/* 
 * 	import map.tiles.Tile;
*	import java.util.List; 	
*/
//Ma map ou je recupere toutes les cases une par une

public class Map {
	private int [][] map;
	private BufferedImage tileSheet;
		
	public Map (int [][] existingMap){
		map = new int [existingMap.length][existingMap[0].length];
		
		for (int y = 0; y < map.length; y++){
			for (int x = 0; x < map[y].length; x++){
				map[y][x] = existingMap[y][x];
		}
	}
		tileSheet = LoadTileSheet("lol");
	}
	
	public Map(int width, int height){
		map = new int [height][width];
	}
	
	public static Map FromFile (String fileName) {
		
		Map layer = null;
		ArrayList<ArrayList<Integer>> tempLayout = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader (new FileReader (fileName))){
			String currentLine;
			
			while ((currentLine = br.readLine()) != null)
			{
				if (currentLine.isEmpty())
					continue;
				
				ArrayList<Integer> row = new ArrayList <>();
				
				String[] values = currentLine.trim().split(";");
				
				for (String string : values){
					if (!string.isEmpty()){
						int id = Integer.parseInt(string);
					
						row.add(id);
					}
				}
				tempLayout.add(row);
				
			}
		}
		catch (IOException e){
			
		}
		
		int width = tempLayout.get(0).size();
		int height = tempLayout.size();
		
		layer = new Map(width,height);
		
		for (int y = 0; y < height ; y ++){
			for (int x = 0 ; x < width ; x++){
				layer.map [y][x] = tempLayout.get(y).get(x);
			}
		}
		
		layer.tileSheet = layer.LoadTileSheet("lol");
		
		return layer;
		
	}
	
	public BufferedImage LoadTileSheet(String fileName){
		BufferedImage img = null;
		
		try{
			img = ImageIO.read(new File(fileName));
		}
		catch(IOException e){
			
		}
		return img;
	}
	
	
}



//ce que je cherche ˆ faire : 
/*
 * For(int i=0; i<listcase.lenght;i++) (je fais une liste comme quoi 0 c'est a, 1 etc...)

	Draw.square(listcase[i].x,listcase[i].y,listcase[i].color)
 * 
 * 
 * 
 * 
 */
