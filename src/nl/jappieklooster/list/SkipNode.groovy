package nl.jappieklooster.list

class SkipNode<Data extends Comparable<Data>> implements Comparable<Data> {
	Data data
	List<SkipNode<Data>> next
	SkipNode(Data d){
		next = new ArrayList<SkipNode<Data>>()
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
}
