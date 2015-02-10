package nl.jappieklooster.ISAD2.backtracking.rendering

import java.awt.Graphics
import javax.swing.JPanel

class GraphPanel extends JPanel {

	Artist artist = new Artist();
	@Override
	void paint(Graphics g){
			g.drawImage(artist.image, 0, 0, null)
	}
	void makeGraph(){
		artist.setCanvas(this);
		artist.render();

	}
}
