package nl.jappieklooster.list

class SkipListIterator<Data extends Comparable<Data>> implements Iterator<Data>{
	int index = 0
	SkipNode<Data> current
	Random random
	SkipListIterator(SkipNode<Data> from, Random rand){
		current = from
		random = rand
	}
    // Query Operations

	@Override
    boolean hasNext(){
		return current.nextList[0] != null
	}
	@Override
    Data next(){
		if(!hasNext()){
			return null
		}
		index++
		
	}
	@Override
    void remove(){
		current.previous.nextList[0] = current.nextList[0]
		List<SkipNode<Data>> neighbourList = current.nextList[0].nextList
		if(current.nextList.size() > neighbourList.size()){
			for(int i = neighbourList.size(); i < current.nextList.size(); i++){
				if(random.nextBoolean()){
					break;
				}
				neighbourList[i] = current.nextList[i]
			}
		}
	}
}
