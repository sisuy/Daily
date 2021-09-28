package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Recorder.Recorder;

public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Recorder");

        /**set size and location*/
        frame.setLocation(750,300);
        frame.setSize(700,500);
        frame.setResizable(true);


        /**Panel*/
        JPanel jpanel1 = new JPanel();


        /**Label*/
        JLabel label = new JLabel("Recorder");


        /**button*/
        JButton addition = new JButton("add",new ImageIcon());
        addition.setBackground(Color.CYAN);

        /**add*/


        //frame.add(addition);
        frame.setVisible(true);
    }
}
