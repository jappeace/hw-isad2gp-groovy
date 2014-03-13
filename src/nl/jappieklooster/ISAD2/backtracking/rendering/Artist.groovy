package nl.jappieklooster.ISAD2.backtracking.rendering

import java.awt.Graphics
import java.awt.Image
import java.awt.Color;

import nl.jappieklooster.ISAD2.AbstractArtist
import nl.jappieklooster.ISAD2.backtracking.graph.Graph;
import nl.jappieklooster.Log;

class Artist extends AbstractArtist{

	static final int nodeSize = 20
	static final int nodeOffset = 4 
	private Graph graph
	@Override
	Image render(){
		super.render()
		graph = Graph.createGraph()
		Graphics g = image.graphics
		int y = 0
		int dotCorrection = (nodeOffset) /2
		g.setColor(Color.RED)
		graph.nodes.each{

			g.fillOval(it.position.x * nodeSize, it.position.y * nodeSize,  nodeSize - nodeOffset, nodeSize - nodeOffset)
			Log.debug("printing node: {0}", it.position)

		}
		return image
	}
}
