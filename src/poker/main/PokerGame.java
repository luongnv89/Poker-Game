package poker.main;
// up from my computer to git to assembla
import java.util.ArrayList;
import java.util.Scanner;

import poker.object.Card;
import poker.object.Fighting;
import poker.object.Hand;
import poker.object.SetCard;

public class PokerGame {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice = 0;
		while (choice != 1) {
			int m;
			System.out.println("\n\nWELCOME TO POKER GAME");
			System.out.println("What do you want to do?");
			System.out.println("0. Test a set of cards");
			System.out.println("1. Beat with 2 hand");
			System.out.println("2. Beat with 3 hand");
			System.out.println("3. Exit");
			System.out.println("Give me your choice: ");
			m = in.nextInt();
			switch (m) {
			case 0:
				ArrayList<Card> listCard = new ArrayList<Card>();
				System.out.println("Give me the number of card");
				int n = in.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("card " + (i + 1));
					int idtemp = in.nextInt();
					listCard.add(new Card(idtemp));
				}
				System.out.println("The information of card:");
				SetCard newSetCard = new SetCard(listCard);
				Hand newHand = new Hand(listCard);
				if (newHand.isHand()) {
					System.out
							.println("The set of cards is a valid hand cards");
					showHand(newHand);
				} else {
					if (newSetCard.isEmpty()) {
						System.out.println("The set of cards is empty");
					} else {
						if (!newSetCard.isUnique()) {
							System.out.println("The set of cards isn't unique");
						} else {
							if (!newSetCard.isSetCard()) {
								System.out
										.println("The set of cards isn't a valid set of cards");
							} else {
								if (newSetCard.isA())
									System.out
											.println("The set of cards has an ACE card");
								if (newSetCard.isK())
									System.out
											.println("The set of cards has an KING card");
								if (newSetCard.isThree()) {
									ArrayList<Card> listThree = new ArrayList<Card>();
									listThree.addAll(newSetCard.getThree());
									System.out
											.println("The set of cards is three kind of card :  "
													+ listThree.get(0)
															.getValue());

								} else {
									if (newSetCard.isPair()) {
										ArrayList<Card> listPair = new ArrayList<Card>();
										listPair.addAll(newSetCard.getPair());
										System.out
												.println("The set of cards is pair kind of card :  "
														+ listPair.get(0)
																.getValue());
									}
								}

							}
						}
					}
				}
				break;
			case 1:
				ArrayList<Card> list1 = new ArrayList<Card>();
				System.out.println("Give me the card of hand 1: ");
				list1.addAll(inputHand());
				ArrayList<Card> list2 = new ArrayList<Card>();
				System.out.println("Give me the card of hand 2: ");
				list2.addAll(inputHand());
				Hand hand1 = new Hand(list1);
				showHand(hand1);
				Hand hand2 = new Hand(list2);
				showHand(hand2);
				Fighting testFighting = new Fighting(list1, list2);
				int result = testFighting.beat();
				System.out.println("Hand 1 vs Hand 2");
				if (result == 1) {
					System.out.println("Hand 1 beat hand 2!");
				} else if (result == 2)
					System.out.println("Hand 2 beat hand 1!");
				else if (result == 0)
					System.out.println("Hand 2 equal hand 1!");

				break;
			case 2:
				ArrayList<Card> list3 = new ArrayList<Card>();
				System.out.println("Give me the card of hand 1: ");
				list3.addAll(inputHand());

				ArrayList<Card> list4 = new ArrayList<Card>();
				System.out.println("Give me the card of hand 2: ");
				list4.addAll(inputHand());

				ArrayList<Card> list5 = new ArrayList<Card>();
				System.out.println("Give me the card of hand 3: ");
				list5.addAll(inputHand());

				Hand hand3 = new Hand(list3);
				showHand(hand3);
				Hand hand4 = new Hand(list4);
				showHand(hand4);
				Hand hand5 = new Hand(list5);
				showHand(hand5);
				Fighting testFighting1 = new Fighting(list3, list4);
				int result1 = testFighting1.beat();
				System.out.println("Hand 1 vs Hand 2");
				if (result1 == 1) {
					System.out.println("Hand 1 beat hand 2!");
				} else if (result1 == 2)
					System.out.println("Hand 2 beat hand 1!");
				else if (result1 == 0)
					System.out.println("Hand 2 equal hand 1!");
				Fighting testFighting2 = new Fighting(list4, list5);
				int result2 = testFighting2.beat();
				System.out.println("Hand 2 vs Hand 3");
				if (result2 == 1) {
					System.out.println("Hand 2 beat hand 3!");
				} else if (result2 == 2)
					System.out.println("Hand 3 beat hand 2!");
				else if (result2 == 0)
					System.out.println("Hand 2 equal hand 3!");

				Fighting testFighting3 = new Fighting(list3, list5);
				int result3 = testFighting3.beat();
				System.out.println("Hand 1 vs Hand 3");
				if (result3 == 1) {
					System.out.println("Hand 1 beat hand 3!");
				} else if (result3 == 2)
					System.out.println("Hand 3 beat hand 1!");
				else if (result3 == 0)
					System.out.println("Hand 3 equal hand 1!");

				break;
			case 3:
				choice = 1;
				System.out.println("THANK YOU!");
				break;
			default:
				System.out.println("ERROR. Please try again!");
				break;
			}
		}

	}

	private static void showHand(Hand hand1) {
		// TODO Auto-generated method stub
		System.out.println();
		if (!hand1.isHand()) {
			System.out.println("It isn't a valid hand!");
		} else {
			System.out.println("Id        Value      Suit");
			for (int i = 0; i < 5; i++) {
				System.out.println(hand1.listCard.get(i).getId() + "        "
						+ hand1.listCard.get(i).getValue() + "          "
						+ hand1.listCard.get(i).getSuit());
			}
			int rank = hand1.getRank();
			System.out.println("\nThe rank of hand: " + hand1.getRank());
			if (rank == 10)
				System.out.println("It's Royal");
			if (rank == 9)
				System.out.println("It's straight flush");
			if (rank == 6)
				System.out.println("It's straight!");
			if (rank == 5)
				System.out.println("It's flush!");
			if (rank == 8) {
				ArrayList<Card> listemp = new ArrayList<Card>();
				listemp.addAll(hand1.getThree());
				// SetCard setTemp = new SetCard(listemp);
				System.out.println("It's four kind of card : "
						+ listemp.get(0).getValue());
			}
			if (rank == 4) {
				ArrayList<Card> listemp = new ArrayList<Card>();
				listemp.addAll(hand1.getThree());
				// SetCard setTemp = new SetCard(listemp);
				System.out.println("It's four kind of card"
						+ listemp.get(0).getValue());
			}
			if (rank == 7) {
				ArrayList<Card> listemp = new ArrayList<Card>();
				listemp.addAll(hand1.getThree());
				ArrayList<Card> listemp2 = new ArrayList<Card>();
				listemp2.removeAll(listemp);
				// SetCard setTemp = new SetCard(listemp);
				System.out.println("It's full house");
				System.out.println("Three kind of card:  "
						+ listemp.get(0).getValue());
				System.out.println("Pair of card:  "
						+ listemp2.get(0).getValue());
			}
			if (rank == 3) {
				ArrayList<Card> listemp = new ArrayList<Card>();
				listemp.addAll(hand1.getPair());
				ArrayList<Card> listemp2 = new ArrayList<Card>();
				listemp2.removeAll(listemp);
				ArrayList<Card> listemp3 = new ArrayList<Card>();
				SetCard setTemp = new SetCard(listemp2);
				listemp3.addAll(setTemp.getPair());
				System.out.println("It's two pair");
				System.out.println("Pair of card the number 1:  "
						+ listemp.get(0).getValue());
				System.out.println("Pair of card the number 2:  "
						+ listemp3.get(0).getValue());
			}

			if (rank == 2) {
				ArrayList<Card> listemp = new ArrayList<Card>();
				listemp.addAll(hand1.getPair());
				System.out.println("It's one pair");
				System.out.println("Pair of card :  "
						+ listemp.get(0).getValue());
			}

			if (rank == 1)
				System.out.println("It's high card!");

		}

	}

	private static ArrayList<Card> inputHand() {
		// TODO Auto-generated method stub
		ArrayList<Card> list1 = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			int id;
			System.out.println("card " + (i + 1) + "\n");
			id = in.nextInt();
			Card temp = new Card(id);
			list1.add(temp);
		}
		return list1;
	}
}