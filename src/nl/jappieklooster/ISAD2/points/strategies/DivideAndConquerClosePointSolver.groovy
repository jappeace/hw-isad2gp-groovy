package nl.jappieklooster.ISAD2.points.strategies

import nl.jappieklooster.ISAD2.points.compare.PointXComperator
import nl.jappieklooster.ISAD2.points.compare.PointYComperator
import nl.jappieklooster.ISAD2.points.structs.Line
import nl.jappieklooster.ISAD2.points.structs.PointD

class DivideAndConquerPointSolver implements ClosePointSolver{
	Comparator<PointD>[] comparators = [new PointXComperator(), new PointYComperator()]
	private final BruteClosePointSolver bruteSolver = new BruteClosePointSolver()
	Line solve(PointD[] points){
		
		return shortCandidate
	}
	
	Line recursiveSolve(PointD[] points, int xory){
		// check for base case
		if(points.length < 3){
			return new Line(points[0], points[1])
		}
		if(points.length == 3){
			return bruteSolver.solve(points)
		}
		// divide into a left and right list
		xory = (xory + 1 )% 2 // 0 == x
		Arrays.sort(points, comparators[xory])
		
		// calculate the closest points left and right (or top and bottom depending on orientation in xory) using 2 recursive calls
		PointD[][] fracturedPoints = points.collate((int) ((points.length / 2).trunc() + 1))
		Line one = recursiveSolve(fracturedPoints[0], xory)
		Line two = recursiveSolve(fracturedPoints[1], xory)
		// is left shorter or right? Calculate delta.
		Line shortest = one.length < two.length ? one : two

		// calculate strip
		double strip = Math.sqrt((shortest.one.y - shortest.two.y) ** 2)
		if(xory == 0){
			//x
			strip = Math.sqrt((shortest.one.x - shortest.two.x) ** 2)
		}
		
		double width = points[points.length - 1].x
		double startX = width / 2 - strip / 2
		double endX   = width / 2 - strip / 2
		// find the closest points in the strip
		PointD[] stripPoints = points.find{ startX >= it.x && endX <= it.x}
		
		// find the final result
	}
}
