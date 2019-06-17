package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.CardGames.UtilitiesCards.Suit;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BlackjackTest {
     Blackjack b;
     BasePlayer basePlayer;
    BlackjackPlayer dealer;
    BlackjackPlayer player;
    Console console = new Console(System.in,System.out);
    ArrayList<Card> hand = new ArrayList<>();
    @Before
    public void setup(){

        BasePlayer basePlayer = new BasePlayer("Test");
        BasePlayer basePlayer2 = new BasePlayer("Test2");
        player = new BlackjackPlayer(basePlayer);
        dealer = new BlackjackPlayer(basePlayer2);
        b = new Blackjack(player, dealer);
        b.setupBoard(console);



    }
    @Test
    //ace is included
    public void isAcePresentPlayer(){
        hand.clear();

        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        player.setHand(hand);
        Integer answer =  b.isAPresent(player.hand);
        Integer expected =  1;
        console.print("\n" + Hand.showHand((ArrayList<Card>) player.hand));
        Assert.assertEquals(expected,answer);

    }
    @Test
    //ace is not
    public void isAcePresent(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        player.setHand(hand);
        Integer answer =  b.isAPresent(player.hand);
        Integer expected =  0;
        console.print("\n" + Hand.showHand((ArrayList<Card>) player.hand));
        Assert.assertEquals(expected,answer);

    }

    @Test
    public void areTwoCardsDrawn(){
        //getHandSize
    }
    @Test
    //should be true
    public void canPlayerBust(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        player.setHand(hand);
         boolean answer = b.playerBustCheck();
        boolean expected = true;
         Assert.assertEquals(expected,answer);
    }
    @Test
    //should be false
    public void canPlayerBustfalse(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));


        player.setHand(hand);
        boolean answer = b.playerBustCheck();
        boolean expected = false;
        Assert.assertEquals(expected,answer);
    }
    @Test
    public void canDealerBust(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        dealer.setHand(hand);
        boolean answer = b.dealerBustCheck();
        boolean expected = true;
        Assert.assertEquals(expected,answer);

    }
    @Test
    public void candealerBustfalse() {
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));


        dealer.setHand(hand);
        boolean answer = b.dealerBustCheck();
        boolean expected = false;
        Assert.assertEquals(expected, answer);
    }


    @Test
    public void switchTurns() {
    }

    @Test
    public void welcomeMessage() {
    }

    @Test
    public void testplaceWager() {
        Integer betAmount = 100;
        String answer = b.placeWager(betAmount);

        String expected = "Bet Amount of " + betAmount + " Confirmed";;

        Assert.assertEquals(expected,answer);

    }
    @Test
    public void scoreChecker(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        player.setHand(hand);
        Integer answer =  b.playerHandValue();
        Integer expected = 21;
        Assert.assertEquals(expected,answer);

    }
    @Test
    public void scoreChecker2(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));

        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        player.setHand(hand);
        Integer answer =  b.playerHandValue();
        Integer expected = 21;
        Assert.assertEquals(expected,answer);

    }
    @Test
    public void test47(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        dealer.setHand(hand);
        Integer answer =  b.dealerHandValue();
        Integer expected = 21;
        Assert.assertEquals(expected,answer);

    }
    @Test
    public void test48(){
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));

        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        dealer.setHand(hand);
        Integer answer =  b.dealerHandValue();
        Integer expected = 21;
        Assert.assertEquals(expected,answer);

    }


    @Test
    public void gameReset() {
        Boolean answer = b.getPlayerTurn();
        Boolean expected = true;
        Assert.assertEquals(expected,answer);
    }



    @Test
    public void setupBoardPlayer() {

        Integer answer = player.hand.size();
        Integer expected = 2;
        Assert.assertEquals(expected,answer);
    }
    @Test
    public void setupBoardDealer() {

        Integer answer = dealer.hand.size();
        Integer expected = 1;
        Assert.assertEquals(expected,answer);
    }

    @Test
    public void gameReset1() {

        Boolean answer = b.getCurrentGame();
        Boolean expected = true;
        Assert.assertEquals(expected,answer);
    }

    @Test
    public void whoWondealerbusts() {
        b.setBetAmount(10);
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        dealer.setHand(hand);
        b.dealerBustCheck();
        b.whoWon(console);
        Integer answer = player.getWallet();
        Integer expected = 100020;
        Assert.assertEquals(expected,answer);


    }
    @Test
    public void whowonplayerrbusts() {
        b.setBetAmount(10);
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        player.setHand(hand);
        b.playerBustCheck();
        b.whoWon(console);
        Integer answer = b.getTester();
        Integer expected = 2;
        Assert.assertEquals(expected,answer);


    }

    @Test
    public void getCurrentGame() {
    }

    @Test
    public void getPlayerTurn() {
    }

    @Test
    public void checkPlayerAnswer() {

        /*b.setPlayerAnswer("Hit");

        b.setPlayerAnswer("STAY");
        Integer answer =  player.hand.size();
        Integer expected = 3;
        Assert.assertEquals(expected,answer);*/
    }
    @Test
    public void checkPlayerAnswer2() {
        b.setPlayerAnswer("Stay");
        Integer answer =  player.hand.size();
        Integer expected = 2;
        Assert.assertEquals(expected,answer);
    }

    @Test
    public void dealerTurn() {
        hand.clear();
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        dealer.setHand(hand);
        b.dealerTurn(console);
        Boolean answer =  b.getCurrentGame();
        Boolean expected = false;
        Assert.assertEquals(expected,answer);

    }
}