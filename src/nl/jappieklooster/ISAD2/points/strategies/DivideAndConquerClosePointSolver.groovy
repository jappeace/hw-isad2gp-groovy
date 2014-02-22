package nl.jappieklooster.ISAD2.points.strategies

import nl.jappieklooster.ISAD2.points.structs.Line
import nl.jappieklooster.ISAD2.points.structs.PointD

class DivideAndConquerPointSolver implements ClosePointSolver{
	private final BruteClosePointSolver bruteSolver = new BruteClosePointSolver()
	Line solve(PointD[] points){
		
		return shortCandidate
	}
	
	Line recursiveSolve(PointD[] points){
		// check for base case
		if(points.length < 3){
			return new Line(points[0], points[1])
		}
		if(points.length == 3){
			return bruteSolver.solve(points)
		}
		// divide into a left and right list
		// calculate the closest points left and right using 2 recursive calls
		// is left shorter or right? Calculate delta.
		// calculate strip
		// find the closest points in the strip
		// find the final result
	}
}
