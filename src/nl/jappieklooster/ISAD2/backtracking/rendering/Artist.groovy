package nl.jappieklooster.ISAD2.backtracking.rendering

import java.awt.Graphics
import java.awt.Image
import java.awt.Color;

import nl.jappieklooster.ISAD2.AbstractArtist
import nl.jappieklooster.ISAD2.backtracking.solving.ProblemFactory
import nl.jappieklooster.graph.GridGraph;
import nl.jappieklooster.graph.Node;
import nl.jappieklooster.vector.Vector2D
import nl.jappieklooster.Log;

class Artist extends AbstractArtist{

	static final int nodeSize = 30
	GridGraph<Boolean> graph = ProblemFactory.createGraph()
	Deque<Node<Boolean>> path
	@Override
	Image render(){
		super.render()
		Graphics g = image.graphics
		g.setColor(Color.RED)
		graph.nodes.each{Node node ->

			Vector2D nodeTransPos = translatePosition(node.position)
			node.attached.each{
				g.drawLine(translateLinePosition(nodeTransPos), translatePosAndLine(it.position))
			}
		
			g.fillOval(nodeTransPos.x , nodeTransPos.y,  nodeSize, nodeSize)
			
			
		}
		g.setColor(Color.GREEN)
        while(path?.size() > 0){
                Node<Boolean> first = path.pollFirst();
                Node<Boolean> second = path.peekFirst();
                
                if(first && second){
                        g.drawLine(translatePosAndLine(first.position), translatePosAndLine(second.position))
                }
        }

		return image
	}
	Vector2D translatePosition(Vector2D position){
		return (
			new Vector2D(image.width, image.height) / graph.size
        ) * position
	}
	
	Vector2D translateLinePosition(Vector2D position){
		position + new Vector2D(nodeSize/2)
	}
	Vector2D translatePosAndLine(Vector2D position){
		translateLinePosition(translatePosition(position))
	}
	
	
}
