package BlackJack.model.rules;

public class RulesFactory {

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
}