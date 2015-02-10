package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

class YComparator extends BaseComparator{

	@Override
	public int compare(Vector2D one, Vector2D two) {
		return finalStep(one.y - two.y)
		
	}

}
