package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy extends IVisitable{
    boolean DoHit(Player a_dealer);

}