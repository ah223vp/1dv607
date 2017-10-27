package BlackJack.model;

import BlackJack.model.rules.*;



public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;

    private IWinCondition m_winCondition;



    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();

        m_winCondition = a_rulesFactory.GetWinCondition();

    }


    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            a_player.DealCard(getCard(true));

            return true;
        }
        return false;
    }

    public boolean Stand(){
        // Show dealer hand
        ShowHand();

        // Checking dealer score depending on rule
        while (m_hitRule.DoHit(this)){

            DealCard(getCard(true));
            return true;
        }
        // False return eval of winner
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {

        if(m_winCondition.getResult(a_player, CalcScore())){
            // Dealer won
            return true;
        }else {
            // Dealer lost
            return false;
        }

    }

    /**
     * Getting a card and returning it, the player can use this method aswell.
     * Use as param to the Dealcard method and the 3 lines before becomes a
     * one liner and are not repeated.
     * @param show boolean value to show or not to show the card
     * @return Card object
     */
    public Card getCard(boolean show){
        Card c = m_deck.GetCard();
        c.Show(show);
        return c;
    }


    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {

            return true;
        }
        return false;
    }

}