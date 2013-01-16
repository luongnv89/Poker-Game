package poker.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.object.Card;
import poker.object.Fighting;

public class FightingTest extends TestCase {

	private Fighting fight;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new java.util.Date();

		System.out
				.println("********************************************************************");
		System.out.println("Execution Date/Time " + dateFormat.format(date));
		System.out
				.println("********************************************************************\n");

		ArrayList<Card> list1 = new ArrayList<Card>();
		ArrayList<Card> list2 = new ArrayList<Card>();

		list1.add(new Card(2));
		list1.add(new Card(3));
		list1.add(new Card(5));
		list1.add(new Card(7));
		list1.add(new Card(49));

		list2.add(new Card(14));
		list2.add(new Card(4));
		list2.add(new Card(6));
		list2.add(new Card(8));
		list2.add(new Card(9));

		fight = new Fighting(list1, list2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testvalidFighting() {
		boolean valid = true;
		assertEquals(valid, fight.validFighting());
	}

	@Test
	public void testbeatRank() {
		int rankEx = 0;
		assertEquals(rankEx, fight.beatRank());
	}

	@Test
	public void testbeat() {
		int samerankEx = 2;
		assertEquals(samerankEx, fight.beat());
	}

}
