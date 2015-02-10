package nl.jappieklooster.ISAD2.points
import java.awt.Dimension
import nl.jappieklooster.ISAD2.points.structs.GameObject
import nl.jappieklooster.ISAD2.points.structs.PointD
class LevelGenerator {
	GameObject[] objects
	PointGenerator generator

	LevelGenerator(Dimension limit){
		generator = new PointGenerator(limit)
	}
	void startGeneration(int amount){

		objects = new GameObject[amount]
		generator.startGeneration(amount, 
			{int num, PointD point->
                objects[num] = new GameObject()
                objects[num].position = point
                objects[num].isBlue = generator.random.nextBoolean()
			}
		)
	}
}
