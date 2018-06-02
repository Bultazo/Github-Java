package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;
import model.IElement;
import model.IMobileElement;

/**
 * @author DELL
 *
 */
class Panel extends JPanel implements Observer {

	/**
	 * The viewFrame
	 */
	private Frame viewFrame;
	/**
	 * The ZOOM
	 */
	private static final int ZOOM = 32;
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * The main constructor 
	 * @param viewFrame
	 */
	Panel(final Frame viewFrame) {
		this.viewFrame = viewFrame;
		this.setSize(viewFrame.getWidth(), viewFrame.getHeight());
		repaint();
	}

	/*
	 * Overrides the update Method in the implemented interface
	 */ 
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * Overrides the paintComponent Method in the implemented interface
	 */ 
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, this.viewFrame.getWidth(), this.viewFrame.getHeight());

		this.fillMap(graphics);
		this.drawLorann(graphics);
		this.drawMonsters(graphics);
		this.drawGUI(graphics);
		this.drawSpell(graphics);
		this.drawMessage(graphics);
	}

	/**
	 * Fills the map
	 * @param g
	 */
	void fillMap(Graphics g) {
		int y, x = 0;
		for (IElement[] element : viewFrame.getModel().getMap().getElements()) {
			y = 0;
			for (IElement e : element) {
				if (e != null) {
					g.drawImage(e.getSprite().getImage(), x * ZOOM + 1, y * ZOOM + 1, null);
				}
				y++;
			}
			x++;
		}
	}

	/**
	 * Draws the score and the lives
	 * @param g
	 */
	void drawGUI(Graphics g) {
		g.setFont(new Font("Calibri", Font.PLAIN, 30));

		// Afficher le nombre de vies restantes
		g.setColor(Color.CYAN);
		g.drawString("Resurrections : " + viewFrame.getModel().getResurrections(), 50, viewFrame.getHeight() - 40);

		// Afficher le score
		g.setColor(Color.WHITE);
		g.drawString("Score : " + viewFrame.getModel().getScore(), (viewFrame.getWidth() - 200),
				viewFrame.getHeight() - 40);
	}

	/**
	 * Draws Lorann (tm)
	 * @param g
	 */
	void drawLorann(Graphics g) {
		IMobileElement lorann = viewFrame.getModel().getMap().getHero();
		if (lorann != null) {
			g.drawImage((lorann.getSprite().getImage()), lorann.getX() * ZOOM, lorann.getY() * ZOOM, null);
		}
	}

	/**
	 * Draws the monsters
	 * @param g
	 */
	void drawMonsters(Graphics g) {
		for (IMobileElement element : viewFrame.getModel().getMap().getMobiles()) {
			if (element != null) {
				g.drawImage(element.getSprite().getImage(), element.getX() * ZOOM, element.getY() * ZOOM, null);
			}
		}
	}

	/**
	 * Draws a spell
	 * @param g
	 */
	void drawSpell(Graphics g) {
		IMobileElement spell = viewFrame.getModel().getMap().getSpell();
		IMobileElement lorann = viewFrame.getModel().getMap().getHero();
		if (spell != null && lorann != null && (spell.getX() != lorann.getX() || spell.getY() != lorann.getY())) {
			g.drawImage((viewFrame.getModel().getMap().getSpell().getSprite().getImage()),
					viewFrame.getModel().getMap().getSpell().getX() * ZOOM,
					viewFrame.getModel().getMap().getSpell().getY() * ZOOM, null);
		}
	}


	/**
	 * Draws a message
	 * @param g
	 */
	void drawMessage(Graphics g) {
		// Draw the message (GAME OVER OR YOU WIN)
		if (viewFrame.getModel().getMessage() != null) {
			g.drawString(viewFrame.getModel().getMessage(),
					(viewFrame.getWidth() / 2) - (viewFrame.getModel().getMessage().length() * 6),
					(viewFrame.getHeight()) - viewFrame.getModel().getMessage().length() * 3);
		}
	}
}
