import javax.swing.*;
public class FrameHandler extends JFrame{
		private static JFrame frame;
		private static boolean unique = true;
		public FrameHandler(){
			initialize();
		}
		public JFrame getFrame(){
				return frame;
		}
		public void clearFrame(){
				frame.removeAll();
				frame.repaint();
				frame.revalidate();
		}
		private void initialize(){
				if(unique){
						frame = new JFrame("imong utot");
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



						frame.setBounds(1,1,1000,700);
						frame.setResizable(false);
						frame.setVisible(true);

						GameInstance instance = new GameInstance(frame);
				}
		}
}