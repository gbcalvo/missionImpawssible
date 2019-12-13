import javax.swing.*;
import java.awt.Color;
public class FrameHandler{
		static JFrame frame;
		private static JPanel panel;
		private static boolean unique = true;
		public FrameHandler(){
			initialize();
			unique = false;
		}
		public void clearFrame(){
				frame.remove(panel);
		}
		private void initialize(){
				if(unique){
						frame = new JFrame();
						frame.setLayout(null);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setBounds(1,1,1000,700);
						frame.setResizable(false);
						frame.setVisible(true);


						panel = new JPanel();
						panel.setLayout(null);
						panel.setBounds(1,1,1000,700);
						frame.add(panel);
						frame.repaint();
						frame.revalidate();
						unique = false;
				}
		}
		public void setFrame(JPanel panell){
				if(panel != null){
						clearFrame();
				}
				panel = panell;
				frame.add(panell);
				frame.repaint();
				frame.revalidate();	
		}
}