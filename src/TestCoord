
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCoord {

	@Test
	public final void testDistancesCoord() {

		Coord coord = new Coord(1, 1);

		assertTrue(coord.distance(new Coord(3, 3)) == (int) (Math.sqrt(8)));
		assertTrue(coord.distance(new Coord(1, 5)) == (int) (Math.sqrt(16)));

	}

	@Test
	public final void testEquals() {

		Coord coord = new Coord(10, 10);

		assertTrue(coord.equals(new Coord(10, 10)));

	}

}
