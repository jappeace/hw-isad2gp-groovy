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
	SkipNode<Data> getNext(int depth){
		if(depth >= nextList.size()){
			return nextList[0]
		}
		return nextList[nextList.size() - depth -1]
	}
	int getTop(){
		return nextList.size() - 1
	}
}
