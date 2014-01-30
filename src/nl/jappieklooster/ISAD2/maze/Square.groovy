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

import nl.jappieklooster.ISAD2.disjointsets.AbstractSetNode
import nl.jappieklooster.Log
/**
 * represents a square on the gird.
 * if the right and bottom square are null it means there is an edge between them.
 * the top and left are decided by the neighbour, if this square is on the top or left edge on the board
 * there is an edge by default. this class is ignorent of start and end, it has to be handled by somthing
 * else
 * @author jappie
 */
class Square extends AbstractSetNode{
	Square right
	Square bottom
	boolean visited = false
	Square(){
		super()
	}
	
	void setRight(Square to){
		if(right != null){
			Log.warn "overiding a set right: {0} to {1}",right, to
		}
		right = to		
	}
		
	void setBottom(Square to){
		if(bottom != null){
			Log.warn "overiding a set bottom: {0} to {1}",bottom, to
		}
		bottom = to
	}
}

