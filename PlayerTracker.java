import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class PlayerTracker implements KeyListener{
		private Game game;
		static Thread moveThread;
		private PlayerMoverThread mover;
		private char direction;
		private String myPlayer; 
		public PlayerTracker(Game instance, String player){
				game = instance;
				myPlayer = player;
				game.playerX = 0;
				game.playerY = 3;
				mover = new PlayerMoverThread(game.player, 'w', player);
				moveThread = new Thread(mover);
				game.player.setIcon(new ImageIcon("assets/"+player+"4.png"));
				game.player.setBounds(0,300,100,100);
				game.player.repaint();
				game.player.validate();
		}
		public void keyPressed(KeyEvent e){
				if(!moveThread.isAlive()){
				if(e.getKeyCode() == 87){
						if(game.playerY > 0){
								if(game.map[game.screenY+game.playerY-1][game.screenX+game.playerX].content == 2){
									return;
								}

								direction = 'w';
								showPlayer();
								if(game.screenY > 0 && game.playerY <= 2){
										//scroll;
										game.screenY--;
										moveLabel(game.player.getX(),game.player.getY()+100);
								}
								else{
										game.playerY--;
								}
						}
				}
				else if(e.getKeyCode() == 65){
						if(game.playerX > 0){
								if(game.map[game.screenY+game.playerY][game.screenX+game.playerX-1].content == 2){
									return;
								}

								direction = 'a';
								showPlayer();
								if(game.screenX > 0 && game.playerX < 6){
										//scroll;
										game.screenX--;
										moveLabel(game.player.getX()+100,game.player.getY());
								}
								else{
										game.playerX--;
								}
						}
				}
				else if(e.getKeyCode() == 83){	
						if(game.playerY < 5){
								if(game.map[game.screenY+game.playerY+1][game.screenX+game.playerX].content == 2){
									return;
								}

								direction = 's';
								showPlayer();
								if(game.screenY < 12 && game.playerY > 2){
										//scroll;
										game.screenY++;
										moveLabel(game.player.getX(),game.player.getY()-100);
								}
								else{
										game.playerY++;

								}
						}

				}
				else if(e.getKeyCode() == 68){	
						if(game.playerX < 9){
								if(game.map[game.screenY+game.playerY][game.screenX+game.playerX+1].content == 2){
									return;
								}

								direction = 'd';
								showPlayer();
								if(game.screenX < 20 && game.playerX >4){
										//scroll;
										game.screenX++;
										moveLabel(game.player.getX()-100,game.player.getY());
								}
								else{
										game.playerX++;
										
								}
						}
				}
				}
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			
		}
		private void showPlayer(){
				//turn this into thread plz
				if(!moveThread.isAlive()){
						mover = new PlayerMoverThread(game.player, direction, myPlayer);
						moveThread = new Thread(mover);						
						moveThread.start();
						game.player.setVisible(true);
						game.player.repaint();
						game.player.validate();
				}				
		}
		private void moveLabel(int x, int y){
				game.player.setLocation(x,y);
		}

}