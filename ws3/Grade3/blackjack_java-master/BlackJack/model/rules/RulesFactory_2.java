package BlackJack.model.rules;

public class RulesFactory_2 implements IAbstractFactory {


    private BasicHitStrategy rule;

    public IHitStrategy GetHitRule() {

        rule = new BasicHitStrategy();
        return rule;

    }

    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    public IWinCondition GetWinCondition(){
        return new BasicWinCondition();
    }

    public void accept(IVisitor visitor){
        rule.accept(visitor);
    }


}
