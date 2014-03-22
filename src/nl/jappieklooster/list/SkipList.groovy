package nl.jappieklooster.list

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class SkipList<Data extends Comparable<Data>> implements Collection<Data>{

	int size = 0;
	
	SkipNode<Data> head
	Random random
	
	SkipList(){
		head = new SkipNode<Data>()
		random = new Random()
	}
	
	@Override
	int size() {
		return size;
	}

	@Override
	boolean isEmpty() {
		return size == 0;
	}

	@Override
	boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(!o instanceof Data){
			return false
		}
		Data d = (Data) o
		
		return search(head.next[head.getTop()], d, head.getTop()) != null;
	}
	
	/** searches for the given data trough a comperator or at least the closest value to it*/
	private SkipNode<Data> search(SkipNode<Data> current, Data target, int depth){
		if(target == current){
			return current
		}
		if(target < current){
			return current.previous
		}
		if(current.nextList[depth] != null){
			return search(current.nextList[depth], target, depth)
		}
		
		// target is smaller then current so we need to go lower
		depth--;
		if(depth < 0){
			// if we have result, return otherwise return current, which is closest
			return current
		}
		return search(current, target, depth)
	}


	@Override
	Iterator<Data> iterator() {
		return new SkipListIterator<>(head, random);
	}

	@Override
	Object[] toArray() {
		Object[] result = new Object[size]
		
		this.eachWithIndex{ SkipNode<Data> d, int i ->
			result[i] = (Object) d.data
		}
		return result;
	}

	@Override
	<T> T[] toArray(T[] a) {
		T[] result;
		if(a.size() > this.size()){
			result = (T[])Array.newInstance(a[0].class, this.size());
		}
		toArray().each{
            result = (T) it;
        }
		return result;
	}

	@Override
	boolean add(Data e) {
		size++
		SkipNode<Data> neighbour = search(head, e, head.getTop())
		return false;
	}

	@Override
	boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean addAll(Collection<? extends Data> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean addAll(int index, Collection<? extends Data> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void clear() {
		// TODO Auto-generated method stub
		
	}
}
