package BlackJack.viewGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Window extends Application {

    private Hand dealerHand;
    private Hand playerHand;

    public void start(Stage primaryStage){
        primaryStage.setTitle("Hello World!");

        BorderPane root = new BorderPane();

        BorderPane hands = new BorderPane();

        dealerHand = new Hand();
        playerHand = new Hand();

        //dealCard();

        hands.setBottom(dealerHand);
        hands.setTop(playerHand);

        root.setBottom(bottomColumn());
        root.setCenter(hands);

        primaryStage.setScene(new Scene(root, 700, 700));

        primaryStage.show();
    }
    public ArrayList<Hand> getHands(){
        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(dealerHand);
        hands.add(playerHand);
        return hands;
    }


    public HBox bottomColumn(){
        HBox bottomColumn = new HBox();

        Button hitBtn = new Button();
        Button standBtn = new Button();
        Button playBtn = new Button();

        hitBtn.setText("HIT");
        standBtn.setText("STAND");
        playBtn.setText("PLAY");

        hitBtn.setPrefSize(100,30);
        standBtn.setPrefSize(100,30);
        playBtn.setPrefSize(100,30);

        hitBtn.setOnAction((event) -> {
            //dealCard(playerHand);
            //dealCard(dealerHand);
        });

        bottomColumn.setPadding(new Insets(10));
        bottomColumn.setSpacing(8);


        bottomColumn.setMargin(hitBtn, new Insets(0,0,0,8));
        bottomColumn.setMargin(playBtn, new Insets(0,0,0,8));
        bottomColumn.setMargin(standBtn, new Insets(0,0,0,8));

        bottomColumn.getChildren().add(hitBtn);
        bottomColumn.getChildren().add(standBtn);
        bottomColumn.getChildren().add(playBtn);

        return bottomColumn;
    }
    public void dealCard(Iterable cards){
        System.out.println(cards);
        dealerHand.showCard(cards);
    }
}
