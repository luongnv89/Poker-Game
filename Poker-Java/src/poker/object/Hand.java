package poker.object;

import java.util.ArrayList;

/**
 * Hand is a set of card. In addition, Hand has exactly 5 cards. With a valid
 * hand, we can calculate the rank of Hand. The rank of hand can be used to
 * define how strong of hand. The rank of hand can be from 1 to 10 correspond
 * from High card to Royal flush
 * */
public class Hand extends SetCard {
	/**
	 * Construct a hand
	 * */

	public Hand(ArrayList<Card> list) {
		super(list);

	}

	/**
	 * Construct a hand
	 * */
	public Hand() {
		super();
	};

	/**
	 * Check a set of card is a valid hand or not
	 * 
	 * @return TRUE if a set of card is a valid set card and it has exactly 5
	 *         cards otherwise return FALSE
	 * */
	public boolean isHand() {
		return this.isSetCard() && listCard.size() == 5;
	}

	/**
	 * Get the rank of hand card
	 * 
	 * @return the rank of hand card. </br>1: High card </br> 2: One pair </br>
	 *         3: Two pair </br>4: Three kind of card </br> 5: Flush </br> 6:
	 *         Straight </br>7: Full house </br> 8: Four kind of card </br>9:
	 *         Straight Flush </br>10: Royal Flush</br>-1: Error
	 * */
	public int getRank() {
		// Royal
		if (this.isHand() && this.isA() && this.isK() && this.isFlush()
				&& isStraight())
			return 10;
		// StraightFlush
		else if (this.isHand() && this.isFlush() && this.isStraight()
				&& (!this.isA() || !this.isK()))
			return 9;
		// Four of kind
		else if (this.isHand() && this.isFour())
			return 8;
		// Straight
		else if (this.isHand() && this.isStraight() && !this.isFlush())
			return 6;
		// Flush
		else if (this.isHand() && this.isFlush() && !this.isStraight())
			return 5;
		else if (!this.isFour() && this.isHand() && this.isThree()) {
			ArrayList<Card> listTemp = new ArrayList<Card>();
			listTemp.addAll(this.getThree());

			ArrayList<Card> listTemp2 = new ArrayList<Card>();
			listTemp2.addAll(listCard);
			listTemp2.removeAll(listTemp);
			// Full house
			SetCard setTemp = new SetCard(listTemp2);
			if (setTemp.isPair())
				return 7;
			// three
			else
				return 4;
		}

		// Two pair and one pair
		else if (this.isHand() && !this.isThree() && this.isPair()) {
			ArrayList<Card> listTemp = new ArrayList<Card>();
			listTemp.addAll(this.getPair());

			ArrayList<Card> listTemp2 = new ArrayList<Card>();
			listTemp2.addAll(listCard);
			listTemp2.removeAll(listTemp);

			SetCard setTemp = new SetCard(listTemp2);
			// two pair
			if (setTemp.isPair())
				return 3;
			// one pair
			else
				return 2;
		}
		// High card
		else if (this.isHand() && !this.isPair() && !this.isFlush()
				&& !this.isStraight())
			return 1;
		return 0;
	}

	/**
	 * Check the hand is straight or not.</b> straight is a hand where all of
	 * the cards are consecutive. There is no continuous quality to this poker
	 * hand a straight cannot wrap around meaning it is not a straight if you
	 * have a Queen, King, Ace, Two or Three. Standard poker rules state that in
	 * the case of more than one straight, the higher straight wins, In case of
	 * straight that tie, the pot is split.
	 * 
	 * @return TRUE if the hand is straight otherwise return FALSE
	 * */
	public boolean isStraight() {
		if (!this.isHand()) {
			System.out.println("ERROR! Invalid hand card!");
			return false;
		} else {
			this.sort();
			if (this.isA() && listCard.get(0).getValue() == 13
					&& listCard.get(1).getValue() == 12
					&& listCard.get(2).getValue() == 11
					&& listCard.get(3).getValue() == 10) {
				return true;
			} else {
				for (int i = 0; i < listCard.size() - 1; i++) {
					if (listCard.get(i).getValue() != (listCard.get(i + 1)
							.getValue() + 1))
						return false;
				}
				return true;
			}
		}
	}

	/**
	 * Check the hand is flush or not</br> A flush is a hand where all of the
	 * cards are the same suit, if each card you have is all one suit, such as 3
	 * of Clubs, 5 of Clubs, 6 of Clubs, 8 of Clubs and King of Clubs, then you
	 * have a Flush. Don't be tricked into thinking that all five cards are the
	 * same color. The high card determines the winner if two people have a
	 * flush
	 * 
	 * @return TRUE if the hand is flush otherwise return FALSE
	 * */
	public boolean isFlush() {
		if (!this.isHand()) {
			System.out.println("ERROR! Invalid hand card!");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				if (listCard.get(i).getSuit() != listCard.get(j).getSuit())
					return false;
			}
		}
		return true;
	}

	/**
	 * Check the set of card has a four of card or not
	 * 
	 * @return TRUE if the set of card has a four of card otherwise return FALSE
	 * */
	public boolean isFour() {
		if (!this.isHand()) {
			System.out.println("ERROR! Invalid hand card!");
			return false;
		}
		// if (listCard.size() < 4 || !this.isUnique()) {
		// System.out
		// .println("ERROR! The size of set of cards is less than 4");
		// return false;
		// }
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				for (int k = j + 1; k < listCard.size(); k++) {
					for (int l = k + 1; l < listCard.size(); l++)
						if (listCard.get(i).getValue() == listCard.get(j)
								.getValue()
								&& listCard.get(j).getValue() == listCard
										.get(k).getValue()
								&& listCard.get(k).getValue() == listCard
										.get(l).getValue())
							return true;
				}
			}
		}
		return false;
	}

}
