import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean isPlaying = false;
    public int score = 0;
    public int bricks = 15;
    public int delay = 6;
    public int playerPos = 240;
    public int ballPosX = 120;
    public int ballPosY = 400;
    public int ballXDir = -1;
    public int ballYDir = -2;
    public Timer timer;
    public Gameplay(){
        gameplay();
    }
    public void gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setRequestFocusEnabled(true);
        timer = new Timer(delay, this);
        timer.start();

    }
    public void paint(Graphics g){
        g.setColor(new Color(18, 31, 104));
        g.fillRect(8, 8, 578, 748);
        //player rect
        g.setColor(new Color(248, 75, 255));
        g.fillRect(playerPos, 680, 120, 25);
        //ball oval
        g.setColor(new Color(255, 245, 48, 255));
        g.fillOval(ballPosX, ballPosY, 20, 20);


        if(ballPosY > 730){
            isPlaying = false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor(new Color(18, 31, 104));
            g.fillOval(ballPosX, ballPosY, 20, 20);
            g.setColor(new Color(156, 12, 12));
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Game Over!", 245, 350);

            g.setColor(new Color(156, 12, 12));
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press ENTER to Restart!", 170, 390);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        grabFocus();
        timer.start();
        if(isPlaying){
            ballPosX+=ballXDir;
            ballPosY+=ballYDir;
            Rectangle ballHitbox = new Rectangle(ballPosX, ballPosY, 20, 20);
            Rectangle playerHitbox = new Rectangle(playerPos, 680, 120, 25);
            //ball collides with player
            if(ballHitbox.intersects(playerHitbox)){
                ballYDir = -ballYDir;
            }
//            if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerPos, 700, 120, 25))){
//                ballYDir = -ballYDir;
//            }
            if(ballPosX <= 10){
                ballXDir = -ballXDir;
            }
            if(ballPosX >= 560){
                ballXDir = -ballXDir;
            }
            if(ballPosY <= 10){
                ballYDir = -ballYDir;
            }



        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerPos <= 20){
                playerPos = 20;
            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerPos >= 455){
                playerPos = 455;
            }else{
                moveRight();
            }
        }
    }
    public void moveLeft(){
        isPlaying = true;
        playerPos-=20;
    }
    public void moveRight(){
        isPlaying = true;
        playerPos+=20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
