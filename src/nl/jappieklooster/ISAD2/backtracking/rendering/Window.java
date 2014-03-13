package nl.jappieklooster.ISAD2.backtracking.rendering;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Window extends JFrame {

	/**
	 * Create the application.
	 */
	public Window() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnLongestPath = new JButton("Longest path");
		btnLongestPath.setBounds(121, 247, 149, 25);
		getContentPane().add(btnLongestPath);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 38, 289, 197);
		getContentPane().add(panel);

		Artist a = new Artist();
		a.setCanvas(panel);
		a.render();
	}
}
