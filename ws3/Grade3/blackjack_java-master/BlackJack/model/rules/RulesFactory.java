package BlackJack.model.rules;

public class RulesFactory implements IAbstractFactory {

  private String name = "RulesFactory";

  public IHitStrategy GetHitRule() {
    //return new BasicHitStrategy();
    return new Soft17HitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  public IWinCondition GetWinCondition(){
    return new BasicWinCondition();
  }

  public String getName(){
    return name;
  }
}