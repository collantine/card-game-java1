package edu.msudenver;

import java.util.ArrayList;
import java.util.List;

public class WARGame {
    protected Deck deck;

    protected Player player1;
    protected Player player2;

    public void setup() {
        // TODO implement
        deck = new Deck();
        deck.shuffle();
        player1 = new Player("Allison");
        player2 = new Player("Leela");
        player1.dealCards(deck, 26);
        player2.dealCards(deck, 26);
        // create the deck and players
        // shuffle the cards
        // deal 26 cards to each player
    }

    public void play() {
        // TODO implement
        // Both players turn their top card face up at the same time. The person with the higher card wins that draw, and takes both the cards.
        // They are put to the side to form a new stack, which the player can use when he finishes his current stack.
      boolean keepPlaying = true;
      while (!player1.drawStack.isEmpty() && !player2.drawStack.isEmpty() && keepPlaying)
      {
          Card player1Card=player1.draw();
          Card player2Card=player2.draw();

          if (player1Card.compareTo(player2Card) == -1)
          {
              player2.discardStack.push(player1Card);
              player2.discardStack.push(player2Card);
          }
          else if (player1Card.compareTo(player2Card) == 1)
          {
              player1.discardStack.push(player1Card);
              player1.discardStack.push(player2Card);
          }
          else //War
          {
              boolean stopWar = false;
              List<Card> warCards = new ArrayList<>();
              warCards.add(player1Card);
              warCards.add(player2Card);
              while (!stopWar) {
                  if (player1.getTotalPlayerCardsCount() < 4)
                  {
                      System.out.println("Player 2 wins");
                      keepPlaying = false;
                      break;
                  }
                  if (player2.getTotalPlayerCardsCount() < 4)
                  {
                      System.out.println("Player 1 wins");
                      keepPlaying = false;
                      break;
                  }
                  warCards.add(player1.draw());
                  warCards.add(player1.draw());
                  warCards.add(player1.draw());

                  warCards.add(player2.draw());
                  warCards.add(player2.draw());
                  warCards.add(player2.draw());

                  Card player1WarCompareCard = player1.draw();
                  Card player2WarCompareCard = player2.draw();

                  warCards.add(player1WarCompareCard);
                  warCards.add(player2WarCompareCard);

                  if (player1WarCompareCard.compareTo(player2WarCompareCard) == -1){
                      for(Card warCard : warCards)
                      {
                          player2.discardStack.push(warCard);
                      }
                      stopWar = true;
                  }
                  else if (player1WarCompareCard.compareTo(player2WarCompareCard) == 1) {
                      for (Card warCard : warCards) {
                          player1.discardStack.push(warCard);
                      }
                      stopWar = true;
                  }
              }
          }

          if (keepPlaying = false){
              break;
          }
          //Check if players still have cards
          if (!player1.hasCards()) {
              player1.replenishDrawStack();
          }
          if (!player1.hasCards()) {
              System.out.println("Player 2 won");

          }

          if (!player2.hasCards()) {
              player2.replenishDrawStack();
          }
          if (!player2.hasCards()) {
              System.out.println("Player 1 won");
          }
      }



        // If both players draw a card of the same rank, e.g. they both draw 8s, then there's a war.
        // The face up cards are left on the table and each player puts three cards face down on the table, and then puts one card face up.
        // The face up card determines who wins the war and gets all 10 cards that are on the table at this point.
        // If the face up card is again the same rank, then the war goes on, three more face down, one face up etc.

        // First player to finish all their cards loses the game.

        // If a player finishes their cards during a war without having enough cards to finish the war then he loses immediately.

        // You will need to create a loop that goes until one player's drawStack is empty
        // In the loop, you will deal cards into a common pot of cards for that round. Whoever wins that pot gets
        // the cards added to their discard stack, that will be shuffled into the draw stack when they run out of cards

        // The rules for when the two drawn cards are the same must be honored - the WAR mechanic

        // Bottom line though - whoever wins the rounds gets all the cards drawn in that round
        // If a player runs out of cards, the other player wins
        // If a player runs ouf of cards in the middle of a WAR - don't shuffle, that player loses

        // In order to know which card "wins", compare the faces of the two cards (getFace) - the bigger number wins
        // If the two numbers are the same, WAR!

        // Be sure to include some System.out.println statements during the match so you know what's happening!
    }
}
