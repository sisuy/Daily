package GUI;
import java.awt.*;

public class GUI {
    Frame frame = new Frame();

    public GUI(){
        frame.setSize(500,300);

        Panel panel = new Panel();
        frame.add(panel);

        // button
        Button add  = new Button("add");
        Button search = new Button("search");

        frame.add(add);
        frame.add(search);

        frame.setLayout(new FlowLayout());


        frame.setSize(1000,700);
        frame.setLocation(700,300);
        frame.setVisible(true);
    }

}
