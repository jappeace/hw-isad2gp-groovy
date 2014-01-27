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

import nl.jappieklooster.ISAD2.disjointsets.DisjointSets
import nl.jappieklooster.ISAD2.disjointsets.interfaces.ISetNode
/**
 * a maze with all the edges filled
 * @author jappie
 */
class CheckBoard extends DisjointSets {
	int width
	int height
	
	public CheckBoard(){
		this(20,20)
	}
	public CheckBoard(int width, int height){
		super()
		this.width = width
		this.height = height
		int product = width*height
		if(product < 0){
			throw new Exception("Expecting positive integers to create checkboard")
		}
		setnodes = new ISetNode[product]
		
		// fil in the squares
		0..product.each{ i ->
			setnodes[i] = new Square()
		}
		
		// bind the edges
		0..height.each{ h ->
			0..width.each{ w ->
				Square square = getSquareAt(w, h)
				if(w != 0){
					square.left   = new Edge(square, getSquareAt(w-1, h))
				}
				if(w != width){
					square.right  = new Edge(square, getSquareAt(w+1, h))
				}
				if(h != 0){
					square.top    = new Edge(square, getSquareAt(w, h-1))
				}
				if(h != height){
					square.bottem = new Edge(square, getSquareAt(w, h+1))
				}
			}
		}	
	}
	/**
	* translates the 1d array to the 2d board
	*/
	Square getSquareAt(int x, int y){
		return (Square) setnodes[x + y*width]
	}
}

