//Name: Brendan Furtado
//ID: 260737867

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Implements both the model and panel
public class Controller extends KeyAdapter {

    public GameModel gamem;
    public GamePanel gamep;

    //Controller now will manipulate between data and the viewer/panel class,
    //bringing together the MVC design pattern.
    public Controller(GameModel gm, GamePanel gp) {

        gamem = gm;
        gamep = gp;

        gp.setPreferredSize(new Dimension(340, 400));
        gp.setFocusable(true);
        resetGame();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!gamem.canMove()) {
            gamem.myLose = true;
        }

        if (!gamem.myWin && !gamem.myLose) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gamem.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    gamem.right();
                    break;
                case KeyEvent.VK_DOWN:
                    gamem.down();
                    break;
                case KeyEvent.VK_UP:
                    gamem.up();
                    break;
            }
        }

        if (!gamem.myWin && !gamem.canMove()) {
            gamem.myLose = true;
        }

        gamep.repaint();
    }


    public void resetGame() {
        gamem.myScore = 0;
        gamem.myWin = false;
        gamem.myLose = false;
        gamem.myTiles = new Tile[4 * 4];
        for (int i = 0; i < gamem.myTiles.length; i++) {
            gamem.myTiles[i] = new Tile();
        }
        gamem.addTile();
        gamem.addTile();
    }

}
