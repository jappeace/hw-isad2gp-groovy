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
import nl.jappieklooster.Log
/**
 * A class for easaly handaling a grid as a one dimensional array...
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
		size = new Dimension(width, height)
		int product = width*height
		if(product < 0){
			throw new Exception("Expecting positive integers to create checkboard")
		}
		setnodes = new ISetNode[product+1]
		
		// fil in the squares
		(0..product).each{ i ->
			setnodes[i] = new Square()
			setnodes[i].index = i
		}	
	}
	/**
	 * translates the 1d array to the 2d board
	 * @return the found square or null on nothing
	 */
	Square getSquareAt(Integer x, Integer y){
		int targetIndex = x + y*size.width
		if( targetIndex < 0){
			Log.warn "trying to get a negative index with x {0} and y {1}", x, y
			return null
		}
		if( targetIndex >= setnodes.length){
			Log.warn "trying to get a index out of bounds with x {0} and y {1}", x, y
			return null
		}
		return (Square) setnodes[targetIndex]
	}
	/**
	* round and truncates the double value to make it compatible with the int type function.
	* indexcies are always ints in a array
	*/
	Square getSquareAt(double x, double y){
		return getSquareAt((Integer) Math.round(x),(Integer) Math.round(y))
	}
	
	/**
	 * walk trough all elements and execute the closure
	 */
	void traverseSquares(Closure with){
		(0..(size.height-1)).each{ y ->
			traverseRow(y, with)
		}
	}
	
	/**
	 * walk trough a single collumn
	 */
	void traverseCollumn(int number, Closure with){
		(0..(size.height-1)).each{ y ->
			traverse(number, y, with)
		}	
	}
	/**
	 * walk trough a single row
	 */
	void traverseRow(int number, Closure with){
		(0..size.width).each{ x ->
			traverse(x, number, with)
		}
	}
	/**
	 * final stage in all the traverse methods, get the cell and do the closure/callback 
	 * */
	private void traverse(double x, double y, Closure with){
		// round the point
		Point point =  new Point(
			(Integer)Math.round(x),
			(Integer)Math.round(y)
		)
		// do the callback
		with(
			getSquareAt(point.x,point.y), 
			point
		)
	}
}

