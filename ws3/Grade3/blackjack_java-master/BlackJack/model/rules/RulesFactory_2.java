package BlackJack.model.rules;

public class RulesFactory_2 implements IAbstractFactory {


    public IHitStrategy GetHitRule() {

        return new BasicHitStrategy();
    }

    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    public IWinCondition GetWinCondition(){
        return new BasicWinCondition();
    }


}
