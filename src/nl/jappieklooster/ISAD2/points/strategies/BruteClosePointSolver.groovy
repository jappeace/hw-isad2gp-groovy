package nl.jappieklooster.ISAD2.points.strategies

import nl.jappieklooster.ISAD2.points.structs.Line
import nl.jappieklooster.ISAD2.points.structs.PointD

class BruteClosePointSolver implements ClosePointSolver{

	Line solve(PointD[] points){
		
		if(points.length == 0){
			return new Line()
		}
		if(points.length == 1){
			return new Line(points[0], poinst[0])
		}
		// longest possible line (for memory available)
		Line shortCandidate = new Line(new PointD(double.MAX_VALUE, double.MAX_VALUE), new PointD(double.MIN_VALUE, double.MIN_VALUE))
		
		points.each{ PointD candidate
			Line consideration = findShortest(candidate, points)
			shortCandidate = consideration.length < shortCandidate.length ? consideration : shortCandidate
		}
		return shortCandidate
	}
	private Line findShortest(PointD candidate, PointD points){
		Line shortCandidate = new Line(candidate, points.find{candidate != it})
		points.each{
			// skip if its the same
			if(candidate == it){
				return
			}
			Line consideration = new Line(candidate, it)	
			shortCandidate = consideration.length < shortCandidate.length ? consideration : shortCandidate
		}
		return shortCandidate
	}
}
