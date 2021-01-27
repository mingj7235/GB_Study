package snailFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnailMain extends JFrame{
	
	static SnailMain sv;
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	static JLabel snail1 = new JLabel();
	static JLabel snail2 = new JLabel();
	static JLabel snail3 = new JLabel();
	
	long time = 0L;
	Random r = new Random();
	
	public SnailMain() {
		int width = 600;
		int height = 300;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		Thread t1 = new Thread(new Snail1());
		Thread t2 = new Thread(new Snail2());
		Thread t3 = new Thread(new Snail3());
		int x = (size.width - width) / 2;
		int y = (size.height - height) / 2;
		String text = "";
		setSize(width, height);
		setLocation(x, y);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		time = r.nextInt(901) + 100;
		
		p1.setBackground(Color.WHITE);
		p1.setPreferredSize(new Dimension(width, height / 3 - 10));
		snail1.setFont(new Font("∞ÌµÒ√º", Font.BOLD, 27));
		p1.add(snail1);
		add(p1, BorderLayout.NORTH);
		
		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(width, height / 3));
		snail2.setFont(new Font("∞ÌµÒ√º", Font.BOLD, 27));
		p2.add(snail2);
		add(p2, BorderLayout.CENTER);

		p3.setBackground(Color.WHITE);
		p3.setPreferredSize(new Dimension(width, height / 3 - 15));
		snail3.setFont(new Font("∞ÌµÒ√º", Font.BOLD, 27));
		p3.add(snail3);
		add(p3, BorderLayout.SOUTH);
		
		setVisible(true);
		t1.start();
		t2.start();
		t3.start();

	}
	public static void main(String[] args) {
		sv = new SnailMain();
	}
}










