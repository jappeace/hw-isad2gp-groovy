package nl.jappieklooster.ISAD2.points
import nl.jappieklooster.ISAD2.points.structs.PointD
class PointGenerator {
	PointD[] points
	int width = 100
	int height = 100
	Random r = new Random();

	void startGeneration(int amount){
			
		(0..amount).each {
			points[it] = new PointD(r.nextDouble() % width, r.nextDouble() % height);
		}
	}
	
}
