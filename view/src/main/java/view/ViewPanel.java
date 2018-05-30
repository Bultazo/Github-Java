package view;

import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.*;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;

	private static final long serialVersionUID = -998294702363713521L;

	ViewPanel(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
		this.setViewFrame(viewFrame);
		this.setSize(viewFrame.getWidth(), viewFrame.getHeight());

		viewFrame.getModel().getObservable().addObserver(this);
		repaint();
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
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
					graphics.drawImage(e.getSprite().getImage(), x * 32 + 1, y * 32 + 1, null);
				}
				y++;
			}
			x++;
		}

		// Draw the spell if exist
		if (viewFrame.getModel().getMap().getSpell() != null) {
			graphics.drawImage((viewFrame.getModel().getMap().getSpell().getSprite().getImage()),
					viewFrame.getModel().getMap().getSpell().getX() * 32,
					viewFrame.getModel().getMap().getSpell().getY() * 32, null);
		}

	

		Font font = new Font("TimesRoman", Font.BOLD, 30);
		graphics.setFont(font);
		graphics.setColor(Color.YELLOW);

		// Draw the message (GAME OVER OR YOU WIN)
		if (viewFrame.getModel().getMessage() != null)
			graphics.drawString(viewFrame.getModel().getMessage(),
					(viewFrame.getWidth() / 2) - (viewFrame.getModel().getMessage().length() * 10),
					(viewFrame.getHeight()) - viewFrame.getModel().getMessage().length() * 5);

		// Draw the score of the map
		graphics.drawString("SCORE : " + viewFrame.getModel().getMap().getScore(), (viewFrame.getWidth() / 10) - 50,
				410);

		// Draw the indication for retry
		graphics.drawString("R to retry", (viewFrame.getWidth() / 10) + 427, 410);
	}
}
