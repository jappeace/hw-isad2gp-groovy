package nl.jappieklooster.ISAD2.points.rendering

import java.awt.Color;
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image

import nl.jappieklooster.ISAD2.AbstractArtist
import nl.jappieklooster.ISAD2.points.PointGenerator
import nl.jappieklooster.ISAD2.points.strategies.ClosePointSolver
import nl.jappieklooster.ISAD2.points.structs.Line

class Artist extends AbstractArtist{

	PointGenerator generator
	ClosePointSolver solver
	static final Dimension pointSize = new Dimension(5,5)
	
	@Override
	Image render(){
		super.render()
		Graphics g = image.graphics

		g.setColor(Color.RED)
		generator.points.each{
			g.drawOval(it.x, it.y, pointSize.width, pointSize.height)
		}
		
		g.setColor(Color.BLUE)
		Line closest = solver.solve(generator.points)
		g.drawLine(closest.one.x, closest.one.y, closest.two.x, closest.two.y)
	}
}
