package poker.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.object.Card;

/**
 * <b>extends</b> {@link TestCase} using <b>setUp()</b> to assign value for id
 * of a card. <br>
 * Global variables:</br>
 * <ul>
 * <li>private integer id</li>
 * <li>private Card card</li>
 * </ul>
 */

public class CardTest extends TestCase {

	private int id;
	private Card card;

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

		id = 20;
		card = new Card(id);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * If the value of id greater then <b>0</b> and less than <b>53</b> then
	 * return <b>TRUE</b>. <br>
	 * If not, return <b>FALSE</b> and inform that it is NOT a card.</br>
	 * */
	@Test
	public void testisCard() {
		boolean isC = true;
		assertEquals(isC, card.isCard());
	}

	/**
	 * return the value equal to the id if it is a Card.
	 * */
	@Test
	public void testgetId() {
		int idexpected = 20;
		int idresult = card.getId();
		assertEquals(idexpected, idresult);
	}

	/**
	 * return the value of suite of the card equal if it is a Card.
	 * */
	@Test
	public void testgetSuit() {
		int suitexpected = 2;
		int suiteresult = card.getSuit();
		assertEquals(suitexpected, suiteresult);

	}

	/**
	 * return the value of the card if it is a Card.
	 * */
	@Test
	public void testgetValue() {
		int valueexpected = 7;
		int valueresult = card.getValue();
		assertEquals(valueexpected, valueresult);
	}
}
