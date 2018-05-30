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
		int y;
		int x = 0;
		for (IElement[] element : viewFrame.getModel().getMap().getElements()) {
			y = 0;
			for (IElement e : element) {
				if (e != null) {
					graphics.drawImage(e.getSprite().getImage(), x * ZOOM + 1, y * ZOOM + 1, null);
				}
				y++;
			}
			x++;
		}
		
		// Draw the Hero
		IMobileElement lorann = viewFrame.getModel().getMap().getHero();
		if (lorann != null) {
			graphics.drawImage((lorann.getSprite().getImage()),
					lorann.getX() * ZOOM,
					lorann.getY() * ZOOM, null);
		}

		for (IMobileElement element : viewFrame.getModel().getMap().getMobiles()) {
			if (element != null) {
				graphics.drawImage(element.getSprite().getImage(), element.getX()*ZOOM, element.getY()*ZOOM, null);
				System.out.println(element.toString());
			}
		}
		
		// Draw the spell if exist
		if (viewFrame.getModel().getMap().getSpell() != null) {
			graphics.drawImage((viewFrame.getModel().getMap().getSpell().getSprite().getImage()),
					viewFrame.getModel().getMap().getSpell().getX() * ZOOM,
					viewFrame.getModel().getMap().getSpell().getY() * ZOOM, null);
		}

		graphics.setFont(new Font("Calibri", Font.PLAIN, 30));

		// Draw the message (GAME OVER OR YOU WIN)
		if (viewFrame.getModel().getMessage() != null)
			graphics.drawString(viewFrame.getModel().getMessage(),
					(viewFrame.getWidth() / 2) - (viewFrame.getModel().getMessage().length() * 10),
					(viewFrame.getHeight()) - viewFrame.getModel().getMessage().length() * 5);

		graphics.setColor(Color.CYAN);
		graphics.drawString("Resurrections : " + viewFrame.getModel().getMap().getScore(),
				(viewFrame.getWidth() / 10) - 50, viewFrame.getHeight() - 40);

		graphics.setColor(Color.YELLOW);
		graphics.drawString("Score : " + viewFrame.getModel().getMap().getScore(), (viewFrame.getWidth() / 10 * 9) - 60,
				viewFrame.getHeight() - 40);
	}
}
