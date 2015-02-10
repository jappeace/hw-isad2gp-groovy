package nl.jappieklooster.vector.compareStrategies

import nl.jappieklooster.vector.Vector2D

abstract class BaseComparator implements Comparator<Vector2D>{
	/** handles the double to int conversion, without truncation*/
	int finalStep(double result){
		if(result < 0){
			return -1
		}else if(result > 0){
			return 1
		}
		// the least likley is equality
		return 0
	}

}
