package poker.object;

/**
 * Each card is represented by an id. A poker kit has 52 cards. So the value of
 * id is in the set of value from 1 to 52. Each card has a value and a suite.
 * The value of suite can be 1-Heart, 2-Diamond, 3-Club, 4-Spade. The value of
 * cards can be from 1 to 13
 * 
 * */
public class Card {
	/**
	 * id: The id of card in a poker pack. The value of id is from 1 to 52
	 * */
	int id;

	/**
	 * Construct an object of Card
	 * 
	 * @param x
	 *            id of card
	 * */
	public Card(int x) {
		id = x;
	}

	/**
	 * Check the validate of a card
	 * 
	 * @return TRUE if card is validate otherwise return FALSE
	 * */
	public boolean isCard() {
		return id > 0 && id < 53;
	}

	/**
	 * Get the value of the card
	 * 
	 * @return value of card. 1-A, 2-2,3-3...,11-J, 12-Q, 13-K
	 * */
	public int getValue() {
		if (!this.isCard()) {
			System.out.println("Error! " + id + " isn't a card!");
			return 0;
		} else if (id % 13 != 0)
			return id % 13;
		else
			return 13;
	}

	/**
	 * Get the suit of the card
	 * 
	 * @return the suit of the card. 1-Heart, 2-Diamond, 3-Club, 4-Spade
	 * */
	public int getSuit() {
		if (!this.isCard()) {
			System.out.println("Error! " + id + " isn't a card!");
			return 0;
		} else if (id < 14)
			return 1;
		else if (id >= 14 && id < 27)
			return 2;
		else if (id >= 27 && id < 40)
			return 3;
		else
			return 4;
	}

	/**
	 * Get the id of the card
	 * 
	 * @return the id of the card.
	 * */
	public int getId() {
//		if (!this.isCard())
//			return 0;
		return id;
	}
}
