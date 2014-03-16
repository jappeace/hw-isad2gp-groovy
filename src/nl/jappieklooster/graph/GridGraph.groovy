package nl.jappieklooster.graph

import java.awt.Point
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import nl.jappieklooster.vector.Vector2D

class GridGraph<T> {

	static{
		ArrayList.metaClass.getAt = { Double num ->
			return delegate[(int) num.round()];
		}
	}
	List<Node<T>> nodes
	Vector2D size
	
	GridGraph(int width, int height){
		nodes = new ArrayList<Node<T>>()
		size = new Vector2D(width, height)
		int nodeCount = width*height

		(0..(nodeCount-1)).each{
			nodes[it] = new Node<T>(new Vector2D(it % width, (int) (it/width)))
		}
	}
	/**
	 * gets a collumn as an arraylist, so another bracket will get the node
	 * @param x
	 * @return
	 */
	List<Node<T>> getAt(Integer x){
		def resultingCollumn = new ArrayList<Node<T>>()
		(0..(size.y-1)).each{
			resultingCollumn.add(nodes[x + it*size.x])
		}
		return resultingCollumn
	}
	Node<T> getAt(Vector2D where){
		
		return getAt((int) where.x.round())[where.y]
	}
	
	@Override
	void each(Closure callback){
		nodes.each{
			callback(it)
		}
	}
}
