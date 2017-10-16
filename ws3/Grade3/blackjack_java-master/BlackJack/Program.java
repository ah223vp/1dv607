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


    PrintRulesVisitor visitor = new PrintRulesVisitor();

    //IAbstractFactory rules = new RulesFactory();
    IAbstractFactory rules = new RulesFactory_2();

    Game g = new Game(rules, visitor);
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame();

    
    while (ctrl.Play(g, v));

  }
}