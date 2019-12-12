import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
public class GameInstance{
		private JFrame frame;
		private static boolean unique = true;
		private int state;
		public GameInstance(JFrame framee){
				if(unique){
						//display intro on thread

						//display MainMenu
						frame = framee;
						mainMenu();
						
				}
			
		}

		private void mainMenu(){
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBounds(1,1,10,10);

				ImageIcon imageIcon = new ImageIcon("Homescreen.png");
				JLabel bg = new JLabel(imageIcon);
				bg.setBounds(1,1,1000,700);


				Border raisedBorder = BorderFactory.createRaisedBevelBorder();

				JButton play = new JButton("play");
				JButton howToPlay = new JButton("how to play");
				JButton aboutUs = new JButton("about us");

				play.setBounds(650,320,240, 65);
				howToPlay.setBounds(650,400,240, 65);
				aboutUs.setBounds(650, 480,240,65);

				play.setBorder(raisedBorder);
				howToPlay.setBorder(raisedBorder);
				aboutUs.setBorder(raisedBorder);

				play.setBackground(Color.PINK);
				howToPlay.setBackground(Color.PINK);
				aboutUs.setBackground(Color.PINK);



				panel.setBackground(Color.PINK);
				panel.add(play);
				panel.add(howToPlay);
				panel.add(aboutUs);
				panel.add(bg);
				frame.add(panel);

				frame.repaint();
				frame.revalidate();

		}
		private void levelSelect(){

		}

		private void helpScreen(){

		}

}