import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class PlayerTracker implements KeyListener{
		private Game game;
		private ImageIcon playerIcon;
		public PlayerTracker(Game instance, ImageIcon icon){
				game = instance;
				game.playerX = 0;
				game.playerY = 3;
				playerIcon = icon;
		}
		public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == 87){
						if(game.playerY > 0){
								if(game.map[game.screenY+game.playerY-1][game.screenX+game.playerX].content == 2){
									return;
								}
								if(game.screenY > 0 && game.playerY <= 2){
										//scroll;
										game.screenY--;
								}
								else{
										game.playerY--;
										showPlayer();

								}
						}
				}
				else if(e.getKeyCode() == 65){
						if(game.playerX > 0){
								if(game.map[game.screenY+game.playerY][game.screenX+game.playerX-1].content == 2){
									return;
								}
								if(game.screenX > 0 && game.playerX < 6){
										//scroll;
										game.screenX--;
								}
								else{
										game.playerX--;
										showPlayer();

								}
						}
				}
				else if(e.getKeyCode() == 83){	
						if(game.playerY < 5){
								if(game.map[game.screenY+game.playerY+1][game.screenX+game.playerX].content == 2){
									return;
								}
								if(game.screenY < 12 && game.playerY > 2){
										//scroll;
										game.screenY++;
								}
								else{
										game.playerY++;
										showPlayer();

								}
						}

				}
				else if(e.getKeyCode() == 68){	
						if(game.playerX < 9){
								if(game.map[game.screenY+game.playerY][game.screenX+game.playerX+1].content == 2){
									return;
								}
								if(game.screenX < 20 && game.playerX >4){
										//scroll;
										game.screenX++;
								}
								else{
										game.playerX++;
										showPlayer();
								}
						}
				}
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			
		}
		private void showPlayer(){
				game.screen[game.playerY][game.playerX].setIcon(playerIcon);
		}

}