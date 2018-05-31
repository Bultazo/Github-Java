package controller;

import contract.*;

import java.io.IOException;
import java.util.ArrayList;

public class Controller implements IController {

	private IView view;
	private IModel model;
	private Clock clock;
	public ClockAnimation anim;
	private ArrayList<IMobileElement> DeadMonsters;
	private int RefreshMonster;

	public Controller(final IView view, final IModel model) {
		this.view = view;
		this.model = model;
		this.view.setController(this);
		this.start();
	}

	public void start() {
		this.model.loadMap(5); // On charge la première map
		this.model.setResurrections(11);
		this.model.setScore(0);
		this.DeadMonsters = new ArrayList<IMobileElement>();

		clock = new Clock(this);
		clock.start();

		anim = new ClockAnimation(this);
		anim.start();
	}

	public void updateSprite() {
		if (this.model.getMap().getHero() != null) {
			((IAnimatedSprite) this.model.getMap().getHero()).next();
		}
	}

	public void updateController() {
		AIMonster();
		moveSpell();
		if (!DeadMonsters.isEmpty()) {
			for (IMobileElement monster : DeadMonsters) {
				destroyMonster(monster);
			}
		}
		model.flush();
	}

	public void orderPerform(ControllerOrder controllerOrder) throws IOException {
		IMobileElement lorann = model.getMap().getHero();
		if (lorann != null && controllerOrder != null) {
			switch (controllerOrder) {
			case UP:
				if (contactHero(lorann.getX(), lorann.getY() - 1)) {
					lorann.setDirection(controllerOrder);
					lorann.moveUp();
				}
				break;
			case DOWN:
				if (contactHero(lorann.getX(), lorann.getY() + 1)) {
					lorann.setDirection(controllerOrder);
					lorann.moveDown();
				}
				break;
			case LEFT:
				if (contactHero(lorann.getX() - 1, lorann.getY())) {
					lorann.setDirection(controllerOrder);
					lorann.moveLeft();
				}
				break;
			case RIGHT:
				if (contactHero(lorann.getX() + 1, lorann.getY())) {
					lorann.setDirection(controllerOrder);
					lorann.moveRight();
				}
				break;
			case SPACE:
				if (canCastSpell(lorann.getDirection())) {
					castSpell(lorann.getDirection());
				}
				break;
			default:
				break;
			}

			try {
				anim.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch (controllerOrder) {
		case RETRY:
			if (this.model.getResurrections() <= 0) {
				this.start();
			} else {
				model.loadMap(model.getMap().getID());
				model.setMessage("");
				if (clock.isStopped()) {
					clock = new Clock(this);
					clock.start();
				}
				model.flush();
			}
			break;
		}

	}

	public synchronized boolean contactMonster(int x, int y, IMobileElement monster) {
		int notInContact = 0;
		if (model.getMap().getElement(x, y) == null && model.getMap().getHero() != null) {
			if (monster.getX() == model.getMap().getHero().getX()
					&& monster.getY() == model.getMap().getHero().getY()) {
				gameOver();
			}
			
			else if (isSpell()) {
				if (monster.getX() == model.getMap().getSpell().getX()
						&& monster.getY() == model.getMap().getSpell().getY()) {
					DeadMonsters.add(monster);
					destroySpell();
					model.setScore(model.getScore() + 500);
				}
			}
			if (monster.getX() != x || monster.getY() != y) {
				notInContact = 1;
			}
		}
		for(IMobileElement otherMonster : model.getMap().getMobiles()) {
			if(otherMonster.getX() == x && otherMonster.getY() == y) {
				return false;
			}
		}
		if (notInContact == 1) {
			return true;
		}
		return false;
	}

	public synchronized boolean contactHero(int x, int y) {
		if (model.getMap().getElement(x, y) == null)
			return true;

		if ((model.getMap().getElement(x, y).getPermeability()) == Permeability.PENETRABLE) {
			if (model.getMap().getElement(x, y).getStateElement() == StateElement.COLLECTABLE) {
				if (model.testType(model.getMap().getElement(x, y)) == 2) {
					model.getMap().setElement(x, y, null);
					model.setScore(model.getScore() + 100);
					model.flush();
				} else if (model.testType(model.getMap().getElement(x, y)) == 4) {
					model.getMap().setElement(x, y, null);

					for (IElement[] elements : model.getMap().getElements()) {
						for (IElement element : elements) {
							if (model.testType(element) == 1) {
								model.setDoor(element);
							}
						}
					}
				}
			} else if (model.getMap().getElement(x, y).getStateElement() == StateElement.DOOR) {
				if (model.getMap().getID() < 5)
					model.loadMap(model.getMap().getID() + 1);
				else {
					model.loadMap(6);
					model.setMessage("CONGRATULATIONS, YOU WIN !!! ;)");
					this.clock.setStopped(true);
					
				}
			}
			return true;
		}

		else if (model.getMap().getElement(x, y).getStateElement() == StateElement.DRAGON) {
			gameOver();
			return false;
		}
		return false;

	}

	public synchronized void AIMonster() {
		IMobileElement lorann = this.model.getMap().getHero();

		for (IMobileElement monster : model.getMap().getMobiles()) {

			if (lorann.getY() - monster.getY() != 0 || lorann.getX() - monster.getX() != 0) {
				if ((lorann.getY() - monster.getY()) < 0
						&& contactMonster(monster.getX(), monster.getY() - 1, monster)) {
					monster.setDirection(ControllerOrder.UP);
					monster.setY(monster.getY() - 1);

				} else if ((lorann.getY() - monster.getY()) > 0
						&& contactMonster(monster.getX(), monster.getY() + 1, monster)) {
					monster.setDirection(ControllerOrder.DOWN);
					monster.setY(monster.getY() + 1);
				}

				if (lorann.getX() - monster.getX() < 0 && contactMonster(monster.getX() - 1, monster.getY(), monster)) {
					monster.setDirection(ControllerOrder.LEFT);
					monster.setX(monster.getX() - 1);
				} else if (lorann.getX() - monster.getX() > 0
						&& contactMonster(monster.getX() + 1, monster.getY(), monster)) {
					monster.setDirection(ControllerOrder.RIGHT);
					monster.setX(monster.getX() + 1);
				}
			} else {
				gameOver();
			}
		}
	}

	public void gameOver() {
		this.model.setResurrections(this.model.getResurrections() - 1);
		this.clock.setStopped(true);
		if (this.model.getResurrections() <= 0) {
			model.setMessage("NO LIVES LEFT !! \nPress R to retry");
		} else {
			model.setMessage("GAME OVER !\n Press R to restart");
			model.getMap().setHero(null);
			model.flush();
		}
	}

	public void castSpell(ControllerOrder direction) throws IOException {
		if (!isSpell()) {
			model.createSpell("fireball", direction);
			model.flush();
		}
	}

	public boolean isSpell() {
		if (model.getMap().getSpell() != null)
			return true;

		return false;
	}

	public synchronized void moveSpell() {

		if (isSpell()) {

			switch (model.getMap().getSpell().getDirection()) {
			case DOWN:
				moveSpellDirection(0, -1);
				break;
			case UP:
				moveSpellDirection(0, 1);
				break;
			case LEFT:
				moveSpellDirection(1, 0);
				break;
			case RIGHT:
				moveSpellDirection(-1, 0);
				break;

			}
			if (model.getMap().getSpell() != null) {
				((IAnimatedSprite) model.getMap().getSpell()).next();
			}
			model.flush();
		}
	}

	public synchronized void moveSpellDirection(int x, int y) {
		IMobileElement lorann = model.getMap().getHero();
		IMobileElement Spell = model.getMap().getSpell();
		if (lorann != null) {
			int xHero = lorann.getX();
			int xSpell = Spell.getX();
			int yHero = lorann.getY();
			int ySpell = Spell.getY();

			if (xHero == xSpell && yHero == ySpell)
				destroySpell();

			if (y != 0 && isSpell()) {
				if (model.getMap().getElement(Spell.getX(), Spell.getY() + y) == null)
					Spell.setY(Spell.getY() + y);

				else {
					Spell.setY(Spell.getY() - y);

					if (Spell.getDirection() == ControllerOrder.UP)
						Spell.setDirection(ControllerOrder.DOWN);
					else {
						Spell.setDirection(ControllerOrder.UP);
					}
				}
			} else if (x != 0 && isSpell()) {
				// If there is no element next to the spell
				if (model.getMap().getElement(Spell.getX() + x, Spell.getY()) == null)
					Spell.setX(Spell.getX() + x);

				// If there is an element next to the spell
				else {
					Spell.setX(Spell.getX() - x);

					if (Spell.getDirection() == ControllerOrder.LEFT)
						Spell.setDirection(ControllerOrder.RIGHT);
					else {
						Spell.setDirection(ControllerOrder.LEFT);
					}
				}
			}
		}
	}

	public synchronized void destroySpell() {
		model.getMap().setSpell(null);
	}

	public synchronized void destroyMonster(IMobileElement monster) {
		model.getMap().getMobiles().remove(monster);
	}

	public boolean canCastSpell(ControllerOrder direction) {
		switch (direction) {
		case UP:
			if (model.getMap().getElement(model.getMap().getHero().getX(),
					model.getMap().getHero().getY() + 1) == null) {
				return true;
			}
			break;
		case DOWN:
			if (model.getMap().getElement(model.getMap().getHero().getX(),
					model.getMap().getHero().getY() - 1) == null) {
				return true;
			}
			break;
		case RIGHT:
			if (model.getMap().getElement(model.getMap().getHero().getX() - 1,
					model.getMap().getHero().getY()) == null) {
				return true;
			}
			break;

		case LEFT:
			if (model.getMap().getElement(model.getMap().getHero().getX() + 1,
					model.getMap().getHero().getY()) == null) {
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}

}
