package BlackJack.view;

import BlackJack.model.Game;
import BlackJack.model.IVisitor;

public class PrintRulesVisitor implements IVisitor {

    public void visitGame(Game game){
        System.out.println("Current rules: " + game.getRules().getName());
    }
}
