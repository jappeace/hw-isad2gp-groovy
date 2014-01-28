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
import java.awt.Point
import nl.jappieklooster.ISAD2.disjointsets.DisjointSets
import nl.jappieklooster.ISAD2.disjointsets.interfaces.ISetNode
/**
 * a maze with all the edges filled
 * @author jappie
 */
class SquareGrid extends DisjointSets {
	Dimension size
	static final int DEFAULT_WIDTH = 20
	static final int DEFAULT_HEIGHT = 20
	
	public SquareGrid(){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT)
	}
	public SquareGrid(int width, int height){
		super()
		size.width = width
		size.height = height
		int product = width*height
		if(product < 0){
			throw new Exception("Expecting positive integers to create checkboard")
		}
		setnodes = new ISetNode[product]
		
		// fil in the squares
		0..product.each{ i ->
			setnodes[i] = new Square()
			setnodes[i].index = i
		}	
	}
	/**
	 * translates the 1d array to the 2d board
	 * @return the found square or null on nothing
	 */
	Square getSquareAt(int x, int y){
		int targetIndex = x + y*width
		if( targetIndex < 0){
			return null
		}
		return (Square) setnodes[targetIndex]
	}
	
	void traverseSquares(Closure with){
		0..size.height.each{ y ->
			0..size.width.each{ x ->
				with(getSauareAt(x,y), new Point(x,y))
			}
		}
	}
}

