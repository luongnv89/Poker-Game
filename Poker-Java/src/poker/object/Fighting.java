package poker.object;

import java.util.ArrayList;

/**
 * Fighting is a fighting of two hand card.
 * 
 * */
public class Fighting {
	/**
	 * Hand 1: The hand 1
	 * */
	Hand hand1 = new Hand();
	/**
	 * Hand 1: The hand 2
	 * */
	Hand hand2 = new Hand();

	/**
	 * Construct a fighting with two hand
	 * */
	public Fighting(ArrayList<Card> list1, ArrayList<Card> list2) {
		hand1.listCard.addAll(list1);
		hand2.listCard.addAll(list2);
	}

	/**
	 * Check the fighting is valid or not
	 * 
	 * @return TRUE if the fighting is valid </br>FALSE if in two hand has two
	 *         cards same id or has an invalid hand
	 * */
	public boolean validFighting() {
		ArrayList<Card> listAll = new ArrayList<Card>();
		listAll.addAll(hand1.listCard);
		listAll.addAll(hand2.listCard);

		SetCard checkUnique = new SetCard(listAll);
		return checkUnique.isUnique() && hand1.isHand() && hand2.isHand();
	}

	/**
	 * Two hand fight by rank.
	 * 
	 * @return 1: if the rank of hand 1 is bigger than hand 2 </br>2: if the
	 *         rank of hand 2 is bigger than hand 1</br> 0: if the rank of hand
	 *         1 equal to the rank of hand 2 </br>-1: if there's an error
	 * */
	public int beatRank() {
		if (!this.validFighting()) {
			System.out
					.println("ERROR!Invalide fighting! Some hand isn't valid hand or two card same id in the two hand");
			return -1;
		}
		if (hand1.getRank() > hand2.getRank())
			return 1;
		else if (hand1.getRank() < hand2.getRank())
			return 2;
		else
			return 0;
	}

	/**
	 * Get the hand is winer finally.
	 * 
	 * @return 1: if the hand 1 is winer</br> 2: if the hand 2 is winer </br>0:
	 *         if the two hands are fair </br>-1: if there's an error
	 * */
	public int beat() {
		if (this.beatRank() != 0)
			return this.beatRank();
		else {
			// Royal
			if (hand1.getRank() == 10)
				return 0;
			// StraightFlush
			if (hand1.getRank() == 9) {
				ArrayList<Card> list1 = new ArrayList<Card>();
				list1.add(hand1.getMaxCard());
				SetCard setCard1 = new SetCard(list1);

				ArrayList<Card> list2 = new ArrayList<Card>();
				list2.add(hand2.getMaxCard());
				SetCard setCard2 = new SetCard(list2);
				return setCard1.compareSetCard(setCard2);
			}
			// Four kind of - Full house - Three kind of
			if (hand1.getRank() == 8 || hand1.getRank() == 7
					|| hand1.getRank() == 4) {
				ArrayList<Card> list1 = new ArrayList<Card>();
				list1.addAll(hand1.getThree());
				SetCard setCard1 = new SetCard(list1);

				ArrayList<Card> list2 = new ArrayList<Card>();
				list2.addAll(hand2.getThree());
				SetCard setCard2 = new SetCard(list2);
				return setCard1.compareSetCard(setCard2);
			}
			// Straight - Flush - High card
			if (hand1.getRank()==6|| hand1.getRank() == 5 || hand1.getRank() == 1) {
				return hand1.compareSetCard(hand2);
			}

			// Two Pair
			if (hand1.getRank() == 3) {
				ArrayList<Card> c = new ArrayList<Card>();
				c.addAll(hand1.getPair());

				ArrayList<Card> g = new ArrayList<Card>();
				g.addAll(hand1.listCard);
				g.removeAll(c);
				SetCard temp1 = new SetCard(g);

				c.addAll(temp1.getPair());
				g.removeAll(temp1.getPair());

				SetCard temp11 = new SetCard(g);
				SetCard temp12 = new SetCard(c);

				ArrayList<Card> d = new ArrayList<Card>();
				d.addAll(hand2.getPair());

				ArrayList<Card> e = new ArrayList<Card>();
				e.addAll(hand2.listCard);
				e.removeAll(d);
				SetCard temp2 = new SetCard(e);

				d.addAll(temp2.getPair());
				e.removeAll(temp2.getPair());

				SetCard temp21 = new SetCard(e);
				SetCard temp22 = new SetCard(d);

				if (temp12.compareSetCard(temp22) == 0)
					return temp11.compareSetCard(temp21);
				return temp12.compareSetCard(temp22);

			}

			// One pair
			if (hand1.getRank() == 2) {
				ArrayList<Card> c = new ArrayList<Card>();
				c.addAll(hand1.getPair());

				ArrayList<Card> g = new ArrayList<Card>();
				g.addAll(hand1.listCard);
				g.removeAll(c);
				SetCard temp1 = new SetCard(g);
				SetCard temp12 = new SetCard(c);

				ArrayList<Card> d = new ArrayList<Card>();
				d.addAll(hand2.getPair());

				ArrayList<Card> e = new ArrayList<Card>();
				e.addAll(hand2.listCard);
				e.removeAll(d);
				SetCard temp2 = new SetCard(e);
				SetCard temp22 = new SetCard(d);

				if (temp12.compareSetCard(temp22) == 0)
					return temp1.compareSetCard(temp2);
				return temp12.compareSetCard(temp22);
			}
		}
		System.out.println("Error! Cannot compare same rank!");
		return -1;
	}
}
