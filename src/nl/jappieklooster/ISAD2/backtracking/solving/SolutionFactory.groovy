package nl.jappieklooster.ISAD2.backtracking.solving
import nl.jappieklooster.graph.GridGraph
import nl.jappieklooster.graph.Node
import nl.jappieklooster.vector.Vector2D

class SolutionFactory {
	GridGraph<Boolean> problem
	Deque<Node<Boolean>> solve(Vector2D start){

		// say nothing is visited
		problem.each{ Node<Boolean> n ->
			n.value = false
		}
		
		return depthSearch(problem[start])
	}
	
	private Deque<Node<Boolean>> depthSearch(Node<Boolean> n){
		
		Deque<Node<Boolean>> currentLongest = new ArrayDeque<Node<Boolean>>()
		n.value = true
		n.attached.each{
			if(!it.value){
				Deque<Node> visited = depthSearch(it)
				currentLongest = visited.size() > currentLongest.size() ? visited : currentLongest
				visited.each{
					it.value = false
				}
			}
		}
		currentLongest.add(n)
		return currentLongest
	}
	
	
}
