import javax.swing.*;
import java.io.*;
public class Game{
		JLabel[][] screen;
		Tile[][] map;
		int screenX;
		int screenY;
		public Game(){
				MapGenerator mapGen = new MapGenerator();
				File file = new File("Level1.txt");

				map = mapGen.generateMap(file);


				screen = new JLabel[6][10];
				for(int y = 0; y < 6; y++){
						for(int x = 0; x < 10; x++){
								screen[y][x] = new JLabel(""+map[y][x]);
						}
				}
				screenX = 0;
				screenY = 0;
		}
}