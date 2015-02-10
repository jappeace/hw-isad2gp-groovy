package nl.jappieklooster.ISAD2.points
import java.awt.Dimension
import nl.jappieklooster.ISAD2.points.structs.PointD
class PointGenerator {
	PointD[] points
	Random random = new Random();
	Dimension limit

	PointGenerator(Dimension limit){
		this.limit = limit	
	}
	void startGeneration(int amount, Closure onCreation = null){
			
		points = new PointD[amount]
		(0..(amount -1)).each {
			points[it] = new PointD(random.nextDouble() * limit.width, random.nextDouble() * limit.height);
			if(onCreation){
                onCreation(it, points[it])
			}
		}
	}
	
}
