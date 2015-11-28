
import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

public class TestDecor {
	DecorDef dd = new DecorDef(1200, 600, 50, 25,25);

	@Test
	public final void testPlaceLibre() {

		Cible cible = new Cible(dd);
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
