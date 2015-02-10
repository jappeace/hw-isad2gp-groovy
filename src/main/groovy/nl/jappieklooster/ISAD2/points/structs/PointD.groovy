package nl.jappieklooster.ISAD2.points.structs

class PointD {

	double x
	double y
	
	PointD(double x, double y){
		this.x = x
		this.y = y
	}
	@Override
	boolean equals(Object to){
		if(!(to instanceof PointD)){
			return false
		}
		PointD target = (PointD) to
		if(to.is(this)){
			return true
		}
		return target.x == this.x && target.y == this.y
	}
}
