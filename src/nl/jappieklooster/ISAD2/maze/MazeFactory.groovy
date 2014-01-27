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
 *
 * @author jappie
 */
class MazeFactory {
	Collection<Square> createMaze(int width, int height){
		
	}
	private DisjointSets createCheckerBoard(int width, int height){
		int product = width*height
		if(product < 0){
			throw new Exception("Expecting positive integers to create checkboard")
		}
		DisjointSets result = new DisjointSets(setnodes:new ISetNode[product])
		
		// fil in the squares
		0..product.each{ i ->
			result.setnodes[i] = new Square()
		}
		
		// bind the edges
		0..product.each{ i ->
			
		}
		
	}
}

