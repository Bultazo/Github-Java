package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;

class Panel extends JPanel implements Observer {

	private Frame viewFrame;
	private static final int ZOOM = 32;
	private static final long serialVersionUID = -998294702363713521L;

	Panel(final Frame viewFrame) {
		this.viewFrame = viewFrame;
		this.setSize(viewFrame.getWidth(), viewFrame.getHeight());
		repaint();
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

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

	void drawLorann(Graphics g) {
		IMobileElement lorann = viewFrame.getModel().getMap().getHero();
		if (lorann != null) {
			g.drawImage((lorann.getSprite().getImage()), lorann.getX() * ZOOM, lorann.getY() * ZOOM, null);
		}
	}

	void drawMonsters(Graphics g) {
		for (IMobileElement element : viewFrame.getModel().getMap().getMobiles()) {
			if (element != null) {
				g.drawImage(element.getSprite().getImage(), element.getX() * ZOOM, element.getY() * ZOOM, null);
			}
		}
	}

	void drawSpell(Graphics g) {
		IMobileElement spell = viewFrame.getModel().getMap().getSpell();
		IMobileElement lorann = viewFrame.getModel().getMap().getHero();
		if (spell != null && lorann != null && (spell.getX() != lorann.getX() || spell.getY() != lorann.getY())) {
			g.drawImage((viewFrame.getModel().getMap().getSpell().getSprite().getImage()),
					viewFrame.getModel().getMap().getSpell().getX() * ZOOM,
					viewFrame.getModel().getMap().getSpell().getY() * ZOOM, null);
		}
	}

	void drawMessage(Graphics g) {
		// Draw the message (GAME OVER OR YOU WIN)
		if (viewFrame.getModel().getMessage() != null) {
			g.drawString(viewFrame.getModel().getMessage(),
					(viewFrame.getWidth() / 2) - (viewFrame.getModel().getMessage().length() * 6),
					(viewFrame.getHeight()) - viewFrame.getModel().getMessage().length() * 3);
		}
	}
}
