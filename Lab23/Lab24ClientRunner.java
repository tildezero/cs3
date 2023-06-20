public class Lab24ClientRunner
{
  public static void main(String[] args)
  {
    TicTacToeClient a = new PlayableGUIClient();
    //TicTacToeClient a = new AutomatedGUIClient(MyAI());
    //TicTacToeClient a = new SteppableGUIClient(new MyAI());
    a.connect("localhost", 1234);
    
    //TicTacToeClient b = new AutomatedClient(new RandomAI("RandomBOT"));
    TicTacToeClient b = new AutomatedClient(new MyAI());
    b.connect("localhost", 1234);
  }
}
