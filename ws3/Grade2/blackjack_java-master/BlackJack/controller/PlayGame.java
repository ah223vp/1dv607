package BlackJack.controller;


import BlackJack.model.Game;
import BlackJack.model.ICardDealtObserver;
import BlackJack.view.IView;

public class PlayGame implements ICardDealtObserver {

    private IView a_view;
    private Game a_game;

    public boolean Play(Game a_game, IView a_view) {
        this.a_view = a_view;
        this.a_game = a_game;
        a_game.addSubscriber(this);
        a_view.DisplayWelcomeMessage();

        //a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        //a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        // Having ENUM in IVIEW interface.
        IView.Actions input = a_view.GetInput();

        if (input == IView.Actions.PLAY) {
            a_game.NewGame();
        } else if (input == IView.Actions.HIT) {
            a_game.Hit();
        } else if (input == IView.Actions.STAND) {
            a_game.Stand();
        }
        return input != IView.Actions.QUIT;


    }

    public void DealCard_obs(){
        try{
            System.out.println();
            System.out.println("Dealing....");
            System.out.println();
            Thread.sleep(2000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    }


}
