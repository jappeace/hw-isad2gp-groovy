package nl.jappieklooster.ISAD2.Points

class PointD {

	double x
	double y
	
	PointD calcClosest(PointD one, PointD two){
		
		double a = y - one.y	
		double b = x - one.x

		double distanceOne = Math.sqrt(a*a + b*b)
		
		a = y - two.y
		b = x - two.x

		double distanceTwo = Math.sqrt(a*a + b*b)
		
		if(distanceOne < distanceTwo){
			return one
		}else{
			return two
		}
	}
}
