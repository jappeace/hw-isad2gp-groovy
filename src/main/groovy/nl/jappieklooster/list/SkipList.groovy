package nl.jappieklooster.list

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class SkipList<Data extends Comparable<Data>> implements Collection<Data>{

	int size;
	
	SkipNode<Data> head
	Random random
	
	SkipList(){
		random = new Random()
		clear();
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
	private SkipNode<Data> search(SkipNode<Data> current, Data target, int height, Closure onDescent = null){
		if(current == target){
			return current
		}
		if(current > target){
			return current.previous
		}
		if(current.nextList[height] != null){
			return search(current.nextList[height], target, height, onDescent)
		}
		
		// target is smaller then current so we need to go lower
		height--;
		if(height < 0){
			// if we have result, return otherwise return current, which is closest
			return current
		}
		if(onDescent){
			// allow extra code the be executed when descending a level
			// like putting stuff on a stack
			onDescent(current)
		}
		return search(current, target, height, onDescent)
	}
	// searches for a specified height by trying to go up otherwise go right
	// returns null if failed
	private SkipNode<Data> searchLevel(SkipNode<Data> current, int height){
		if(current == null){
			return current
		}
		if(current.getTop() > height){
			return current.nextList[height]
		}
		return current.next
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
	boolean add(Data element) {
		size++
		if(head.next == null){
			head.next = new SkipNode<Data>(element)
			head.next.previous = head
			return true
		}
		Stack<SkipNode<Data>> prevStack = new Stack<SkipNode<Data>>()
		SkipNode<Data> neighbour = search(
			head.next,
			element, 
			head.next.getTop(),
			{ SkipNode<Data> node ->
				prevStack.push(node)
            }
		);
		// add the data to a new linklist like node
		SkipNode<Data> toAdd = new SkipNode<Data>(element)
		toAdd.previous = neighbour
		toAdd.increaseLevel(neighbour, searchLevel(neighbour.nextList[0], 0))
		
		// do the coinflip, to determin height
		// should break eventualy
		for(int i = 1;random.nextBoolean(); i++){
			if(prevStack.size() == 0){
				// make sure the head has a reference to it
				head.next.increaseLevel(head, null)
				prevStack.push(head.next)
			}
			toAdd.increaseLevel(prevStack.pop(), searchLevel(neighbour.nextList[0], i))
			
		}

		return true;
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
		size = 0
		head = new SkipNode<Data>()
	}
}
