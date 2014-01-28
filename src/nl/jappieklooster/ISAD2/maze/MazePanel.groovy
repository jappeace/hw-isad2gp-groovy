/*
 * Copyright (C) 2014 jappie
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nl.jappieklooster.ISAD2.maze

import java.awt.Dimension
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JPanel

/**
 * a class that renders the maze on a java pane
 * @author jappie
 */
class MazePanel extends JPanel {
	private Dimension squareSize
	private BufferedImage image
	SquareGrid subject
	public MazePanel(){
		super()
		squareSize = new Dimension(0,0)
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}
	}

	void render(){
		squareSize.width = Math.round(subject.size.width / width) 
		squareSize.height = Math.round(subject.size.height/ height)
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
		Graphics g = image.graphics
		g.setColor(Color.black)
		g.drawRect(0,0,width,height)
		
		subject.setnodes.each{
			
		}
	}
}

