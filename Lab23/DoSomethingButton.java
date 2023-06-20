import mayflower.Actor;

public class DoSomethingButton
  extends Actor
{
  private boolean wasClicked;
  private SteppableGUIClient client;
  
  public DoSomethingButton(SteppableGUIClient client)
  {
    this.client = client;
    this.wasClicked = false;
    
    setPicture("img/button.png");
  }
  
  public void update()
  {
    if ((isClicked()) && (!this.wasClicked))
    {
      this.client.click();
      
      this.wasClicked = true;
    }
    this.wasClicked = isClicked();
  }
}
