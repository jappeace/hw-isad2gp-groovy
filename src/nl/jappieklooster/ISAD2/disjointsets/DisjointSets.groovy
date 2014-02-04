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

/**
 *
 * @author jappie
 */
class DisjointSets implements IDisjointSets{
	int[] _sets
	public DisjointSets(int n){
		_sets = new int[n]
		(0..(n-1)).each{ i ->
			_sets[i] = -1
		}
	}
	/**
	* does the recursive call and compresses the tree
	*/
	int find(int from){
		int target = _sets[from]
		if(isRoot(target)){
			return from
		}else{
			int root = find(target)
			_sets[from] = root
			return root
		}
	}
	
	void union(int one, int two){
		if(!isRoot(_sets[one])){
			one = find(one)
		}
		if(!isRoot(_sets[two])){
			two = find(two)
		}
		if(_sets[one] < _sets[two]){
			_sets[one] += _sets[two]
			_sets[two] = _sets[one]
		}else{
			_sets[two] += _sets[one]
			_sets[one] = _sets[two]		
		}
	}
	
	private boolean isRoot(int node){
		_sets[node] < 0
	}
}

