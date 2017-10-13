package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.*;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {

    // Sending the rule to use from here

    //IAbstractFactory rules = new RulesFactory();
    IAbstractFactory rules = new RulesFactory_2();

    Game g = new Game(rules);
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame();

    PrintRulesVisitor visitor = new PrintRulesVisitor();

    //g.accept(visitor);
    rules.accept(visitor);
    
    while (ctrl.Play(g, v));

  }
}