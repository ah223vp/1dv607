package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    // Not sure if this counts but the code is DRY
    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(true));
    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(false));


    return true;
  }
}