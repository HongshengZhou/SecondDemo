package learningVideo;
/*
 * 书里的程序
 */
import java.awt.*;
import javax.swing.*;
public class Video29_1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Authority");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primary=new JPanel();
		primary.setBackground(Color.yellow);
		primary.setPreferredSize(new Dimension(250,75));
		
		JLabel label1=new JLabel("Question authority,");
		JLabel label2=new JLabel("but raise your hand first.");
		JButton button=new JButton("I was a button.");
		
		primary.add(label1);
		primary.add(label2);
		primary.add(button);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(100, 200);
	}

}
