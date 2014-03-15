package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

class XComparator extends BaseComparator{

	@Override
	public int compare(Vector2D one, Vector2D two) {
		// the least likley is equality
		return finalStep(one.x - two.x)
		
	}

}
