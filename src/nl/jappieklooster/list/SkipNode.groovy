package nl.jappieklooster.list

class SkipNode<Data extends Comparable<Data>> implements Comparable<Data> {
	Data data
	List<SkipNode<Data>> nextList
	SkipNode<Data> previous

	SkipNode(Data d){
		nextList = new ArrayList<SkipNode<Data>>()
		data = d
	}
	
	@Override
	int compareTo(Data to) {
		return data.compareTo(to);
	}
	@Override
	boolean equals(Object to){
		if(!to instanceof Data){
			return false
		}
		Data target = (Data) to
		return data.compareTo(target) == 0
		
	}
	SkipNode<Data> getNext(){
		return nextList[getTop()]
	}
	void setNext(SkipNode<Data> to){
		nextList.add(to)
	}
	SkipNode<Data> getNext(int depth){
		if(depth >= nextList.size()){
			return nextList[0]
		}
		return nextList[nextList.size() - depth -1]
	}
	int getTop(){
		return nextList.size()  == 0 ? 0 : nextList.size()- 1
	}
	void increaseLevel(SkipNode<Data> left, SkipNode<Data> right){
		left.nextList[getTop()] = this
		this.nextList[getTop()] = right	
	}
	
	/**
	 * destroys all references to this skipnode so it would no longer be in a skiplist
	 * manual pointers will NOT be deleted
	 */
	void delete(){
		this.previous.nextList[0] = this.nextList[0]
		List<SkipNode<Data>> neighbourList = this.nextList[0].nextList
		if(this.nextList.size() > neighbourList.size()){
		}
	}
}
