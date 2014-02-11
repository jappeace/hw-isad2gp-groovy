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
import nl.jappieklooster.Log
/**
 * A class for easaly handaling a grid as a one dimensional array...
 * @author jappie
 */
class SquareGrid{
	Dimension size
	static final int DEFAULT_WIDTH = 20
	static final int DEFAULT_HEIGHT = 20
	private Square[] _squares;
	private DisjointSets _sets;
	
	public SquareGrid(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT)
	}
	public SquareGrid(int width, int height){
		size = new Dimension(width, height)
		int product = width*height

		if(product < 0){
			throw new Exception("Expecting positive integers to create grid")
		}
		
		_squares = new Square[product];
		_sets = new DisjointSets(product);		
		// fil in the squares
		(0..(product-1)).each{ i ->
			_squares[i] = new Square()
		}	
	}

	/**
	 * translates the 1d array to the 2d board
	 * @return the found square or null on nothing
	 */
	Square getSquareAt(Integer x, Integer y){
		int targetIndex = calculateIndex(x, y)
		if( targetIndex < 0){
			Log.warn "trying to get a negative index with x {0} and y {1}", x, y
			return null
		}
		if( targetIndex >= _squares.length){
			Log.warn "trying to get a index out of bounds with x {0} and y {1}", x, y
			return null
		}
		return _squares[targetIndex]
	}
	/**
	* round and truncates the double value to make it compatible with the int type function.
	* indexcies are always ints in a array
	*/
	Square getSquareAt(double x, double y){
		getSquareAt((Integer) Math.round(x),(Integer) Math.round(y))
	}
	
	/**
	 * overload cause lazy
	 */
	Square getSquareAt(Point p){
		getSquareAt(p.x, p.y)
	}
	private int calculateIndex(Integer x, Integer y){
		x + y*size.width
	}
	/**
	 * TODO: change to findsquare
	 * an easier interface on top of the primitive find
	 */
	Square find(Point p){
		_squares[findIndex(p)]
	}
	/**
	 * TODO: change to find and implement IDistjointsets
	 */
	int findIndex(Point p){
		_sets.find(calculateIndex((Integer) Math.round(p.x), (Integer) Math.round(p.y)))
	}
	void union(int one, int two){
		_sets.union(one, two)
	}
	
	int getValueAt(int index){
		return _sets.getValueAt(index)
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
		(0..size.width-1).each{ x ->
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

