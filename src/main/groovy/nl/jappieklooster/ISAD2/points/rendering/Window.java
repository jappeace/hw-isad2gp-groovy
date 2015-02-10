package nl.jappieklooster.ISAD2.points.rendering;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import nl.jappieklooster.ISAD2.points.strategies.BruteClosePointSolver;
import nl.jappieklooster.ISAD2.points.strategies.DivideAndConquerPointSolver;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAmount;
	private GraphPanel graphPanel;

	private static final int defaultPointAmount = 10;
	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		graphPanel = new GraphPanel();
		graphPanel.setBounds(17, 25, 890, 749);
		contentPane.add(graphPanel);
		
		JButton btnGenerateBrute = new JButton("Generate and brute find");
		btnGenerateBrute.setBounds(226, 786, 206, 25);
		btnGenerateBrute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				graphPanel.getArtist().setSolver(new BruteClosePointSolver());
				redraw();
			}
		});
		contentPane.add(btnGenerateBrute);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setText(Integer.toString(defaultPointAmount));
		textFieldAmount.setBounds(97, 789, 74, 19);
		contentPane.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(17, 791, 70, 15);
		contentPane.add(lblAmount);
		
		JButton btnGenerateAndDevide = new JButton("Generate and devide find");
		btnGenerateAndDevide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				graphPanel.getArtist().setSolver(new DivideAndConquerPointSolver());
				redraw();
			}
		});
		btnGenerateAndDevide.setBounds(444, 786, 244, 25);
		contentPane.add(btnGenerateAndDevide);
	}
	@Override
	public void setVisible(boolean to){
		super.setVisible(to);
		graphPanel.makeGraph(defaultPointAmount);
		
	}
	
	protected void redraw(){
		graphPanel.makeGraph(Integer.parseInt(textFieldAmount.getText()));
		this.repaint();
	}

}
