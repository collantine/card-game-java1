package edu.msudenver;

import com.pearson.LinkedStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    protected String name;
    protected LinkedStack<Card> discardStack;
    protected LinkedStack<Card> drawStack;

    public Player(String name) {
        this.name = name;
        this.discardStack = new LinkedStack<>();
        this.drawStack = new LinkedStack<>();
    }

    public Card draw() {
        // TODO implement
        return this.drawStack.pop();
        // Draw a card from the drawStack
    }

    public void discard(Card card) {
        // TODO implement
        // Add a card to the discardStack
        this.discardStack.push(card);
    }

    public void dealt(Card card) {
        // TODO implement
        this.drawStack.push(card);
        // Player was dealt a card that needs to be added to the drawStack
    }

    public boolean hasCards() {
        // TODO implement
        return !this.drawStack.isEmpty();
        // returns true if there are cards in the drawStack only
        // cards in discardStack do not count for this method
    }

    public void dealCards(Deck deck, int numberOfCards){
        for(int i = 1; i<=numberOfCards; i++){
            this.dealt(deck.draw());
        }
    }

    public int getTotalPlayerCardsCount(){
        int count = 0;
        LinkedStack<Card> tempDrawStack = new LinkedStack<>();
        LinkedStack<Card> tempDiscardStack = new LinkedStack<>();

        while (!this.drawStack.isEmpty())
        {
            tempDrawStack.push(this.drawStack.pop());
            count++;
        }

        while (!this.discardStack.isEmpty())
        {
            tempDiscardStack.push(this.discardStack.pop());
            count++;
        }

        //Restore both of player stacks
        while (!tempDrawStack.isEmpty())
        {
            this.drawStack.push(tempDrawStack.pop());
        }

        while (!tempDiscardStack.isEmpty())
        {
            this.discardStack.push(tempDiscardStack.pop());
        }
        return count;
    }

    public void replenishDrawStack() {
        // TODO implement
        // this method will take the cards currently in discardStack and add them to drawStack
        // EXTRA CREDIT: If you shuffle the cards in discardStack before adding them to drawStack,
        // that's worth an extra 5 points!

        //Shuffle
        List<Card> myCards = new ArrayList<>();
        while (!this.discardStack.isEmpty()){
            myCards.add(this.discardStack.pop());
        }
        Collections.shuffle(myCards);

        for(Card card : myCards)
        {
            this.drawStack.push(card);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", discardStack=" + discardStack +
                ", drawStack=" + drawStack +
                '}';
    }
}
