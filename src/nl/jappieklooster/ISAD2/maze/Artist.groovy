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
import java.awt.Image
import java.awt.Point
import java.awt.image.BufferedImage
import java.awt.Color
import java.lang.management.ManagementFactory
/**
 * a class that renders the maze on a java pane
 * @author jappie
 */
class Artist {
	private BufferedImage image
	MazeFactory mazeFactory
	MazePanel canvas
	private static final int BAD_CANVAS_DIMENSION_CORRECTION = 500
	public Artist(){
		super()
	}
	
	Image getImage(){
		return image
	}

	Image render(){
		Dimension squareSize = new Dimension(0,0)
		SquareGrid subject = mazeFactory.createMaze()
		
		if(canvas.width * canvas.height <= 0){
			canvas.size = new Dimension(
				BAD_CANVAS_DIMENSION_CORRECTION,
				BAD_CANVAS_DIMENSION_CORRECTION
			)
		}
		Dimension correctedCanvasSize = new Dimension(canvas.width-100,canvas.height-100)
		
		squareSize.width = Math.round(correctedCanvasSize.width / subject.size.width) 
		squareSize.height = Math.round(correctedCanvasSize.height / subject.size.height)
		
		image = new BufferedImage(canvas.width, canvas.height, BufferedImage.TYPE_INT_ARGB)
		Graphics g = image.graphics
		g.setColor(Color.black)

		
		// if a side == null, draw an edge
		subject.traverseSquares{Square square, Point position ->
			if(square == null){
				// return == continue, because of callback
				return
			}
			position.x *= squareSize.width
			position.y *= squareSize.height
			
			if(square.visited){
				g.setColor(Color.green)
				g.fillRect(
					(Integer)Math.round(position.x + squareSize.width * 0.1), 
					(Integer)Math.round(position.y + squareSize.height* 0.1),
					(Integer)Math.round(position.x + squareSize.width * 0.9),
					(Integer)Math.round(position.y + squareSize.height* 0.9)
				)
			}
			if(ManagementFactory.runtimeMXBean.inputArguments.toString().indexOf("jdwp") >= 0){
				drawString(
					g, 
					"    ${square.top}",
					position, 
					squareSize, 
					0.3
				)
				drawString(
					g,
					"${square.left} ${square} ${square.right}", 
					position, 
					squareSize, 
					0.5
				)
				drawString(
					g,
					"    ${square.bottom}", 
					position, 
					squareSize, 
					0.7
				)
			}
			
			g.setColor(Color.black)
			
			if(square.right == null){
				drawLine(g,
					position.x + squareSize.width, 
					position.y, 
					position.x + squareSize.width, 
					position.y + squareSize.height
				)
			}
			if(square.bottom == null){
				drawLine(g,
					position.x,						
					position.y + squareSize.height,
					position.x + squareSize.width,	
					position.y + squareSize.height
				)
			}
			/* only bottem and right need be handled, because the squares next to the current one
			 * will handle this ones edeges on the left and top. 
			 * the initial border is handled elsewhere
			*/
		}
		
		// draw the missing left and top 
		double xOffset = 0
		subject.traverseRow(0, { Square square, Point position ->
			xOffset = position.x * squareSize.width
		})
		drawLine(g, 0,0,xOffset, 0)
		
		double yOffset = 0
		subject.traverseCollumn(0, { Square square, Point position ->
			yOffset = position.y * squareSize.height
		})		
		drawLine(g, 0,0,0, yOffset)
		
		g.dispose()
		return image
	}
	
	
	private void drawString(Graphics g, String str, Point position, Dimension squareSize, float offset){
			g.drawString(
				str,
				doubleToInt(position.x),
				doubleToInt(position.y + offset*squareSize.height)
				)		
	}
	private void drawLine(Graphics g, double x_one, double y_one,double x_two, double y_two){
		g.drawLine(
			doubleToInt(x_one),
			doubleToInt(y_one),
			doubleToInt(x_two),
			doubleToInt(y_two)
		)
	}
	private Integer doubleToInt(double input){
		return (Integer) Math.round(input)
	}
}

