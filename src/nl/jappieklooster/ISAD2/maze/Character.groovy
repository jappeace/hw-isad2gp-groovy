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
/**
 *
 * @author jappie
 */
class Character {
	Square location
	SquareGrid world
	boolean finished = false
	Direction facing = Direction.TOP
	Direction wallSide = Direction.LEFT
	
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
		Square next
		if(facing == Direction.TOP){
			if(wallSide == Direction.LEFT){
				next = location.left
				if(step(next)){
					facing = Direction.LEFT
					wallSide = Direction.BOTTOM
					return
				}
			}else
			if(wallSide == Direction.RIGHT){
				next = location.right
				if(step(next)){
					facing = Direction.RIGHT
					wallSide = Direction.BOTTOM
					return
				}				
			}
			next = location.top
			if(step(next)){
				return
			}
		}
		if(facing == Direction.LEFT){
			next = location.left
			if(step(next)){
				return
			}
		}
		if(facing == Direction.BOTTOM){
			next = location.bottom
			if(step(next)){
				return
			}
		}
		if(facing == Direction.RIGHT){
			next = location.right
			if(step(next)){
				return
			}
		}
	}
	private void turn(){
		switch(facing){
			case Direction.TOP:
				facing = Direction.LEFT
				break
			case Direction.LEFT:
				facing = Direction.BOTTOM
				break
			case Direction.BOTTOM: 
				facing = Direction.RIGHT
				break
			case Direction.RIGHT:
				facing = Direction.TOP
				break
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
	
	private boolean tryStepTo(
		Direction faceDirection, 
		Direction prefferdOne, 
		Direction prefferdTwo
	){
		if(facing == faceDirection){
			if(wallSide == Direction.LEFT){
				next = location.left
				if(step(next)){
					facing = Direction.LEFT
					wallSide = Direction.BOTTOM
					return true
				}
			}else
			if(wallSide == Direction.RIGHT){
				next = location.right
				if(step(next)){
					facing = Direction.RIGHT
					wallSide = Direction.BOTTOM
					return true
				}				
			}
			next = location.getDirection(facing)
			if(step(next)){
				return true
			}
		}
		return false
	}
}

