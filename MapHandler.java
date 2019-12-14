import javax.swing.*;
public class MapHandler implements Runnable{
		private JLabel[][] screen;
		private Tile[][] tiles;
		private int screenX;
		private int screenY;
		private Game game;
		public MapHandler(Game instance){
				game = instance;
				screen = game.screen;
				tiles = game.map;
				screenY = game.screenY;
				screenX = game.screenX;
				refresh();
		}
		//run will refresh the screen using the tile values and screen corner coordinates
		public void run(){
				while(true){

						refresh();
						try{
							Thread.sleep(1000);
						}catch(Exception e){
								e.printStackTrace();
						}
				}
		}
		private void refresh(){
				for(int y = 0; y < 6; y++){
						for(int x = 0; x < 10; x++){
								screen[y][x].setText(""+tiles[screenY+y][screenX+x]);
						}
				}
		}

}