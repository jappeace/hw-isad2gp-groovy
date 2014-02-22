package nl.jappieklooster.ISAD2.points.rendering

import java.awt.Color;
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image

import nl.jappieklooster.ISAD2.AbstractArtist
import nl.jappieklooster.ISAD2.points.LevelGenerator
import nl.jappieklooster.ISAD2.points.strategies.ClosePointSolver
import nl.jappieklooster.ISAD2.points.structs.Line

class Artist extends AbstractArtist{

	LevelGenerator level
	ClosePointSolver solver
	static final Dimension pointSize = new Dimension(6,6)
	
	@Override
	Image render(){
		super.render()
		Graphics g = image.graphics
		Line closest = solver.solve(level.generator.points)
		int sameType = 0

		level.objects.each{

			if(closest.startOrEndEquals(it.position)){
				
				double multi = 3
				Dimension pointSize = new Dimension(
					(int) (multi * Artist.pointSize.width).round(),
					(int) (multi * Artist.pointSize.width).round()
                )
				g.setColor(Color.YELLOW)
                g.fillOval(
					(int) (it.position.x - pointSize.width  / 2).round(), 
                    (int) (it.position.y - pointSize.height / 2).round(), 
                    (int) pointSize.width .round(),
                    (int) pointSize.height.round()
                )
				
			}
            g.setColor(Color.RED)
			if(it.isBlue){
				g.setColor(Color.BLUE)

				if(closest.startOrEndEquals(it.position)){
					// if only one is blue it will be uneven
					sameType++
				}
			}
			

			g.fillOval(
				(int) (it.position.x - pointSize.width  / 2).round(), 
                (int) (it.position.y - pointSize.height / 2).round(), 
				(int) pointSize.width .round(),
				(int) pointSize.height.round()
			)
			
		}
		
		g.setColor(Color.GREEN)
		if(sameType%2==0){
			g.setColor(Color.BLACK)
		}
		g.drawLine(
			(int) closest.one.x.round(), 
			(int) closest.one.y.round(), 
			(int) closest.two.x.round(), 
			(int) closest.two.y.round()
		)
	}
}
