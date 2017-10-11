package BlackJack.model.rules;

public class RulesFactory_2 implements IAbstractFactory {

    private String name = "RulesFactory_2";

    public IHitStrategy GetHitRule() {

        return new BasicHitStrategy();

    }

    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    public IWinCondition GetWinCondition(){
        return new BasicWinCondition();
    }

    public String getName(){
        return name;
    }
}
