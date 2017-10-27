package BlackJack.model.rules;

import BlackJack.model.*;

public class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_player.DealCard(a_dealer.getCard(true));
    a_dealer.DealCard(a_dealer.getCard(true));
    a_player.DealCard(a_dealer.getCard(true));

    return true;
  }
  public void accept(IVisitor visitor){
    visitor.visit(this);
  }
}