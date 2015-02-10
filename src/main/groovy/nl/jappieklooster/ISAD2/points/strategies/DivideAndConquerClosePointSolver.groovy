package nl.jappieklooster.ISAD2.points.strategies

import nl.jappieklooster.ISAD2.points.compare.PointXComperator
import nl.jappieklooster.ISAD2.points.compare.PointYComperator
import nl.jappieklooster.ISAD2.points.structs.Line
import nl.jappieklooster.ISAD2.points.structs.PointD

class DivideAndConquerPointSolver implements ClosePointSolver{
	Comparator<PointD>[] comparators = [new PointXComperator(), new PointYComperator()]

	private final BruteClosePointSolver bruteSolver = new BruteClosePointSolver()
	// below this number use brute force
	private static final int BelowUseBrute = 3
	Line solve(PointD[] points){
		return recursiveSolve(points, 0)
	}
	
	Line recursiveSolve(PointD[] points, int xory){

		// check for base case
		if(points == null){
			return Line.createLongestLine()
		}
		if(points.length < 3){
			return new Line(points[0], points[1])
		}
		if(points.length <= BelowUseBrute){
			return bruteSolver.solve(points)
		}
		// divide into a left and right list
		xory = (xory + 1 )% 2 // 0 == x
		Arrays.sort(points, comparators[xory])
		
		// calculate the closest points left and right (or top and bottom depending on orientation in xory) using 2 recursive calls
		List<List<PointD>> fracturedPoints = points.toList().collate((int) ((points.length / 2)))
		Line one = recursiveSolve((PointD[])fracturedPoints[0].toArray(), xory)
		Line two = recursiveSolve((PointD[])fracturedPoints[1].toArray(), xory)
		// is left shorter or right? Calculate delta.
		Line shortest = one.length < two.length ? one : two

		// calculate strip
		PointD[] stripPoints
		if(xory == 0){
			//x
			double strip = Math.sqrt((shortest.one.x - shortest.two.x) ** 2)
			double width = points[points.length - 1].x
			double startX = width / 2 - strip / 2
			double endX   = width / 2 + strip / 2
			// find the closest points in the strip
			stripPoints = points.find{ startX >= it.x && endX <= it.x}
		}else{
            double strip = Math.sqrt((shortest.one.y - shortest.two.y) ** 2)
			double height = points[points.length - 1].y
			double startY = height / 2 - strip / 2
			double endY   = height / 2 + strip / 2
			// find the closest points in the strip
			stripPoints = points.find{ startY >= it.y && endY <= it.y}
		}

		// find the final result
		Line stripLine = recursiveSolve(stripPoints, xory)
		return shortest.length < stripLine.length ? shortest : stripLine
	}
}
