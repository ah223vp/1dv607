package BlackJack.view;


import BlackJack.model.rules.*;

public class PrintRulesVisitor implements IVisitor {


    // New Game rules
    public void visit(AmericanNewGameStrategy rule){
        System.out.println("Visited AmericanNewGameStrategy");
    }
    public void visit(InternationalNewGameStrategy rule){
        System.out.println("Visited InternationalNewGameStrategy");
    }

    // Hit rules
    public void visit(BasicHitStrategy rule){
        System.out.println("Visited BasicHitStrategy");
    }
    public void visit(Soft17HitStrategy rule){
        System.out.println("Visited Soft17HitStrategy");
    }

    // Win conditions
    public void visit(BasicWinCondition rule){
        System.out.println("Visited BasicWinCondition");
    }

}
