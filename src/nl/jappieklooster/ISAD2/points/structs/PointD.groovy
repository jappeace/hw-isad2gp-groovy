package nl.jappieklooster.ISAD2.points.structs

class PointD {

	double x
	double y
	
	PointD calcClosest(PointD one, PointD two){
		
		if(new Line(this, one).getLength() < new Line(this, two).getLength()){
			return one
		}else{
			return two
		}
	}
}
