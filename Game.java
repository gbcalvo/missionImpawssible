import javax.swing.*;
import java.io.*;
public class Game{
		JLabel[][] screen;
		JLabel player;
		Tile[][] map;

		int screenX;
		int screenY;
		int playerX;
		int playerY;
		public Game(int level){
				player = new JLabel();
				player.setBounds(0,300,100,100);
				screenX = 0;
				screenY = 0;
				playerX = 0;
				playerY = 3;

				String levell = "levels/Level"+level+".txt";

				MapGenerator mapGen = new MapGenerator();
				File file = new File(levell);

				map = mapGen.generateMap(file);


				screen = new JLabel[6][10];
				for(int y = 0; y < 6; y++){
						for(int x = 0; x < 10; x++){
								screen[y][x] = new JLabel(""+map[y][x].content);
						}
				}
		}
}