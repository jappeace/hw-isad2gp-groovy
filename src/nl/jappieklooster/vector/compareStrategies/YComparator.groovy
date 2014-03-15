package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

class YComparator extends BaseComparator{

	@Override
	public int compare(Vector2D one, Vector2D two) {
		double result = one.Y - two.Y
		return finalStep(result)
		
	}

}
