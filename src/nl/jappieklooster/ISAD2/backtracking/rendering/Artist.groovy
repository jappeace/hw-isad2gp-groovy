package nl.jappieklooster.ISAD2.backtracking.rendering

import java.awt.Graphics
import java.awt.Image
import java.awt.Color;

import nl.jappieklooster.ISAD2.AbstractArtist
import nl.jappieklooster.ISAD2.backtracking.graph.Graph;
import nl.jappieklooster.ISAD2.backtracking.graph.Node;
import nl.jappieklooster.vector.Vector2D
import nl.jappieklooster.Log;

class Artist extends AbstractArtist{

	static final int nodeSize = 30
	private Graph graph
	@Override
	Image render(){
		super.render()
		graph = Graph.createGraph()
		Graphics g = image.graphics
		g.setColor(Color.RED)
		graph.nodes.each{Node node ->

			Vector2D nodeTransPos = translatePosition(node.position)
			node.attached.each{
				g.drawLine(nodeTransPos + new Vector2D(nodeSize/2), translatePosition(it.position) + new Vector2D(nodeSize/2))
			}
		
			g.fillOval(nodeTransPos.x , nodeTransPos.y,  nodeSize, nodeSize)

		}
		return image
	}
	Vector2D translatePosition(Vector2D position){
		return (
			new Vector2D(image.width, image.height) / graph.size
        ) * position
	}
}
