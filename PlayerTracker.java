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
								if(game.map[game.playerY+1+game.screenY][game.playerX+game.screenX].content != 2){
										game.playerY--;
										if(checkCollision()){
												return;
										}
										else{
												if(game.playerY < 3 && game.screenY > 0){
														//scroll up;
														game.screenY--;
														game.playerY++;
												}
										}
										showPlayer(game.screen[game.playerY][game.playerX]);
										System.out.println("up!" + game.playerX+game.playerY);
								}
						}
				}
				else if(e.getKeyCode() == 65){
						if(game.playerX > 0){
								if(game.map[game.playerY+game.screenY][game.playerX-1+game.screenX].content != 2){
										game.playerX--;
										if(checkCollision()){
												return;
										}
										else{
												if(game.playerX > 5 && game.screenX > 0){
														//scroll up;
														game.screenX--;
														game.playerX++;
												}
										}
										showPlayer(game.screen[game.playerY][game.playerX]);
										System.out.println("left!" + game.playerX+game.playerY);
								}
						}
				}
				else if(e.getKeyCode() == 83){
						if(game.playerY < 5){
								if(game.map[game.playerY+game.screenY+1][game.playerX+game.screenX].content != 2){
										game.playerY++;
										if(checkCollision()){
												return;
										}
										else{
												if(game.playerY > 3 && game.screenY < 9){
														//scroll up;
														game.screenY++;
														game.playerY--;
												}
										}
										showPlayer(game.screen[game.playerY][game.playerX]);
										System.out.println("down!" + game.playerX+game.playerY);
								}
						}

				}
				else if(e.getKeyCode() == 68){
						if(game.playerX > 0){
								if(game.map[game.playerY+game.screenY][game.playerX+game.screenX+1].content != 2){
										game.playerX++;
										if(checkCollision()){
												return;
										}
										else{
												if(game.playerX > 4 && game.screenX > 0){
														//scroll up;
														game.screenX++;
														game.playerX--;
												}
										}
										showPlayer(game.screen[game.playerY][game.playerX]);
										System.out.println("right!" + game.playerX+game.playerY);
								}
						}

				}
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			
		}
		private boolean checkCollision(){
					if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 3){
						return true;
					}
					else if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 4){
						return true;
					}
					else if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 6){
						return true;
					}
					else if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 7){
						return true;
					}
					else if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 9){
						return true;
					}
					else if(game.map[game.playerY+game.screenY][game.playerX+game.screenX].content == 10){
						GameEngine.end();
						return false;
					}
					else{
						return false;
					}
		}
		private void showPlayer(JLabel label){
				label.setIcon(playerIcon);
		}

}