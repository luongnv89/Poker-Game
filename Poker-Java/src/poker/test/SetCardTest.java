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
import poker.object.SetCard;

public class SetCardTest extends TestCase {

	private SetCard setCard;
	private ArrayList<Card> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Initiate an ArrayList. Create a SetCard with the ArrayList.
	 * */
	@Before
	public void setUp() throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new java.util.Date();

		System.out
				.println("********************************************************************");
		System.out.println("Execution Date/Time " + dateFormat.format(date));
		System.out
				.println("********************************************************************\n");

		list = new ArrayList<Card>();

		list.add(new Card(3));
		list.add(new Card(14));
		list.add(new Card(2));
		list.add(new Card(30));
		list.add(new Card(5));

		setCard = new SetCard(list);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testisEmpty() {
		boolean setEmpty = false;
		assertEquals(setEmpty, setCard.isEmpty());
	}

	@Test
	public void testisSetCard() {
		boolean set = true;
		assertEquals(set, setCard.isSetCard());
	}

	@Test
	public void testisUnique() {
		boolean unique = true;
		assertEquals(unique, setCard.isUnique());
	}

	@Test
	public void testisA() {
		boolean a = true;
		assertEquals(a, setCard.isA());
	}

	@Test
	public void testisK() {
		boolean k = false;
		assertEquals(k, setCard.isK());
	}

	@Test
	public void testisPair() {
		boolean pair = false;
		assertEquals(pair, setCard.isPair());
	}

	@Test
	public void testisThree() {
		boolean three = false;
		assertEquals(three, setCard.isThree());
	}

	
	@Test
	public void testgetMax() {
		int maxExpected = 5;
		assertEquals(maxExpected, setCard.getMax());
	}

	@Test
	public void testgetMaxCard() {
		int maxCardExpected = 5;
		
		assertEquals(maxCardExpected, setCard.getMaxCard().getId());
	}

	@Test
	public void testgetPair() {
		ArrayList<Card> pairEx = new ArrayList<Card>();

//		pairEx.add(new Card(29));
//		pairEx.add(new Card(16));
		

		assertTrue("get wrong pair!", equalArrayList(pairEx, setCard.getPair()));
	}

	@Test
	public void testgetThree() {
		ArrayList<Card> three = new ArrayList<Card>();

//		three.add(new Card(42));
//		three.add(new Card(16));
//		three.add(new Card(29));

		assertTrue("get wrong three!",
				equalArrayList(three, setCard.getThree()));
	}

	@Test
	public void testsort() {
		setCard.sort();
		assertTrue("sort false!", Sorted(setCard.listCard));
	}

	@Test
	public void testcompareSetCard() {
		int compareEx = 0;

		ArrayList<Card> listTest = new ArrayList<Card>();

		for (int i = 1; i < list.size() + 1; i++) {
			listTest.add(new Card(i + 13));
		}

		SetCard setTest = new SetCard(listTest);

		assertEquals(compareEx, setCard.compareSetCard(setTest));
	}

	/**
	 * Function compares an ArrayList to another.
	 * */
	public static boolean equalArrayList(ArrayList<Card> list1,
			ArrayList<Card> list2) {
		ArrayList<Card> list11 = new ArrayList<Card>();
		list11.addAll(list1);

		ArrayList<Card> list21 = new ArrayList<Card>();
		list21.addAll(list2);
		if (list11.size() != list21.size())
			return false;
		if (list11.size() == list21.size() && list11.size() == 0)
			return true;
		for (int i = 0; i < list11.size(); i++) {
			for (int j = 0; j < list21.size(); j++) {
				if (list11.get(i).getId() == list21.get(j).getId()) {
					list21.remove(j);
				}
			}
		}
		return list21.size() == 0;
	}

	/**
	 * Function check an ArrayList is sorted from highest to lowest.
	 * */
	public static boolean Sorted(ArrayList<Card> l) {
		if(l.size() == 0)
			return true;
		for (int i = 0; i < l.size() - 1; i++) {
			if (l.get(i).getValue() < l.get(i + 1).getValue())
				return false;
		}
		return true;
	}
}
