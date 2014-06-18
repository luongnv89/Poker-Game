package poker.object;

import java.util.ArrayList;

/**
 * A set of cards can be a empty set. There aren't two cards same id in a set of
 * cards.
 * 
 * */
public class SetCard {
	/**
	 * List of cards
	 * */
	public ArrayList<Card> listCard = new ArrayList<Card>();

	/**
	 * Construct a set of card from a list of card
	 * 
	 * @param list
	 *            The list of cards
	 * */
	public SetCard(ArrayList<Card> list) {
		listCard.addAll(list);
	}

	public SetCard() {
	};

	/**
	 * Check the set of card is empty or not?
	 * 
	 * @return TRUE if the set of card is empty otherwise return FALSE
	 * */
	public boolean isEmpty() {
		return listCard.size() == 0;
	}

	/**
	 * Check the set of card is unique or not?
	 * 
	 * @return TRUE if the set of cards hasn't two cards are the same id otherwise return FALSE
	 * */
	public boolean isUnique() {
		if (this.isEmpty())
			return true;
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				if (listCard.get(i).getId() == listCard.get(j).getId())
					return false;
			}
		}
		return true;
	}

	/**
	 * Check the set of card has an ACE card or not?
	 * 
	 * @return TRUE if the set of card has an ACE card otherwise return FALSE.
	 * */
	public boolean isA() {
		if (this.isEmpty() || !this.isSetCard()) {
			System.out
					.println("ERROR! Invalid set of cards or the set of cards is empty");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			if (listCard.get(i).getValue() == 1)
				return true;
		}
		return false;
	}

	/**
	 * Check the set of card has a King card or not?
	 * 
	 * @return TRUE if the set of card has a King card otherwise return FALSE.
	 * */
	public boolean isK() {
		if (this.isEmpty() || !this.isSetCard()) {
			System.out
					.println("ERROR! Invalid set of cards or the set of cards is empty");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			if (listCard.get(i).getValue() == 13)
				return true;
		}
		return false;
	}

	/**
	 * Check the set of card has a pair of card which are the same value or not?
	 * 
	 * @return TRUE if the set of card has a pair of card that are the same value otherwise return FALSE.
	 * */
	public boolean isPair() {
		if (!this.isSetCard()) {
			System.out.println("ERROR! Invalid set of cards!");
			return false;
		}
		if (listCard.size() < 2 || !this.isUnique()) {
			System.out
					.println("ERROR! The size of set of cards is less than 2");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				if (listCard.get(i).getValue() == listCard.get(j).getValue())
					return true;
			}
		}
		return false;
	}

	/**
	 * Check the set of card has 3 cards which are the same value or not?
	 * 
	 * @return TRUE if the set of card has a three cards that are the same value otherwise return FALSE.
	 * */
	public boolean isThree() {
		if (!this.isSetCard()) {
			System.out.println("ERROR! Invalid set of cards!");
			return false;
		}
		if (listCard.size() < 3 || !this.isUnique()) {
			System.out
					.println("ERROR! The size of set of cards is less than 3");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				for (int k = j + 1; k < listCard.size(); k++) {
					if (listCard.get(i).getValue() == listCard.get(j)
							.getValue()
							&& listCard.get(j).getValue() == listCard.get(k)
									.getValue())
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get a pair of card has same value in the setCard.
	 * 
	 * @return two cards are the same value.
	 * */
	public ArrayList<Card> getPair() {
		ArrayList<Card> pair = new ArrayList<Card>();
		if (!this.isSetCard()) {
			System.out.println("ERROR! Invalid set of cards!");
			return pair;
		}

		if (listCard.size() < 2 || !this.isUnique()) {
			System.out
					.println("ERROR! The size of set of cards is less than 2");
			return pair;
		}
		if (!this.isPair()) {
			System.out.println("The set card hasn't any pair of card");
		} else {
			for (int i = 0; i < listCard.size(); i++) {
				for (int j = i + 1; j < listCard.size(); j++) {
					if (listCard.get(i).getValue() == listCard.get(j)
							.getValue()) {
						pair.add(listCard.get(i));
						pair.add(listCard.get(j));
						return pair;
					}
				}
			}

		}
		return pair;
	}

	/**
	 * Get three cards have the same value in the setCard.
	 * 
	 * @return three card are the same value in the setCard.
	 * */
	public ArrayList<Card> getThree() {
		ArrayList<Card> three = new ArrayList<Card>();
		if (!this.isSetCard()) {
			System.out.println("ERROR! Invalid set of cards!");
			return three;
		}
		if (listCard.size() < 3 || !this.isUnique()) {
			System.out
					.println("ERROR! The size of set of cards is less than 3");
			return three;
		}

		if (!this.isThree()) {
			System.out.println("The set card hasn't any three of card");
		} else {
			for (int i = 0; i < listCard.size(); i++) {
				for (int j = i + 1; j < listCard.size(); j++) {
					for (int k = j + 1; k < listCard.size(); k++) {
						if (listCard.get(i).getValue() == listCard.get(j)
								.getValue()
								&& listCard.get(j).getValue() == listCard
										.get(k).getValue()) {
							three.add(listCard.get(i));
							three.add(listCard.get(j));
							three.add(listCard.get(k));
							return three;
						}
					}
				}
			}
		}
		return three;
	}

	/**
	 * Sort the list card from the highest to the lowest.
	 * 
	 * */
	public void sort() {
		for (int i = 0; i < listCard.size(); i++) {
			for (int j = i + 1; j < listCard.size(); j++) {
				if (listCard.get(i).getValue() < listCard.get(j).getValue()) {
					swap(listCard, i, j);
				}
			}
		}
	}

	/**
	 * Swap the position of two card in a list of card.
	 * 
	 * @param listCard2
	 *            : the list of cards </br> i,j: the index of two cards in the
	 *            list of cards.
	 * */
	private void swap(ArrayList<Card> listCard2, int i, int j) {
		// TODO Auto-generated method stub
		int temp;
		temp = listCard2.get(i).getId();
		Card c = new Card(temp);
		listCard2.set(i, listCard2.get(j));
		listCard2.set(j, c);
	}

	/**
	 * Get the max value in the set of cards.
	 * 
	 * @return the max value in the set of cards.
	 * */
	public int getMax() {
		if (this.isEmpty() || !this.isSetCard()) {
			System.out
					.println("ERROR! Invalid set of cards or the set of cards is empty");
			return 0;
		}
		int max = listCard.get(0).getValue();
		for (int i = 1; i < listCard.size(); i++) {
			max = max < listCard.get(i).getValue() ? listCard.get(i).getValue()
					: max;
		}
		return max;
	}

	/**
	 * Get the card is the biggest value in the set of cards.
	 * 
	 * @return the id of card which is the biggest value in the set of cards.
	 * */
	public Card getMaxCard() {
		int max = this.getMax();
		if (this.getMax() == 0) {
			return null;
		}
		for (int i = 0; i < listCard.size(); i++)
			if (listCard.get(i).getValue() == max)
				return listCard.get(i);
		System.out.println("ERROR! Cannot get the max card!");
		return null;
	}

	/**
	 * Compare the list of cards of this SetCard with another setCard
	 * 
	 * @param hand2
	 *            another set of cards which is compared with this set of cards
	 * @return 1: the list of cards of this SetCard is bigger than hand2 </br>2: the list
	 *         of cards of this SetCard is smaller than hand2 </br> 0: the list of cards of
	 *         this SetCard is equal hand2</br> -1: Error!
	 * */
	public int compareSetCard(SetCard hand2) {
		if (!this.isSetCard() || !hand2.isSetCard()) {
			System.out.println("ERROR! Invalid set of cards!");
			return -1;
		}
		if (this.isEmpty() && hand2.isEmpty())
			return 0;
		if (this.listCard.size() != hand2.listCard.size()) {
			System.out.println("ERROR! Two set of cards doesn't same size");
			return -1;
		} else {
			if (this.isA() && !hand2.isA())
				return 1;
			if ((!this.isA() && hand2.isA())
					|| (this.getMax() < hand2.getMax()))
				return 2;
			if (this.isA() == hand2.isA() && this.getMax() > hand2.getMax())
				return 1;
			if (this.isA() == hand2.isA() && this.getMax() < hand2.getMax())
				return 2;
			else {
				Card c1 = this.getMaxCard();
				ArrayList<Card> list1 = new ArrayList<Card>();
				list1.addAll(this.listCard);
				list1.remove(c1);
				SetCard setCard1 = new SetCard(list1);

				Card c2 = hand2.getMaxCard();
				ArrayList<Card> list2 = new ArrayList<Card>();
				list2.addAll(hand2.listCard);
				list2.remove(c2);
				SetCard setCard2 = new SetCard(list2);

				return setCard1.compareSetCard(setCard2);
			}
		}
	}

	/**
	 * Check the set of cards is a valid set of cards or not?
	 * 
	 * @return TRUE if the set of cards is valid </br> FALSE if the set of cards
	 *         isn't unique or it has some invalid cards.
	 * */
	public boolean isSetCard() {
		if (!this.isUnique()) {
			System.out.println("ERROR! The set of cards isn't unique!");
			return false;
		}
		for (int i = 0; i < listCard.size(); i++) {
			if (!listCard.get(i).isCard()) {
				System.out.println("ERROR! " + listCard.get(i).getId()
						+ " isn't a card!");
				return false;
			}
		}
		return true;
	}

}
