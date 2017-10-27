package BlackJack.viewGUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Hand extends HBox {

    private ArrayList<Pane> cards;


    public void getCard(){

    }
    public void showCard(Iterable cards){

        Pane c = new Card();
        this.cards.add(c);

        System.out.println(cards);

        getChildren().add(c);

    }
}
