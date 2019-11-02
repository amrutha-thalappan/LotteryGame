import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amrutha Nair THALAPPAN
 */
public class RunLotteryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        var welcomeTolo = new WelcomeTolo();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int height = screenSize.height;
  int width = screenSize.width;
  welcomeTolo.setSize(width/2, height/2);
  welcomeTolo.setLocationRelativeTo(null);
        welcomeTolo.setTitle("Lottery Game");
        welcomeTolo.setVisible(true);
    
    }
    
}
