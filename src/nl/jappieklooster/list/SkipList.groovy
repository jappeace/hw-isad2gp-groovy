package nl.jappieklooster.list

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class SkipList<Data extends Comparable<Data>> implements List<Data>{

	int size = 0;
	
	SkipNode<Data> head
	
	SkipList(){
		head = new SkipNode<Data>()
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
		
		return search(head, d, head.next.size()) != null;
	}
	
	private SkipNode<Data> search(SkipNode<Data> current, Data target, int depth){
		SkipNode<Data> result = null
		if(target == current){
			return current
		}
		if(current < target){
			result = search(current.next[depth], target, depth)
		}
		
		
		// target is smaller then current so we need to go lower
		depth--;
		if(depth < 0){
			return result
		}
		if(current > target){
			result = search(current.next[depth], target, depth)
		}
		return result
		

	}


	@Override
	Iterator<Data> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	<T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean add(Data e) {
		// TODO Auto-generated method stub
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

	@Override
	Data get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Data set(int index, Data element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void add(int index, Data element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Data remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	ListIterator<Data> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ListIterator<Data> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<Data> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
