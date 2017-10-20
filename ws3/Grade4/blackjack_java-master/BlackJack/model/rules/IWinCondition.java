package BlackJack.model.rules;

import BlackJack.model.Player;


/**
 * Interface for deciding the wincondition
 * Send in both scores and to whatever calculations you want in the class
 */
public interface IWinCondition extends IVisitable {
    boolean getResult(Player a_dealer, int score);
}
