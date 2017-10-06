package BlackJack.model.rules;

import BlackJack.model.Card;

public interface ICardDealtObserver {
    void DealCard_obs(Card c);
}
