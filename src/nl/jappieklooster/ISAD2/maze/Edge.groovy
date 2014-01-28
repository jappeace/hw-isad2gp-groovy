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
/**
 *
 * on construct this class selects 2 points to use with all error correction.
 * Encapsulated because its only relevant for this class
 * @author jappie
 */
class Edge {
	private Random random = new Random()
	Point one
	Point two
	
	Edge(SquareGrid basedOn){
		one = new Point(random.nexInt(basedOn.size.width), random.nextInt(basedOn.size.height))

		two = new Point(one)
		int nextRand = random.nextInt(4)
		
		switch (nextRand){
			case 0:
				two.x -= 1
				break;
			case 1:
				two.x += 1
				break;
			case 2:
				two.y -= 1
				break;
			case 3:
				two.y += 1
				break;
		}		
	}
}

