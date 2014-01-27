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

import nl.jappieklooster.ISAD2.disjointsets.interfaces.IDisjointSets
import nl.jappieklooster.ISAD2.disjointsets.interfaces.ISetNode

/**
 *
 * @author jappie
 */
class DisjointSets implements IDisjointSets{
	ISetNode[] setnodes
	
	ISetNode find(ISetNode from){
		ISetNode target = setnodes[from.index]
		if(isRoot(from)){
			return target
		}else{
			return find(target)
		}
	}
	
	Set<ISetNode> union(ISetNode one, ISetNode two){
		if(!isRoot(one)){
			one = find(one)
		}
		if(!isRoot(two)){
			two = find(two)
		}
		if(one.index < two.index){
			one.parent.index += two.parent.index
			two.parent = one
		}else{
			two.parent.index += one.parent.index
			one.parent = two			
		}
	}
	
	private boolean isRoot(ISetNode n){
		n.parent.index < 0
	}
}

