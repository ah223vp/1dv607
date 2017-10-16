package BlackJack.model;

import BlackJack.model.rules.ICardDealtObserver;
import BlackJack.model.rules.IAbstractFactory;
import BlackJack.model.rules.IVisitor;


public class Game {

    private Dealer m_dealer;
    private Player m_player;

    private IAbstractFactory rules;


    public Game(IAbstractFactory rules, IVisitor visitor)
    {
        this.rules = rules;
        m_dealer = new Dealer(rules, visitor);
        m_player = new Player();
    }

    public void accept(IVisitor visitor){
        //visitor.visitGame(this);
    }

    public void addSubscriber(ICardDealtObserver sub){

        m_player.addSubscriber(sub);
        m_dealer.addSubscriber(sub);
    }

    public boolean IsGameOver()
    {
        return m_dealer.IsGameOver();
    }

    public boolean IsDealerWinner()
    {
        return m_dealer.IsDealerWinner(m_player);
    }

    public boolean NewGame()
    {
        return m_dealer.NewGame(m_player);
    }

    public boolean Hit()
    {
        return m_dealer.Hit(m_player);
    }

    public boolean Stand()
    {
        // TODO: Implement this according to Game_Stand.sequencediagram

        return m_dealer.Stand();
    }

    public Iterable<Card> GetDealerHand()
    {
        return m_dealer.GetHand();
    }

    public Iterable<Card> GetPlayerHand()
    {
        return m_player.GetHand();
    }

    public int GetDealerScore()
    {
        return m_dealer.CalcScore();
    }

    public int GetPlayerScore()
    {
        return m_player.CalcScore();
    }

    // Is this allowed?
    public IAbstractFactory getRules() {
        return rules;
    }
}