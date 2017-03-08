package Random_XY;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Random_XY_UI {
    // visual components
    private JFileChooser fileChooser = new JFileChooser();
    
    private Action openAction = new openAction();
    private Action saveAction = new saveAction();
    private Action exitAction = new exitAction();
    
    JFrame main = new JFrame();
    
    JPanel headPane = new JPanel();
    JLabel header = new JLabel("Random X Y coordinate generator.");
    JLabel prompt = new JLabel("Fill out the boxes.");
    
    JPanel dataPane = new JPanel();
    JLabel min_value = new JLabel("Please enter the X multiplier:");
    JTextArea min_value_text = new JTextArea("", 2, 4);
    JLabel max_value = new JLabel("Please enter the Y multiplier:");
    JTextArea max_value_text = new JTextArea("", 2, 4);
    JLabel num_of_points = new JLabel("Please enter number of points:");
    JTextArea points_text = new JTextArea("", 2, 4);
    
    JPanel displayPane = new JPanel();
    JScrollPane scroll = new JScrollPane(displayPane);
    JTextArea text = new JTextArea("", 50, 10);    
    JButton enter = new JButton("Enter");
    
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = menuBar.add(new JMenu("File"));
    
    public void Random_XY_UI(){
        // Drop down menu
        fileMenu.setMnemonic('F');
        fileMenu.add(openAction);
        fileMenu.add(saveAction);
        fileMenu.add(exitAction);
        // Add components to panes
        headPane.add(header);
        headPane.add(prompt);
        header.setForeground(Color.cyan);
        prompt.setForeground(Color.cyan);
        headPane.add(enter);
        dataPane.add(min_value);
        min_value.setForeground(Color.cyan);
        dataPane.add(min_value_text);
        dataPane.add(max_value);
        max_value.setForeground(Color.cyan);
        dataPane.add(max_value_text);
        dataPane.add(num_of_points);
        num_of_points.setForeground(Color.cyan);
        dataPane.add(points_text);
        GridLayout grd4 = new GridLayout(2,1);
        displayPane.setLayout(grd4);
        displayPane.add(text);
        headPane.setBackground(Color.DARK_GRAY);
        dataPane.setBackground(Color.DARK_GRAY);
        displayPane.setBackground(Color.DARK_GRAY);
        
        // Main frame set-up
        GridLayout grd1 = new GridLayout(1,3);
        main.setLayout(grd1);
        main.add(headPane);
        main.add(dataPane);
        main.add(scroll);
        main.setSize(650,250);
        main.setJMenuBar(menuBar);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("Random X Y Generator");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
    }
    
    // getters of text
    public int get_num_points() {
        String a = points_text.getText().trim();
        int b = Integer.parseInt(a);
        return b;        
    }
    public int get_min_value() {
        String a = min_value_text.getText().trim();
        int b = Integer.parseInt(a);
        return b;
    }
    public int get_max_value() {
        String a = max_value_text.getText().trim();
        int b = Integer.parseInt(a);
        return b;
    }
    // setters of text
    public void set_text(String t) {
        text.setText(t);
    }
    class openAction extends AbstractAction {
    
    public openAction() {
        super("Open file...");
        putValue(MNEMONIC_KEY, new Integer('O'));
    }
    
    public void actionPerformed(ActionEvent e) {
    int retval = fileChooser.showOpenDialog(null); 
    if (retval == JFileChooser.APPROVE_OPTION) {
        File f = fileChooser.getSelectedFile();
        try {
            FileReader reader = new FileReader(f);
            text.read(reader, "");
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, ioex);
            System.exit(1);
        }
    }
    }
}

class saveAction extends AbstractAction {
    
    public saveAction() {
        super("Save file...");
        putValue(MNEMONIC_KEY, new Integer('S'));
    }
    
    public void actionPerformed(ActionEvent e) {
        int retval = fileChooser.showSaveDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try {
                FileWriter write = new FileWriter(f);
                text.write(write);
            } catch (IOException ioex) {
                JOptionPane.showMessageDialog(null, ioex);
                System.exit(1);
            }
        }
    }
}

class exitAction extends AbstractAction {
    
    public exitAction() {
        super("Exit.");
        putValue(MNEMONIC_KEY, new Integer('X'));
    }
    
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
}