import javax.swing.JFrame;
import java.awt.*;


public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame("Testing Project");
        frame.setVisible(true);
        frame.setContentPane(new GamePanel());
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 800));
        frame.setDefaultCloseOperation(3);
        frame.pack();


    }

}

