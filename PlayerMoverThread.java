import javax.swing.*;
public class PlayerMoverThread implements Runnable{
		private JLabel playerLabel;
		private char direction;
		private String charName;
		private ImageIcon state1;
		private ImageIcon state2;
		private ImageIcon state3;
		public PlayerMoverThread(JLabel player, char directionn, String character){
				playerLabel = player;
				direction  = directionn;
				charName = character;
				if(direction == 'w'){
						state1 = new ImageIcon("assets/"+character+"8.png");
						state2 = new ImageIcon("assets/"+character+"8.png");
						state3 = new ImageIcon("assets/"+character+"8.png");						

				}
				else if(direction == 'a'){
						state1 = new ImageIcon("assets/"+character+"1.png");
						state2 = new ImageIcon("assets/"+character+"2.png");
						state3 = new ImageIcon("assets/"+character+"3.png");
				}
				else if(direction == 's'){
						state1 = new ImageIcon("assets/"+character+"7.png");
						state2 = new ImageIcon("assets/"+character+"7.png");
						state3 = new ImageIcon("assets/"+character+"7.png");
				}
				else if(direction == 'd'){
						state1 = new ImageIcon("assets/"+character+"4.png");
						state2 = new ImageIcon("assets/"+character+"5.png");
						state3 = new ImageIcon("assets/"+character+"6.png");
				}

		}
		public void run(){
				try{
						Thread.sleep(100);
						playerLabel.setIcon(state1);
						move();
						Thread.sleep(100);
						playerLabel.setIcon(state2);
						move();
						Thread.sleep(100);
						playerLabel.setIcon(state3);
						move();
						Thread.sleep(100);
						playerLabel.setIcon(state1);
						move();
						Thread.sleep(100);
						playerLabel.setIcon(state2);
						move();

				}catch(Exception e){
						e.printStackTrace();
						
				}
		}
		private void move(){
				if(direction == 'w'){
						playerLabel.setLocation(playerLabel.getX(), playerLabel.getY()-20);
				}
				else if(direction == 's'){
						playerLabel.setLocation(playerLabel.getX(), playerLabel.getY()+20);
				}
				else if(direction == 'a'){
						playerLabel.setLocation(playerLabel.getX()-20, playerLabel.getY());
				}
				else if(direction == 'd'){
						playerLabel.setLocation(playerLabel.getX()+20, playerLabel.getY());
				}

		}
}