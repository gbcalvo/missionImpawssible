import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.border.Border;
public class MainMenu{
		private static FrameHandler handler;
		private static JPanel panel;
		public MainMenu(){
				
				//handler.clearFrame();

				handler = new FrameHandler();
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBounds(1,1,1000,700);

				ImageIcon imageIcon = new ImageIcon("assets/Homescreen.png");
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

				play.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent evt){
								LevelSelector ls = new LevelSelector();
								ls.show();
						}
				});



				panel.setBackground(Color.PINK);
				panel.add(play);
				panel.add(howToPlay);
				panel.add(aboutUs);
				panel.add(bg);

				//handler.setFrame(panel);
		}
		public void show(){
				handler.setFrame(panel);
		}
}