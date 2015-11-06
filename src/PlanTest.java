import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe PlanTest
 * tests
 * @author Quentin  Spinnewyn
 *
 */
public class PlanTest {

	/**
	 * Tests du plan
	 */
	@Test
	public final void testPlan_Concret(){
		Plan p = new Plan(new Coord(100,100));
		assertTrue(p.plan_Concret(new Coord(100,100)).equals(new Coord(200,0)));
		assertTrue(p.plan_Concret(new Coord(-20,-20)).equals(new Coord(80,120)));
	}
	
	/**
	 * Idem
	 */
	@Test
	public final void testConcret_Plan(){
		Plan p = new Plan(new Coord(50,50));
		assertTrue(p.concret_Plan(new Coord(50,50)).equals(new Coord(0,0)));
		assertTrue(p.concret_Plan(new Coord(20,40)).equals(new Coord(-30,10)));
	}
}
