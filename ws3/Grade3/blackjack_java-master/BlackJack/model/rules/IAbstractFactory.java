package BlackJack.model.rules;

public interface IAbstractFactory {


    IHitStrategy GetHitRule();

    INewGameStrategy GetNewGameRule();

    IWinCondition GetWinCondition();

    void accept(IVisitor visitor);


}
