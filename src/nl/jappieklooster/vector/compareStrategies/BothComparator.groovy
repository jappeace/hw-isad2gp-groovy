package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

class BothComparator extends BaseComparator{

	@Override
	public int compare(Vector2D one, Vector2D two) {
		/** a big problem is how to differentiate the same data type double x from y, so I just take always the square root of X and do nothing with Y */
		double result = one.Y * Math.sqrt(one.X) - two.Y * Math.sqrt(two.X)
		return finalStep(result)
		
	}

}
