package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

public class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    //Card c;

    /*
    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard_obs(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_dealer.DealCard_obs(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard_obs(c);

    c = a_deck.GetCard();
    c.Show(false);
    a_dealer.DealCard_obs(c);
    */

    // Not sure if this counts but the code is DRY
    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(true));
    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(false));


    return true;
  }
  public void accept(IVisitor visitor){
    visitor.visit(this);
  }
}