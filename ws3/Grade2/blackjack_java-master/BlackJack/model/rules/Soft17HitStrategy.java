package BlackJack.model.rules;


import BlackJack.model.Card;
import BlackJack.model.Player;

/**
 * Making a new class not to fondle with the original
 */
public class Soft17HitStrategy implements IHitStrategy {

    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
       if(a_dealer.CalcScore() == g_hitLimit){
           if(checkForSoft17(a_dealer)){
               return true;
           }
       }

        return a_dealer.CalcScore() < g_hitLimit;
    }
    private boolean checkForSoft17(Player a_dealer){

        for(Card c : a_dealer.GetHand()){
            if(c.GetValue() == Card.Value.Ace){
                return true;
            }
        }
        return false;
    }

}
