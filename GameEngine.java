import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
public class GameEngine{
		static ObstacleHandler obstacleHandler;
		static MapHandler mapHandler;
		private ImageIcon playerIcon;
		public GameEngine(){
				playerIcon = new ImageIcon("assets/puggy25.png");


				FrameHandler frameHandler = new FrameHandler();
				frameHandler.clearFrame();

				Game game = new Game();

				JPanel gamePanel = new JPanel();
				gamePanel.setLayout(null);
				gamePanel.setBounds(1,1,1000,700);


				Border raisedBorder = BorderFactory.createRaisedBevelBorder();
				Font font = new Font("Arial", Font.PLAIN, 20);
				JButton mainMenu = new JButton("Back to level selection");
				mainMenu.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent evt){
								LevelSelector ls = new LevelSelector();
								ls.show();
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
				game.screen[3][0].setIcon(playerIcon);
				game.screen[3][0].repaint();




				//set Visible
				gamePanel.setVisible(true);

				frameHandler.setFrame(gamePanel);
				frameHandler.frame.requestFocus();


				//start threads
				PlayerTracker playerTracker = new PlayerTracker(game, playerIcon);
				frameHandler.frame.addKeyListener(playerTracker);
				
				obstacleHandler = new ObstacleHandler(game);
				mapHandler = new MapHandler(game);

				//FrameHandler frameHandler = new FrameHandler();
				Thread obstacles = new Thread(obstacleHandler);
				Thread refresher = new Thread(mapHandler);

				obstacles.start();
				refresher.start();


				//mapHandler- will handle refreshing screen on a thread
				//obstacleHandler - will handle the tile contents
				//playerTracker - will track player movement and check collisions, also scrolls the map
		}
		public static void end(){
				obstacleHandler.end();
				mapHandler.end();
				System.out.println("finish na");
		}
}