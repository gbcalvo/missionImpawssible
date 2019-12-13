import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class LevelSelector{
		private static FrameHandler handler;
		private static JPanel panel;
		public LevelSelector(){
				handler = new FrameHandler();

				panel = new JPanel();
				panel.setLayout(null);
				panel.setBounds(1,1,1000,700);

				ImageIcon imageIcon = new ImageIcon("assets/backdrop.jpg");
				JLabel bg = new JLabel(imageIcon);
				bg.setBounds(1,1,1000,700);
				

				Border raisedBorder = BorderFactory.createRaisedBevelBorder();
				Font font = new Font("Arial", Font.PLAIN, 20);
				JButton[] levels = new JButton[9];
				int posX = 175;
				int posY = 100;
				for(int x = 0; x< levels.length; x++){
						levels[x] = new JButton(""+(x+1));
						levels[x].setBorder(raisedBorder);
						levels[x].setBounds(posX,posY,100, 100);
						levels[x].setBackground(Color.PINK);
						levels[x].setFont(font);
						posX+= 250;
						if((x+1) % 3 == 0){
							posX = 175;
							posY +=150;
						}
						panel.add(levels[x]);
				}

				JButton mainMenu = new JButton("Back");
				
				mainMenu.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent evt){
								MainMenu temp = new MainMenu();
								temp.show();
						}
				});  
				mainMenu.setBounds(849,549,150,150);
				mainMenu.setBorder(raisedBorder);
				mainMenu.setBackground(Color.PINK);
				mainMenu.setFont(font);

				panel.add(mainMenu);
				panel.add(bg);


				
		}
		public void show(){
				handler.setFrame(panel);
		}
}