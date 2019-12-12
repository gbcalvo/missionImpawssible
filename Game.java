import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Game implements KeyListener{
		int mapSizeX = 30;
		int mapSizeY = 18;
		Tile[][] map = new Tile[mapSizeY][mapSizeX];
		ImageIcon playerIcon;

		JLabel[][] screen = new JLabel[6][10];
		int screenX = 0;
		int screenY = 0; 
		int playerX = 0;
		int playerY = 3;
		public Game(){
				
				playerIcon = new ImageIcon("assets/puggy25.png");

				FrameHandler handler = new FrameHandler();
				handler.clearFrame();
				handler.frame.addKeyListener(this);


				JPanel gamePanel = new JPanel();
				gamePanel.setLayout(null);
				gamePanel.setBounds(1,1,1000,700);

				//intialize screen for game
				int posX =0;
				int posY =0;
				for(int y =0; y < 6; y++){
						for(int x =0; x < 10; x++){
								screen[y][x] = new JLabel(""+x+y);
								screen[y][x].setBounds(posX,posY, 100,100);
								if((y+x) % 2 == 0){
										screen[y][x].setBackground(Color.PINK);
								}
								else{
										screen[y][x].setBackground(Color.YELLOW);
								}
								screen[y][x].setOpaque(true);
								gamePanel.add(screen[y][x]);
								posX +=100;
						}
						posX = 0;
						posY +=100;
				}


				//intialize map
				for(int y =0; y < mapSizeY; y++){
						for(int x =0; x < mapSizeX; x++){
								map[y][x] = new Tile(2);
						}
				}

				movePlayer();
				gamePanel.setVisible(true);

				handler.setFrame(gamePanel);
				handler.frame.requestFocus();


				
				
				

				
		}
		private void movePlayer(){
				refresh();
				screen[playerY][playerX].setIcon(playerIcon);
				screen[playerY][playerX].repaint();
		}
		private void refresh(){
				for(int y = 0; y < 6; y++){
						for(int x =0; x < 10;x++){
								screen[y][x].setText(""+map[screenY+y][screenX+x].content);
								screen[y][x].setIcon(null);
						}
				}
		}
		private void scroll(){
				refresh();				
		}
		public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==87){
						if(playerY > 0){
								playerY--;
								movePlayer();
								if(playerY < 3 && screenY > 0){
									screenY--;
									refresh();
									playerY++;
									movePlayer();
								}
						}
				}
				if(e.getKeyCode()==65){
						if(playerX > 0){
								playerX--;
								movePlayer();
								if(playerX < 5 && screenX > 0){
									screenX--;
									refresh();
									playerX++;
									movePlayer();
								}
						}
				}
				if(e.getKeyCode()==83){
						if(playerY < 5){
								playerY++;
								movePlayer();
								if(playerY >3 && screenY + 6 <mapSizeY){

									screenY++;
									refresh();
									playerY--;
									movePlayer();
								}
						}
				}
				if(e.getKeyCode()==68){
						if(playerX < 9){
								playerX++;
								movePlayer();
								if(playerX >6 && screenX + 10 <mapSizeX){
									screenX++;
									refresh();
									playerX--;
									movePlayer();
								}
						}
				}
		}
		public void keyReleased(KeyEvent e){
			
		}
		public void keyTyped(KeyEvent e){
			
		}
}