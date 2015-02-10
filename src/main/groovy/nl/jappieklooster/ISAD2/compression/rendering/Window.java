package nl.jappieklooster.ISAD2.compression.rendering;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Window extends JFrame {

	private JPanel contentPane;

	private final JButton btnCompress = new JButton("Compress"), btnDecompress = new JButton("Decompress");
	/**
	 * Create the frame.
	 */
	private Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCompress.setBounds(150, 154, 117, 25);
		contentPane.add(btnCompress);
		
		btnDecompress.setBounds(308, 154, 181, 25);
		contentPane.add(btnDecompress);
	}
	
	public static Window createWindow(){
		final Window result = new Window();
		
		result.btnCompress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser d = new JFileChooser();
				d.showOpenDialog(result);
				File f = d.getSelectedFile();
				if (f != null){
				System.out.println(f.getPath());
				}
			}
		});
		
		return result;
		
	}
}
