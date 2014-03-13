package nl.jappieklooster.ISAD2.backtracking.graph

import java.awt.Point

class Node {

	List<Node> attached
	Point position
	Node(Point p){
		position = p
		attached = new ArrayList<Node>()
	}
	Node[] add(Node n){
		attached.add(n)
		if(!n.attached.contains(this)){
			n.add(this)
		}
		attached
	}
	boolean equals(Object e){
		if(!e instanceof Node){
			return false
		}
		Node subject = (Node) e
		if(subject.is(this)){
			return true
		}
		return subject.position == this.position

	}
}
