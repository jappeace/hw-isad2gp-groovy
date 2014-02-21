package nl.jappieklooster.ISAD2.points.strategies;

import nl.jappieklooster.ISAD2.points.structs.Line;
import nl.jappieklooster.ISAD2.points.structs.PointD;

public interface ClosePointSolver {

	Line solve(PointD[] points);
	
}
