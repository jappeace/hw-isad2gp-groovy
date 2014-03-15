package nl.jappieklooster.graph

import java.awt.Point
import nl.jappieklooster.vector.Vector2D

class Node<T> {

	List<Node<T>> attached
	Vector2D position
	T value
	Node(Vector2D p){
		position = p
		attached = new ArrayList<Node<T>>()
	}
	List<Node<T>>[] add(Node<T> n){
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
		Node<T> subject = (Node<T>) e
		if(subject.is(this)){
			return true
		}
		return subject.position == this.position

	}
}
