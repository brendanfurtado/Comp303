//Name: Brendan Furtado
//ID: 260737867

import javax.swing.*;
//This class possesses the main program to run 2048
public class Launcher {
    public static void main(String[] args) {

        //instantiate the model view and controller here.

        GameModel gamemodel = new GameModel();

        GamePanel gamepanel = new GamePanel(gamemodel);

        Controller control = new Controller(gamemodel, gamepanel);

        // setup the dimensions and title of the JFrame and set the interior to the gamepanel object.

        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("2048 Game");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(340, 400);
        gameFrame.setResizable(true);


        gamepanel.addKeyListener(control);
        gameFrame.add(gamepanel);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}
