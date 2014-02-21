package nl.jappieklooster.ISAD2.points.rendering;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import nl.jappieklooster.ISAD2.points.PointGenerator;
import nl.jappieklooster.ISAD2.points.strategies.BruteClosePointSolver;

public class GraphPanel extends JPanel {

	private final Artist artist = new Artist();
	private final PointGenerator generator = new PointGenerator();
	/**
	 * Create the panel.
	 */
	public GraphPanel() {
		artist.setCanvas(this);
		artist.setGenerator(generator);
		artist.setSolver(new BruteClosePointSolver());
	}
	
	/**
	 * redraw entire graph
	 * @param points
	 */
	public void makeGraph(int points){
		generator.startGeneration(points);
		artist.render();
	}

	/**
	 * just use the chase to render
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Image img = artist.getImage();
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}
}
