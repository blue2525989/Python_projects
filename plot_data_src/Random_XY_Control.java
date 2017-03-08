package Random_XY;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class Random_XY_Control {
    
    Random_XY_UI UI = new Random_XY_UI();
    
    public Random_XY_Control () {
        UI.enter.addActionListener(new Listener());
    }
    
    class Listener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
        
        if (event.getSource() == UI.enter) {
            try {
            double min = UI.get_min_value();
            double max = UI.get_max_value();
            double point = UI.get_num_points();
            
            double x = Math.random();
            double y = Math.random();
            
            int count = 0;
            while (count != point) {
                x = x + min / Math.random();
                y = y + max / Math.random();
                x = x * 0.75;
                y = y * 0.75;
                int X = (int)x;
                int Y = (int)y;
                
                UI.text.append(X +" " + Y + "\n");
                count += 1;
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }    
    }
        
    }
}
