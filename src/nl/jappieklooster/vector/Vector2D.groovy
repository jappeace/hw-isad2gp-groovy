package nl.jappieklooster.vector

import nl.jappieklooster.vector.compareStrategies.BothComparator

/**
 * this is a basic 2 double container with all the operator overloading that made sense, so no getat and putat but practicly evreything else
 * I chose doubles, because java is going to be slow anyways, so Might aswell store a bunch of data.
 * Besides this class is very handy in cartesian situations, which is considerd a 2D space, which gives the 2D a double meaning...
 * @author jappie
 *
 */
class Vector2D implements Cloneable, Comparable<Vector2D>{
	static final double defaultValue = 0
	double x, y
	
	/** WARNING the compare strategy is not considerd to be part of the objectState
	* This means the indivudaul comparators and the equals methods don't take in acount which strategy is used
	* By default they all use the same (the bothcomparator)
	*/
	Comparator<Vector2D> compareStrategy
	//////// constructors
	Vector2D(){
		this(defaultValue,defaultValue)
	}
	/** copy constructor, because handy*/
	Vector2D(Vector2D input){
		this(input.X, input.Y)
	}
	Vector2D(double both){
		this(both, both)
	}
	Vector2D(double x, double y){
		this.x = x
		this.y = y
		compareStrategy = new BothComparator()
	}

	@Override
	Object clone(){
		// this class only contains primitives, so changing anything is unecisary, as specified in documentation
		return super.clone();
	}

	@Override
	String toString(){
		return "(" + x + ", " + y + ")"
	}
	///////// aritmatics
	@Override
	Vector2D plus(Vector2D rhs){
		new Vector2D(
			this.x + rhs.x,
			this.y + rhs.y
		)
	}
	@Override
	Vector2D minus(Vector2D rhs){
		new Vector2D(
			this.x - rhs.x,
			this.y - rhs.y
		)
	}
	@Override
	Vector2D multiply(Vector2D rhs){
		new Vector2D(
			this.x * rhs.x,
			this.y * rhs.y
		)
	}
	@Override
	Vector2D power(Vector2D rhs){
		new Vector2D(
			this.x ** rhs.x,
			this.y ** rhs.y
		)
	}
	@Override
	Vector2D div(Vector2D rhs){
		new Vector2D(
			this.x / rhs.x,
			this.y / rhs.y
		)
	}
	@Override
	Vector2D mod(Vector2D rhs){
		new Vector2D(
			this.x % rhs.x,
			this.y % rhs.y
		)
	}

	@Override
	Vector2D next(){
		this.x++
		this.y++
		return this
	}
	@Override
	Vector2D previous(){
		this.x--
		this.y--
		return this
	}

	@Override
	Vector2D negative(){
		new Vector2D(
			-this.x, 
			-this.y
		)
	}
	
	@Override
	Vector2D positive(){
		new Vector2D(
			+this.x, 
			+this.y
		)
	}
	/////// comparison
	/** note this equals does a straight and cross comparison, either X and X and Y and Y or X and Y and Y and X, because the way the compareto is handled*/
	@Override
	boolean equals(Object to){
		if(!to instanceof Vector2D){
			return false
		}
		Vector2D target = (Vector2D) to
		if(target.is(this)){
			return true
		}

		return compareStrategy.compare(this, target) == 0
		
	}
	@Override
	int compareTo(Vector2D to) {
		return compareStrategy.compare(this, to);
	}

	@Override
	boolean isCase(Vector2D lhs){
		return lhs == this
	}

	@Override
	int hashCode()
	{

		// use the sqrt of one field to differentiate between the two
		return (this.x * Math.sqrt(this.y)).hashCode()
	}
	
}
