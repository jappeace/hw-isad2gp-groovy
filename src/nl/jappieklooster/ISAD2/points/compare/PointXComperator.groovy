package nl.jappieklooster.ISAD2.points.compare

import nl.jappieklooster.ISAD2.points.structs.PointD

class PointXComperator implements Comparator<PointD>{

	@Override
	public int compare(PointD one, PointD two) {
		// TODO Auto-generated method stub
		return one.x - two.x
	}

}
