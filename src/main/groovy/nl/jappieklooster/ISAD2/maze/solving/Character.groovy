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

package nl.jappieklooster.ISAD2.maze.solving
import nl.jappieklooster.Log
import nl.jappieklooster.ISAD2.maze.generation.Square
import nl.jappieklooster.ISAD2.maze.generation.SquareGrid
/**
 *
 * @author jappie
 */
class Character {
	Square location
	SquareGrid world
	boolean finished = false
	private Direction facing = Direction.TOP
	private Direction wallSide = Direction.LEFT
	private Square next
	private setFinished(boolean to){
		finished = to
	}
	
	void move(){
		location.visited = true
		// check if the finished square is reached
		if(world.getSquareAt(9,0) == location){
			finished = true
			return
		}
		
		if(isStepping(Direction.TOP)){
			return
		}
		if(isStepping(Direction.LEFT)){
			return
		}
		if(isStepping(Direction.BOTTOM)){
			return
		}
		if(isStepping(Direction.RIGHT)){
			return
		}
		
		
	}

	private boolean step(Square to){
		// no path to walk
		if(to == null){
			return false
		}
		location = to
		return true
		
	}
	
	private boolean isStepping(Direction faceDirection){
		Direction opposite = faceDirection.next().next()
		if(facing == faceDirection){
			if(checkWallGap(opposite)){
				return true
			}
			next = location.getDirection(facing)
			if(step(next)){
				return true
			}
			// probably reached a dead end... time to turn
			wallSide = facing
			facing = wallSide.next()
			return true
		}
		return false
	}
	
	private boolean checkWallGap(Direction newHand){
		next = location.getDirection(wallSide)
		if(step(next)){
			facing = wallSide
			wallSide = newHand
			return true
		}
		return false
		
	}
}

