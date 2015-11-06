
import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

public class TestCible {
	DecorDef dd = new DecorDef(new Dimension(1200, 600), 50, 1, 1, 1.7);

	@Test
	public final void testPlaceLibre() {

		Cible cible = new Cible(dd,new Coord(10,10),20);
		dd.ajouterCible(cible);
		
		assertFalse(dd.placeLibre(cible.get_X(), cible.get_Y(), cible.getTaille()));
		assertTrue(dd.placeLibre(cible.get_X()+cible.getTaille()+1, cible.get_Y(), 10));
		assertTrue(dd.placeLibre(cible.get_X(),cible.get_Y()-cible.getTaille()-1, 20));

	}

	@Test
	public final void gagne() {

		Cible cible = new Cible(dd);
		dd.ajouterCible(cible);
		cible.toucher();
		assertTrue(dd.gagne());

	}
}
