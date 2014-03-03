package nl.jappieklooster.ISAD2.backtracking.rendering;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Window extends JFrame {

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnLongestPath = new JButton("Longest path");
		btnLongestPath.setBounds(121, 247, 149, 25);
		getContentPane().add(btnLongestPath);
	}
}
