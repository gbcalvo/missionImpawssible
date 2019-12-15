import javax.swing.*;
public class MapHandler implements Runnable{
		private Game game;
		private boolean iterate;
		private ImageIcon tile1;
		private ImageIcon tile2;
		public MapHandler(Game instance){
				game = instance;
				iterate = true;
				tile1 = new ImageIcon("assets/tile1.png");
				tile2 = new ImageIcon("assets/tile2.png");
				refresh();
		}
		//run will refresh the screen using the tile values and screen corner coordinates
		public void run(){
				while(iterate){
						refresh();
						try{
							Thread.sleep(10);
						}catch(Exception e){
								e.printStackTrace();
						}
				}
		}
		private void refresh(){
				for(int y = 0; y < 6; y++){
						for(int x = 0; x < 10; x++){
								if(y == game.playerY && x == game.playerX){
									continue;
								}
								loadIcon(game.screen[y][x], game.map[game.screenY+y][game.screenX+x].content);
						}
				}
		}
		public void end(){
				iterate = false;
		}
		public void loadIcon(JLabel label, int tileType){
				if(tileType == 1){
						label.setIcon(tile1);
				}
				else if(tileType == 2){	
						label.setIcon(tile2);
				}

		}

}