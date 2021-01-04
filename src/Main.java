import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setTitle("Testing Project");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 800));
        frame.setDefaultCloseOperation(3);
        Gameplay gameplay = new Gameplay();
        frame.add(gameplay);
    }
}
