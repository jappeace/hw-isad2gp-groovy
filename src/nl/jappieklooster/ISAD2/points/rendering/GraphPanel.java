package nl.jappieklooster.ISAD2.points.rendering;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import nl.jappieklooster.ISAD2.points.LevelGenerator;
import nl.jappieklooster.ISAD2.points.strategies.BruteClosePointSolver;

public class GraphPanel extends JPanel {

	private final Artist artist = new Artist();
	private Dimension panelSize;
	private final LevelGenerator generator;
	/**
	 * Create the panel.
	 */
	public GraphPanel() {
		panelSize = this.getSize();
		generator = new LevelGenerator(panelSize);
		getArtist().setCanvas(this);
		getArtist().setLevel(generator);
		getArtist().setSolver(new BruteClosePointSolver());
	}
	
	/** make sure the number generator gets updated */
	@Override
    public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		panelSize.setSize(width, height);
    }
	/**
	 * redraw entire graph
	 * @param points
	 */
	public void makeGraph(int points){
		generator.startGeneration(points);
		getArtist().render();
	}

	/**
	 * just use the case to render
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Image img = getArtist().getImage();
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}

	public Artist getArtist() {
		return artist;
	}
}
