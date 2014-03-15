package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

class XComparator extends BaseComparator{

	@Override
	public int compare(Vector2D one, Vector2D two) {
		double result = one.X - two.X
		
		// the least likley is equality
		return finalStep(result)
		
	}

}
