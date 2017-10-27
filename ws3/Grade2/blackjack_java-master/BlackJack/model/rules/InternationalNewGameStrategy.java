package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(true));
    a_player.DealCard(a_dealer.getCard(true));
  
    return true;
  }
}