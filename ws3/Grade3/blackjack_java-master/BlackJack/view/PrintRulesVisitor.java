package BlackJack.view;


import BlackJack.model.rules.IVisitor;
import BlackJack.model.rules.BasicHitStrategy;

public class PrintRulesVisitor implements IVisitor {


    //public void visitGame(Game game){
      //  System.out.println("Current rules: " + game.getRules().getName());
    //}
    public void visit(BasicHitStrategy rule){
        System.out.println("Visited BasicHitStrategy");
    }

}
