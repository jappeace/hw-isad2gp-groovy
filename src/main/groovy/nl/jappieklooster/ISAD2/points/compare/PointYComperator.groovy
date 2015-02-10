package nl.jappieklooster.ISAD2.points.compare

import nl.jappieklooster.ISAD2.points.structs.PointD

class PointYComperator implements Comparator<PointD>{

	@Override
	public int compare(PointD one, PointD two) {
		// TODO Auto-generated method stub
		return one.y - two.y
	}

}
