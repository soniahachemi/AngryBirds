package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlleur.Coord;
import Modele.Cible;
import Vue.DecorDef;
import Vue.Plan;
/**
 * Classe TestProjet tests
 * 
 * @author Groupe L5
 * 
 */
public class TestProjet {


	
		/**
		 * Tests du plan
		 */
		@Test
		public final void testPlan_Concret() {
			Coord c;
			Plan p = new Plan(new Coord(100, 100));
			//Plan p = new Plan(new Coord(100, 100));
			assertTrue(p.plan_Concret(new Coord(100, 100)).equals(
					new Coord(200, 0)));
			assertTrue(p.plan_Concret(new Coord(-20, -20)).equals(
					new Coord(80, 120)));
		}

		@Test
		public final void testConcret_Plan() {
			Plan p = new Plan(new Coord(50, 50));
			assertTrue(p.concret_Plan(new Coord(50, 50))
					.equals(new Coord(0, 0)));
			assertTrue(p.concret_Plan(new Coord(20, 40)).equals(
					new Coord(-30, 10)));
		}

		/**
		 * Test des Coordonnées
		 */
		@Test
		public final void testDistancesCoord() {

			Coord coord = new Coord(1, 1);

			assertTrue(coord.distance(new Coord(3, 3)) == (int)(Math.sqrt(8)));
			assertTrue(coord.distance(new Coord(1, 5)) == (Math.sqrt(16)));

		}

		@Test
		public final void testEquals1() {

			Coord coord = new Coord(10, 10);

			assertTrue(coord.equals(new Coord(10, 10)));
			assertTrue(coord.distance(new Coord(10, 10)) == 0);
			

		}
		
		/**
		 * Test du decor
		 */
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

