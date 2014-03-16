package nl.jappieklooster.ISAD2.backtracking.rendering;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import nl.jappieklooster.ISAD2.backtracking.solving.SolutionFactory;
import nl.jappieklooster.vector.Vector2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame {
	private JTextField textXCoordinate;
	private JTextField textYCoordinate;

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
		
		final GraphPanel panel = new GraphPanel();
		panel.setBounds(12, 27, 932, 464);
		getContentPane().add(panel);
		
		final JLabel lblLegnth = new JLabel("Legnth: ");
		lblLegnth.setBounds(488, 519, 70, 15);
		getContentPane().add(lblLegnth);
		
		textXCoordinate = new JTextField("0");
		textXCoordinate.setBounds(50, 517, 78, 19);
		getContentPane().add(textXCoordinate);
		textXCoordinate.setColumns(10);
		
		textYCoordinate = new JTextField("0");
		textYCoordinate.setColumns(10);
		textYCoordinate.setBounds(136, 517, 78, 19);
		getContentPane().add(textYCoordinate);
		panel.makeGraph();

		btnLongestPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolutionFactory f = new SolutionFactory();
				f.setProblem(panel.getArtist().getGraph());
				panel.getArtist().setPath(
					f.solve(
						new Vector2D(
								Double.parseDouble(textXCoordinate.getText()),
                                Double.parseDouble(textYCoordinate.getText())
						)
					)
				);
				int size = panel.getArtist().getPath().size();
				// makegraph empty the que
				panel.makeGraph();
				panel.repaint();
				lblLegnth.setText("Length " + size);
			}
		});
	}
}
