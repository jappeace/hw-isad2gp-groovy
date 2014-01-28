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
import java.awt.Point
import java.awt.image.BufferedImage
import javax.swing.JPanel

/**
 * a class that renders the maze on a java pane
 * @author jappie
 */
class MazePanel extends JPanel {
	private BufferedImage image
	SquareGrid subject
	public MazePanel(){
		super()
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}
	}

	void render(){
		Dimension squareSize = new Dimension(0,0)
		squareSize.width = Math.round(subject.size.width / width) 
		squareSize.height = Math.round(subject.size.height/ height)
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
		Graphics g = image.graphics
		g.setColor(Color.black)
		g.drawRect(0,0,width,height)
		
		// if a side == null, draw an edge
		subject.traverseSquares{Square square, Point position ->
			if(square.right == null){
				g.drawLine(
					position.x + squareSize.width, position.y, 
					position.x + squareSize.width, position.y + squareSize.height
				)
			}
			if(square.bottem == null){
				g.drawLine(
					position.x,						position.y + squareSize.height,
					position.x + squareSize.width,	position.y + squareSize.height
				)
			}
			/* only bottem and right need be handled, because the squares next to the current one
			 * will handle this ones edeges on the left and top. 
			 * the initial border is handled elsewhere
			*/
		}
	}
}

