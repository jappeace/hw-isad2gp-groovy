package nl.jappieklooster.tests;

import static org.junit.Assert.*;
import nl.jappieklooster.vector.Vector2D

import org.junit.Test;

class Vector2DTests {
	@Test
	void equalstest(){
		assertEquals(new Vector2D(), new Vector2D())
        assertEquals(new Vector2D(4), new Vector2D(4))
        assertEquals(new Vector2D(4, -3), new Vector2D(4, -3))
        assertEquals(new Vector2D(-3, 0.5), new Vector2D(-3, 0.5))
        assertEquals(new Vector2D(0.6, -3), new Vector2D(0.6, -3))
        assertEquals(new Vector2D(0.5, -3), new Vector2D(0.5, -3))
	}
	@Test
	void clonetest(){
        assertEquals(new Vector2D(4, -3).clone(), new Vector2D(4, -3))
	}
	///////// aritmatics
	@Test
	void plus(){
        assertEquals(new Vector2D(4, -3) + new Vector2D(2, 5), new Vector2D(6, 2))
	}
	@Test
	void minus(){
        assertEquals(new Vector2D(4, -3) - new Vector2D(2, 5), new Vector2D(2, -8))
	}
	@Test
	void multiply(){
        assertEquals(new Vector2D(4, -3) * new Vector2D(2, 5), new Vector2D(8, -15))
	}
	@Test
	void power(){
        assertEquals(new Vector2D(4, -3) ** new Vector2D(2, 5), new Vector2D(16, -243))
	}
	@Test
	void div(){
        assertEquals(new Vector2D(4, -3) / new Vector2D(2, 5), new Vector2D(2, -0.6))
	}
	@Test
	void mod(){
        assertEquals(new Vector2D(4, -3) % new Vector2D(2, 5), new Vector2D(0, -3))
	}

	@Test
	void next(){
        assertEquals(++new Vector2D(4, -3), new Vector2D(5, -2))
	}
	@Test
	void previous(){
        assertEquals(--new Vector2D(4, -3), new Vector2D(3, -4))
	}

	@Test
	void negative(){
		Vector2D one = -new Vector2D(4, -3)
		Vector2D two = new Vector2D(-4,3)
        assertEquals(one, two)
	}
	
	@Test
	void positive(){
        assertEquals(+new Vector2D(4, -3), new Vector2D(4, -3))
	}
}
