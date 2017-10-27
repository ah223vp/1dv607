package BlackJack.viewGUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class Card extends Pane {


    BackgroundImage myBI= new BackgroundImage(new Image("/BlackJack/Assets/2_of_clubs.png",32,32,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);

    public Card(){

        Image image = new Image("BlackJack/Assets/2_of_clubs.png", 200,200, true, false);
        ImageView img = new ImageView(image);

        getChildren().add(img);
    }

    public void showCard(){

    }





}

