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

import java.awt.Point
import nl.jappieklooster.ISAD2.disjointsets.DisjointSets
import nl.jappieklooster.ISAD2.disjointsets.interfaces.ISetNode

/**
 *
 * @author jappie
 */
class MazeFactory {
	SquareGrid base
	private Random random = new Random()
	// a bunch of constuctors, because lazy
	MazeFactory(){
		this(new SquareGrid())
	}
	MazeFactory(int x, int y){
		this(new SquareGrid(x, y))
	}
	MazeFactory(SquareGrid sg){
		base = sg
	}

	SquareGrid createMaze(){
		
		Point one = new Point(
			random.nextInt((Integer)base.size.width), 
			random.nextInt((Integer)base.size.height)
		)
		Point two = new Point(one)
		int nextRand = random.nextInt(4)
		

		Square modified
		if		(nextRand == 0){
			
			two.x -= 1
			
		}else if(nextRand == 1){
			
			two.x += 1
			
		}else if(nextRand == 2){
			
			two.y -= 1
			
		}else if(nextRand == 3){
			
			two.y += 1
		}
		
		Square sqOne = (Square) base.find(one)
		Square sqTwo = (Square) base.find(two)	
		
		if(sqOne != sqTwo){
			base.union(sqOne, sqTwo)
			if		(nextRand == 0){
			
				base.getSquareAt(two).right = base.getSquareAt(one)
			
			}else if(nextRand == 1){
			
				base.getSquareAt(one).right = base.getSquareAt(two)
			
			}else if(nextRand == 2){
			
				base.getSquareAt(two).bottom = base.getSquareAt(one)
			
			}else if(nextRand == 3){
			
				base.getSquareAt(one).bottom = base.getSquareAt(two)
			}
		}
		//TODO: implement algoritm
		return base
	}
}

