package BlackJack.model.rules;



public interface IVisitor {


    void visit(AmericanNewGameStrategy rule);
    void visit(Soft17HitStrategy rule);
    void visit(BasicWinCondition rule);
    void visit(InternationalNewGameStrategy rule);
    void visit(BasicHitStrategy rule);
    void visit(PlayerWinOnEvenWinCondition rule);

}
