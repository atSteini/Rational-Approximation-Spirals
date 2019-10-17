package primes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener
  implements ActionListener
{
  public void actionPerformed(ActionEvent e) {
    Frame.handleInput();
    
    Panel.makeParticles(var.selectedNumber);
  }
}
