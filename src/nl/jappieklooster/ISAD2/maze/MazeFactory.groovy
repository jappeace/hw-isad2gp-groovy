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
		int targetIndex = base.size.width * base.size.height * -1
		while(
			(
				(Square) base.find(new Point(0,0))
			).parent.index != targetIndex
		){
			algoritem();
		}

		return base
	}
	private void algoritem(){
		Point one = new Point(
			random.nextInt((Integer)base.size.width), 
			random.nextInt((Integer)base.size.height)
		)
		Point two = new Point(one)
		int chosenSide= random.nextInt(4)
		
		if		(one.x == base.size.width){
			
			chosenSide = 0
			
		}else if(one.x == 0){
			
			chosenSide = 1
			
		}else if(one.y == base.size.height -1){
			
			chosenSide = 2
			
		}else if(one.y == 0){
			
			chosenSide = 3
			
		}
		
		if		(chosenSide == 0){
			
			two.x -= 1
			
		}else if(chosenSide == 1){
			

			two.x += 1
			
		}else if(chosenSide == 2){
			
			two.y -= 1
			
		}else if(chosenSide == 3){
			
			two.y += 1
		}
		
		Square sqOne = (Square) base.find(one)
		Square sqTwo = (Square) base.find(two)	
		
		if(sqOne != sqTwo){
			base.union(sqOne, sqTwo)
			if		(chosenSide == 0){
			
				base.getSquareAt(two).right = base.getSquareAt(one)
			
			}else if(chosenSide == 1){
			
				base.getSquareAt(one).right = base.getSquareAt(two)
			
			}else if(chosenSide == 2){
			
				base.getSquareAt(two).bottom = base.getSquareAt(one)
			
			}else if(chosenSide == 3){
			
				base.getSquareAt(one).bottom = base.getSquareAt(two)
			}
		}
	}
}

