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

/**
 *
 * @author jappie
 */
class MazeFactory {
	
	/** The designer does not understand this unless added before its being used...*/
	static {
		/** Make arralist a litle more like python 
		 * picks a random element or elements specified by the number
		 * */
		ArrayList.metaClass.getRand = { int amount = 0 ->
			if(amount==0) {
				return delegate[new Random().nextInt(delegate.size - 1)]
			} else {
				def tempList = []
				def counter = 0
				while(counter>amount) {
					tempList.add(delegate[new Random().nextInt(delegate.size - 1)])
					counter++
				}
				return tempList
			}
		}
		/**
		 * removes a single randm element
		*/
		ArrayList.metaClass.removeRand = {
			def element = delegate.getRand()
			delegate.remove(element)
			return element
		}
	}
	
	SquareGrid base
	private Random random = new Random()
	
	MazeFactory(int x, int y){
		this(new SquareGrid(x, y))
	}
	MazeFactory(SquareGrid sg){
		base = sg
	}
	SquareGrid createMaze(){
		
		int targetIndex = base.size.width * base.size.height * -1
		while(base.getValueAt(base.findIndex(new Point(0,0))) != targetIndex){
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
		List<Integer> posibleSides = (0..3).toList()
		if(one.x == base.size.width - 1){
			
			posibleSides.remove((Object)1)
			
		}
		if(one.x == 0){
			
			posibleSides.remove((Object)0)
			
		}
		if(one.y == base.size.height){
			
			posibleSides.remove((Object)3)
			
		}
		if(one.y == 0){
			
			posibleSides.remove((Object)2)
			
		}
		chosenSide = posibleSides.removeRand()
		Closure bindSqMethod
		if		(chosenSide == 0){
			
			bindSqMethod = getBindSqHorizontal()
			two.x -= 1
			
		}else if(chosenSide == 1){
			
			bindSqMethod = getBindSqHorizontal()
			two.x += 1
			
		}else if(chosenSide == 2){
			
			bindSqMethod = getBindSqVertical()
			two.y -= 1
			
		}else if(chosenSide == 3){
			
			bindSqMethod = getBindSqVertical()
			two.y += 1
		}
		
		int sqOne = base.findIndex(one)
		int sqTwo = base.findIndex(two)	
		
		if(sqOne != sqTwo){
			base.union(sqOne, sqTwo)
			if		(chosenSide % 2 == 0){
				
				bindSqMethod(one, two)
			
			}else{
				
				bindSqMethod(two, one)
			
			}
		}
	}
	
	private Closure getBindSqHorizontal(){
		return { Point right, Point left ->
			base.getSquareAt(left).right = base.getSquareAt(right)
			base.getSquareAt(right).left = base.getSquareAt(left)
		}
	}
	
	private Closure getBindSqVertical(){
		return { Point bottom, Point top ->
			base.getSquareAt(top).bottom = base.getSquareAt(bottom)
			base.getSquareAt(bottom).top = base.getSquareAt(top)
		}
	}

}

