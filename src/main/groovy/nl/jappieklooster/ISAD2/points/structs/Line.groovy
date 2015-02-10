package nl.jappieklooster.ISAD2.points.structs

class Line {
	PointD one
	PointD two
	Line(PointD first, PointD second){
		one = first
		two = second
	}
	double getLength(){
		Math.sqrt((two.y - one.y)**2 + (two.x - one.x)**2)
	}
	
	boolean startOrEndEquals(PointD item){
		one == item || two == item
	}
	
	static Line createLongestLine(){
		new Line(new PointD(Double.MAX_VALUE, Double.MAX_VALUE), new PointD(Double.MIN_VALUE, Double.MIN_VALUE))
	}
}
