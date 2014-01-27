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

package nl.jappieklooster.ISAD2.disjointsets
import nl.jappieklooster.ISAD2.disjointsets.interfaces.ISetNode

/**
 * this class adds some constructor logic, that is essential for supressing
 * nullpointer exceptions, but adds no aditional functionlaity
 * @author jappie
 */
abstract class AbstractSetNode implements ISetNode {
	AbstractSetNode(){
		parent = new ISetNode(){
			ISetNode parent = null
			Comparable index = -1
		}		
	}
}

