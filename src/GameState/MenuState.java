package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    private Background bg;

    private int currentChoice = 0;
    private String[] options = {
            "Easy",
            "Hard",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm) {

        this.gsm = gsm;

        try {

            bg = new Background("/Backgrounds/menubg.jpg", 0);
            bg.setVector(0, 0);

            titleColor = new Color(255, 223, 27);
            titleFont = new Font(
                    "Sansserif",
                    Font.BOLD,
                    32);

            font = new Font("Arial", Font.PLAIN, 12);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void init() {}

    public void update() {
        bg.update();
    }

    public void draw(Graphics2D g) {

        // draw bg
        bg.draw(g);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Testing Java", 65, 75);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.BLUE);
            }
            else {
                g.setColor(Color.cyan);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }

    }

    private void select() {
        if(currentChoice == 0) {
            // start
        }
        if(currentChoice == 1) {
            // help
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }

    public void keyReleased(int k) {}

}











