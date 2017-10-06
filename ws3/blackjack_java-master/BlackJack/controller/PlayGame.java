package BlackJack.controller;

import BlackJack.model.Card;
import BlackJack.model.Game;
import BlackJack.model.rules.ICardDealtObserver;
import BlackJack.view.IView;

public class PlayGame implements ICardDealtObserver {

    private IView a_view;

    public boolean Play(Game a_game, IView a_view) {
        this.a_view = a_view;
        a_game.addSubscriber(this);
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        int input = a_view.GetInput();

        if (input == 'p') {
            a_game.NewGame();
        } else if (input == 'h') {
            a_game.Hit();
        } else if (input == 's') {
            a_game.Stand();
        }
        return input != 'q';


    }

    public void DealCard_obs(Card c){
        System.out.println("Detta är observern som är kallad");
        a_view.DisplayCard(c);
    }

}
