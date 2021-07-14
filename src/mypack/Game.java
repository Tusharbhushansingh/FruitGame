package mypack;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game implements KeyListener {
	static int bound = 0;
	JFrame jf;
	JLabel jl, basket, egg, time, points;
	Thread th;

	int timeleft = 59, count = 0;
	int score = 0;

	public Game() {
		jf = new JFrame();
		jf.setLayout(null);
		jf.setContentPane(new JLabel(new ImageIcon("image\\b.jpg")));

		jf.add(basket = new JLabel(new ImageIcon("image\\bucket1.gif")));
		basket.setBounds(bound, 500, 180, 200);
		jf.add(egg = new JLabel(new ImageIcon("image\\egg1.gif")));
		basket.setBounds(0, 0, 0, 0);
		time = new JLabel("Time: 59");
		time.setBounds(20, 10, 50, 20);

		points = new JLabel("Points: 0");
		points.setBounds(100, 10, 150, 20);
		

		jf.add(time);
		jf.add(points);

		// jf.setSize(600,600);
		jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jf.setSize(1024, 754);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setFocusable(true);
		jf.setResizable(false);
		jf.addKeyListener(this);

		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		th = new Thread() {
			public void run() {
			
				while (true) {
					int x = (int) (Math.random() * 500);
					for (int y = 0; y < 530; y++)
					{
						egg.setBounds(x, y, 180, 180);

						if (basket.getY() == egg.getY() && x > bound + 65 == x < bound - 65)
						{
							score = score + 1;							
							points.setText("points :"+score);
							break;

						}

						count++;
						if (count == 100) {
							timeleft--;
							
							count = 0; 
						
							
							
						}
						time.setText("Time:" + timeleft);

						try {
							Thread.sleep(5);
						} catch (Exception e) {
						}

					}
				}
			}

		};
		th.start();

	}

	public static void main(String[] args) {

		new Game();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyChar() == 'a') {
			bound = bound - 10;
		}
		if (ke.getKeyChar() == 'd') {
			bound = bound + 10;
		}
		basket.setBounds(bound, 515, 180, 200);

		if (ke.getKeyChar() == 'p') {
			th.suspend();
		}
		if (ke.getKeyChar() == 'r') {
			th.resume();
		}

	}

	public void keyReleased(KeyEvent e) {

	}

}
