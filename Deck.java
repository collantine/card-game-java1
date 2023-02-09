package edu.msudenver;

import com.pearson.SortedLinkedList;

public class Deck {
    protected SortedLinkedList<Card> cards;

    public Deck() {
        cards = new SortedLinkedList<>();
    }

    public void shuffle() {
        // TODO implement

        // This method needs to make the 52 cards comprising a card deck
        // and add them, in random order, to the SortedLinkedList
        for(Suit s : Suit.values()){
            for(int i = 2; i<=14; i++)
            {
                cards.insert(new Card(i, s));
            }
        }
        // The face of the card will be 2-13. The Ace will be 14 for this game

        // I have made this easier for you! Cards have a random number
        // already associated to them, and a compareTo method in place
        // so that they will sort themselves by their random number.

        // All you should need to do is make sure you create the right number of cards, and
        // add them to the list! They will shuffle themselves thanks to the insertion sort of the
        // linked list
    }

    public Card draw() {
        // TODO implement
        return this.cards.remove();
        // This method should remove a card from the SortedLinkList and return it
    }

}
