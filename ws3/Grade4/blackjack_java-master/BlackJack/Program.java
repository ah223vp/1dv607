package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.*;
import BlackJack.view.*;
import BlackJack.controller.*;
import BlackJack.viewGUI.Window;

public class Program
{

  public static void main(String[] a_args)
  {

    // Sending the rule to use from here


    PrintRulesVisitor visitor = new PrintRulesVisitor();

    //IAbstractFactory rules = new RulesFactory();
    IAbstractFactory rules = new RulesFactory_2();

    Game g = new Game(rules, visitor);
    //IView v = new SimpleView(); //new SwedishView();

    Window vGUI = new Window();

    PlayGame ctrl = new PlayGame();

    ctrl.Play(g, vGUI);
    Window.launch(Window.class);

    
    //while (ctrl.Play(g, vGUI));


  }
}