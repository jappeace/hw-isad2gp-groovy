package nl.jappieklooster.ISAD2.points.structs

class Line {
	PointD one
	PointD two
	double getLength(){
		Math.sqrt((two.y - one.y)**2 + (two.x - one.x)**2)
	}
}
