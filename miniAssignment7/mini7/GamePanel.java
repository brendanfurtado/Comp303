//Name: Brendan Furtado
//ID: 260737867

import javax.swing.*;
import java.awt.*;

/**
 * Modified by Mathieu Nassif
 * 
 * @author Konstantin Bulenkov
 */
//This class acts as the viewer part of the MVC design pattern
public class GamePanel extends JPanel {
	
	public static final Color BG_COLOR = new Color(0xbbada0);
	public static final String FONT_NAME = "Arial";
	public static final int TILE_SIZE = 64;
	public static final int TILES_MARGIN = 16;
	public GameModel gm;

    public GamePanel(GameModel gm) {

        this.gm = gm;

        setPreferredSize(new Dimension(340, 400));
        setFocusable(true);
        gm.resetGame();
    }


	@Override
	public void paint(Graphics g) {


		super.paint(g);
		g.setColor(BG_COLOR);
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				drawTile(g, gm.myTiles[x + y * 4], x, y);
			}
		}
	}

	public void drawTile(Graphics g2, Tile tile, int x, int y) {
		Graphics2D g = ((Graphics2D) g2);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
		int value = tile.value;
		int xOffset = offsetCoors(x);
		int yOffset = offsetCoors(y);
		g.setColor(tile.getBackground());
		g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 14, 14);
		g.setColor(tile.getForeground());
		final int size = value < 100 ? 36 : value < 1000 ? 32 : 24;
		final Font font = new Font(FONT_NAME, Font.BOLD, size);
		g.setFont(font);

		String s = String.valueOf(value);
		final FontMetrics fm = getFontMetrics(font);

		final int w = fm.stringWidth(s);
		final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

		if (value != 0)
			g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);

		if (gm.myWin || gm.myLose) {
			g.setColor(new Color(255, 255, 255, 30));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(new Color(78, 139, 202));
			g.setFont(new Font(FONT_NAME, Font.BOLD, 48));
			if (gm.myWin) {
				g.drawString("You won!", 68, 150);
			}
			if (gm.myLose) {
				g.drawString("Game over!", 50, 130);
				g.drawString("You lose!", 64, 200);
			}
			if (gm.myWin || gm.myLose) {
				g.setFont(new Font(FONT_NAME, Font.PLAIN, 16));
				g.setColor(new Color(128, 128, 128, 128));
				g.drawString("Press ESC to play again", 80, getHeight() - 40);
			}
		}
		g.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
		g.drawString("Score: " + gm.myScore, 200, 365);

	}


	public int offsetCoors(int arg) {
		return arg * (TILES_MARGIN + TILE_SIZE) + TILES_MARGIN;
	}

}
