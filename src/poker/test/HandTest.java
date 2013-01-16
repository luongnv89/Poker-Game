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
import poker.object.Hand;

/**
 * <b>extends</b> {@link TestCase} using <b>setUp()</b> to initial cards and
 * hand. <br>
 * Global variables:</br>
 * <ul>
 * <li>private Hand hand</li>
 * <li>private ArrayList<Card> card</li>
 * </ul>
 * */
public class HandTest extends TestCase {

	private Hand hand;
	private ArrayList<Card> card;

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

		card = new ArrayList<Card>();
		card.add(0, new Card(11));
		card.add(1, new Card(12));
		card.add(2, new Card(13));
		card.add(3, new Card(1));
		card.add(4, new Card(10));
		
		hand = new Hand(card);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * If cards are different and Hand has 5 cards Then return TRUE. <br>
	 * If Hand has the number of cards different from 5 OR there are at least 2
	 * cards the same Then return FALSE and inform NOT Hand.</br>
	 * */
	@Test
	public void testisHand() {
		boolean isH = true;
		assertEquals(isH, hand.isHand());

	}
	
	@Test
	public void testisFour() {
		boolean four = false;
		assertEquals(four, hand.isFour());
	}

	@Test
	public void testisFlush() {
		boolean flush = false;
		assertEquals(flush, hand.isFlush());
	}

	@Test
	public void testisStraight() {
		boolean straight = false;
		assertEquals(straight, hand.isStraight());
	}

	/**
	 * the rank value of Hand.
	 * */
	@Test
	public void testgetRank() {
		int rankexpected = 10;
		int rankresult = hand.getRank();
		assertEquals(rankexpected, rankresult);
	}

}
