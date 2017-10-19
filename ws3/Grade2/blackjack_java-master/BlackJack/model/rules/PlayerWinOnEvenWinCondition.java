package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinOnEvenWinCondition implements IWinCondition {

    private int g_maxScore = 21;

    public boolean getResult(Player a_player, int score){

        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (score > g_maxScore) {
            return false;
        } else if(a_player.CalcScore() == score){
            return false;
        }
        return score > a_player.CalcScore();

    }
}
