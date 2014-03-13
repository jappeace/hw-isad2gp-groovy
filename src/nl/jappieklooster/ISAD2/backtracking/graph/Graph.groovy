package nl.jappieklooster.ISAD2.backtracking.graph

import java.awt.Point

class Graph {

	static{
		
		ArrayList.metaClass.getAt = { Double num ->
			return delegate[(int) num];
		}
	}
	List<Node> nodes
	double width
	double height
	
	Graph(int width, int height){
		nodes = new ArrayList<Node>()
		this.width = width
		this.height = height
		int nodeCount = width*height

		(0..(nodeCount-1)).each{
			nodes[it] = new Node(new Point(it, (int) (it/width)))
		}
	}
	/**
	 * gets a collumn as an arraylist, so another bracket will get the node
	 * @param x
	 * @return
	 */
	List<Node> getAt(Integer x){
		def resultingCollumn = new ArrayList<Node>()
		(0..(height-1)).each{
			resultingCollumn.add(nodes[x + it*width])
		}
		return resultingCollumn
	}

	static Graph createGraph(){
		Graph graph = new Graph(5,5) 
		graph[0][0].add(graph[1][0i])

        graph[0][0].add(graph[1][0]) 
        graph[1][0].add(graph[2][0]) 
        graph[2][0].add(graph[3][0]) 
        graph[3][0].add(graph[4][0])

        graph[0][0].add(graph[0][1])
        graph[0][1].add(graph[0][2])
        graph[0][2].add(graph[0][3])
        graph[0][3].add(graph[0][4])

        graph[0][4].add(graph[1][4]) 
        graph[1][4].add(graph[2][4]) 
        graph[2][4].add(graph[3][4]) 
        graph[3][4].add(graph[4][4])

        graph[4][0].add(graph[4][1])
        graph[4][1].add(graph[4][2])
        graph[4][2].add(graph[4][3])
        graph[4][3].add(graph[4][4])

        // Outer tilted square
        graph[2][0].add(graph[1][1])
        graph[1][1].add(graph[0][2])

        graph[2][0].add(graph[3][1])
        graph[3][1].add(graph[4][2])

        graph[4][2].add(graph[3][3])		
        graph[3][3].add(graph[2][4])

        graph[2][4].add(graph[1][3])	
        graph[1][3].add(graph[0][2])

        // Inner Square
        graph[1][1].add(graph[2][1])
        graph[2][1].add(graph[3][1])

        graph[3][1].add(graph[3][2])
        graph[3][2].add(graph[3][3])

        graph[3][3].add(graph[2][3])
        graph[2][3].add(graph[1][3])

        graph[1][3].add(graph[1][2])
        graph[1][2].add(graph[1][1])

        // Inner tilted square
        graph[1][2].add(graph[2][1])
        graph[2][1].add(graph[3][2])
        graph[3][2].add(graph[2][3])
        graph[2][3].add(graph[1][2])

        // Inner line
        graph[2][1].add(graph[2][2])
        graph[2][2].add(graph[2][3])	
		return graph
}
}
