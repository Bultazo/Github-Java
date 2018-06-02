package controller;

import contract.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements IController {

	private IView view;
	private IModel model;
	private Clock clock;
	private ClockLorann move;

	private ArrayList<IMobileElement> DeadMonsters;
	private int RefreshMonster;
	private IMobileElement lorann;
	private IMobileElement spell;
	private int scoreLevel;

	public Controller(final IView view, final IModel model) {
		this.view = view;
		this.model = model;
		this.view.setController(this);
	}

	public void start() {
		this.init();

		clock = new Clock(this);
		clock.start();

		move = new ClockLorann(this);
		move.start();

	}

	public void init() {
		this.model.loadMap(1); // On charge la première map
		this.model.setResurrections(11);
		this.model.setScore(0);
		this.lorann = model.getMap().getHero();
		this.DeadMonsters = new ArrayList<IMobileElement>();
		this.scoreLevel = model.getScore();
	}

	public void gameOver() {
		this.model.setResurrections(this.model.getResurrections() - 1);
		this.clock.setStopped(true);

		model.getMap().setHero(null);
		lorann = null;

		if (this.model.getResurrections() <= 0) {
			model.setMessage("NO LIVES LEFT !! \nPress R to retry");
			Sounds.GAMEOVER.play();
			model.flush();
		} else {
			model.setMessage("GAME OVER !\n Press R to restart");
			Sounds.HIT.play();
			model.flush();
		}
	}

	public void updateSprite() {
		if (this.lorann != null) {
			((IAnimatedSprite) this.lorann).next();
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
		if (controllerOrder != null) {
			if (lorann != null) {
				switch (controllerOrder) {
				case UP:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX(), lorann.getY() - 1)) {
						lorann.moveUp();
					}
					break;
				case DOWN:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX(), lorann.getY() + 1)) {
						lorann.moveDown();
					}
					break;
				case LEFT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() - 1, lorann.getY())) {
						lorann.moveLeft();
					}
					break;
				case RIGHT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() + 1, lorann.getY())) {
						lorann.moveRight();
					}
					break;
				case SPACE:
					if (canCastSpell(lorann.getDirection())) {
						castSpell();
						spell = model.getMap().getSpell();
					}
					break;
				default:
					break;
				}

			}
			switch (controllerOrder) {
			case RETRY:
				if (this.model.getResurrections() <= 0) {
					this.init();
				} else {
					DeadMonsters.clear();
					model.loadMap(model.getMap().getID());
					model.setMessage("");
					lorann = model.getMap().getHero();
					model.setScore(scoreLevel);
					model.flush();
				}
				if (clock.isStopped()) {
					clock.setStopped(false);
					clock = new Clock(this);
					clock.start();
				}
				break;
			}
		}
	}

	public synchronized boolean contactHero(int x, int y) {
		if (model.getMap().getElement(x, y) != null) {
			if ((model.getMap().getElement(x, y).getPermeability()) == Permeability.PENETRABLE) {
				if (model.getMap().getElement(x, y).getStateElement() == StateElement.COLLECTABLE) {
					if (model.testType(model.getMap().getElement(x, y)) == 2) {
						Sounds.COIN.play();

						model.getMap().setElement(x, y, null);
						model.setScore(model.getScore() + 100);
						model.flush();

						return true;

					} else if (model.testType(model.getMap().getElement(x, y)) == 4) {
						Sounds.DOOR.play();

						model.getMap().setElement(x, y, null);
						model.setOpenDoor(model.getMap().getDoor());
					}
				} else if (model.getMap().getElement(x, y).getStateElement() == StateElement.DOOR) {

					this.scoreLevel = model.getScore();
					if (model.getMap().getID() < 5) {
						model.loadMap(model.getMap().getID() + 1);
						lorann = model.getMap().getHero();
					} else {

						model.loadMap(6);
						model.setMessage("CONGRATULATIONS, YOU WIN !!! ;)");
						lorann = model.getMap().getHero();
						model.flush();
						Sounds.YOUWIN2.loop();
					}
					return true;
				}
			} else if (model.getMap().getElement(x, y).getStateElement() == StateElement.DRAGON) {
				gameOver();
				return false;
			}

		}
		if (model.getMap().getElement(x, y) == null) {
			for (IMobileElement monster : model.getMap().getMobiles()) {
				if (monster.getX() == x && monster.getY() == y) {
					gameOver();
					return false;
				}
			}
			return true;
		}
		return false;

	}

	public synchronized boolean contactMonster(int x, int y, IMobileElement monster) {
		int notInContact = 0;
		if (model.getMap().getElement(x, y) == null && lorann != null) {
			if (lorann.getX() == x && lorann.getY() == y) {
				gameOver();
			}

			else if (isSpell()) {
				if (monster.getX() == spell.getX() && monster.getY() == spell.getY()) {
					DeadMonsters.add(monster);
					Sounds.EXPLOSION.play();
					destroySpell();
					model.setScore(model.getScore() + 500);
				}
			}
			if (monster.getX() != x || monster.getY() != y) {
				notInContact = 1;
			}
		}
		for (IMobileElement otherMonster : model.getMap().getMobiles()) {
			if (otherMonster.getX() == x && otherMonster.getY() == y) {
				return false;
			}
		}
		if (notInContact == 1) {
			return true;
		}
		return false;
	}

	public synchronized void AIMonster() {

	}

	public IView getView() {
		return view;
	}

	public void castSpell() throws IOException {
		if (!isSpell()) {
			model.createSpell("fireball");
			model.flush();
		}
	}

	public boolean isSpell() {
		if (spell != null)
			return true;

		return false;
	}

	public synchronized void moveSpell() {

		if (isSpell()) {
			if (lorann != null) {
				int xHero = lorann.getX();
				int xSpell = spell.getX();
				int yHero = lorann.getY();
				int ySpell = spell.getY();

				if (xHero == xSpell && yHero == ySpell) {
					destroySpell();
				} else {
					switch (spell.getDirection()) {
					case DOWN:
						spell.moveDown();
						break;
					case UP:
						spell.moveUp();
						break;
					case LEFT:
						spell.moveLeft();
						break;
					case RIGHT:
						spell.moveRight();
						break;
					default:
						break;
					}

					if (spell != null) {
						((IAnimatedSprite) spell).next();
					}
					model.flush();
				}
			}
		}
	}

	public boolean canCastSpell(ControllerOrder direction) {
		switch (direction) {
		case UP:
			if (model.getMap().getElement(lorann.getX(), lorann.getY() + 1) == null) {
				return true;
			}
			break;
		case DOWN:
			if (model.getMap().getElement(lorann.getX(), lorann.getY() - 1) == null) {
				return true;
			}
			break;
		case RIGHT:
			if (model.getMap().getElement(lorann.getX() - 1, lorann.getY()) == null) {
				return true;
			}
			break;
		case LEFT:
			if (model.getMap().getElement(lorann.getX() + 1, lorann.getY()) == null) {
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}

	public synchronized void destroySpell() {
		model.getMap().setSpell(null);
	}

	public synchronized void destroyMonster(IMobileElement monster) {
		model.getMap().getMobiles().remove(monster);
	}

}
