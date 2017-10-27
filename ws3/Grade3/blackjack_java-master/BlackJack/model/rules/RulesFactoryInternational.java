package BlackJack.model.rules;

public class RulesFactoryInternational implements IAbstractFactory {


    public IHitStrategy GetHitRule() {

        return new BasicHitStrategy();
    }

    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    public IWinCondition GetWinCondition(){
        return new PlayerWinOnEvenWinCondition();
    }


}
