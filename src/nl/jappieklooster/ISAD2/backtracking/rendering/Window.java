package nl.jappieklooster.ISAD2.backtracking.rendering;

import java.awt.Graphics;

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
		btnLongestPath.setBounds(308, 514, 149, 25);
		getContentPane().add(btnLongestPath);
		
		GraphPanel panel = new GraphPanel();
		panel.setBounds(38, 38, 822, 404);
		getContentPane().add(panel);
		panel.makeGraph();

	}
}
