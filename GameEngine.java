import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.*;
public class GameEngine{
		static ObstacleHandler obstacleHandler;
		static MapHandler mapHandler;
		static GameOverThread gameOver;
		private static String myPlayer;
		private Game game;
		private static int level;
		private static PlayerTracker playerTracker;
		private static  FrameHandler frameHandler;
		public GameEngine(int levell, String player){
				myPlayer = player;
				level = levell;


				frameHandler = new FrameHandler();
				frameHandler.clearFrame();

				game = new Game(level);

				obstacleHandler = new ObstacleHandler(game);
				mapHandler = new MapHandler(game);
				gameOver = new GameOverThread(game);


				Thread obstacles = new Thread(obstacleHandler);
				Thread refresher = new Thread(mapHandler);
				Thread gameOverChecker  = new Thread(gameOver);

				obstacles.start();
				refresher.start();
				gameOverChecker.start();
				
				game.player.setIcon(new ImageIcon("assets/"+player+"4.png"));
				game.player.repaint();
				game.player.validate();



				JPanel gamePanel = new JPanel();
				gamePanel.setLayout(null);
				gamePanel.setBounds(1,1,1000,700);

				playerTracker = new PlayerTracker(game, myPlayer);

				gamePanel.add(game.player);



				Border raisedBorder = BorderFactory.createRaisedBevelBorder();
				Font font = new Font("Arial", Font.PLAIN, 20);
				JButton mainMenu = new JButton("Back to level selection");
				mainMenu.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent evt){
								LevelSelector ls = new LevelSelector();
								ls.show();
								end();
						}
				});
				mainMenu.setBounds(795,600,200,75);
				mainMenu.setBorder(raisedBorder);
				mainMenu.setBackground(Color.PINK);
				mainMenu.setFont(font);
				gamePanel.add(mainMenu);


				//intialize screen for game
				int posX =0;
				int posY =0;
				for(int y =0; y < 6; y++){
						for(int x =0; x < 10; x++){
								game.screen[y][x] = new JLabel(""+x+y);
								game.screen[y][x].setBounds(posX,posY, 100,100);
								if((y+x) % 2 == 0){
										game.screen[y][x].setBackground(Color.PINK);
								}
								else{
										game.screen[y][x].setBackground(Color.YELLOW);
								}
								game.screen[y][x].setOpaque(true);
								gamePanel.add(game.screen[y][x]);
								posX +=100;
						}
						posX = 0;
						posY +=100;
				}




				//set Visible
				gamePanel.setVisible(true);

				frameHandler.setFrame(gamePanel);
				frameHandler.frame.requestFocus();


				//start threads
				
				frameHandler.frame.addKeyListener(playerTracker);
				
				

				//FrameHandler frameHandler = new FrameHandler();



				//mapHandler- will handle refreshing screen on a thread
				//obstacleHandler - will handle the tile contents
				//playerTracker - will track player movement and check collisions, also scrolls the map
		}
		public static void end(){
				obstacleHandler.end();
				mapHandler.end();
				gameOver.end();
				frameHandler.frame.removeKeyListener(playerTracker);
				new GameEngine(level, myPlayer);
		}
		public void restart(){
				game = new Game(level);
				System.out.println("utrooooo");
		}
}