package controller;

import contract.*;
import model.IAnimatedSprite;
import model.IMobileElement;
import model.IModel;
import view.IView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author DELL
 *
 */
public class Controller implements IController {

	/**
	 * The view
	 */
	IView view;
	/**
	 * The model
	 */
	IModel model;

	/**
	 * The clock
	 */
	private Clock clock;
	/**
	 * The move
	 */
	private ClockLorann move;

	/**
	 * The list of monsters to be killed
	 */
	private ArrayList<IMobileElement> DeadMonsters;

	/**
	 * Lorann
	 */
	IMobileElement lorann;
	/**
	 * The spell
	 */
	IMobileElement spell;
	/**
	 * The scoreLevel
	 */
	int scoreLevel;

	/**
	 * The main constructor
	 * 
	 * @param view
	 * @param model
	 */
	public Controller(final IView view, final IModel model) {
		this.view = view;
		this.model = model;
	}

	/*
	 * Overrides the start Method in the implemented interface
	 */
	public void start() {
		this.init();

		clock = new Clock(this);
		clock.start();

		move = new ClockLorann(this);
		move.start();

	}

	/**
	 * Initialize all the needed variables to start a new game
	 * 
	 */
	public void init() {
		this.model.loadMap(1); // On charge la première map
		this.model.setResurrections(11);
		this.model.setScore(0);
		this.lorann = model.getMap().getHero();
		this.DeadMonsters = new ArrayList<IMobileElement>();
		this.scoreLevel = model.getScore();
	}

	/**
	 * Ends the game (1 Life lost)
	 * 
	 */
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

	/*
	 * Overrides the updateSprite Method in the implemented interface
	 */
	public void updateSprite() {
		if (this.lorann != null) {
			((IAnimatedSprite) this.lorann).next();
		}
	}

	/*
	 * Overrides the updateController Method in the implemented interface
	 */
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

	/*
	 * Overrides the orderPerform Method in the implemented interface
	 * 
	 * @param controllerOrder
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException {
		if (controllerOrder != null) {
			if (lorann != null && model.getMap().getHero() != null) {
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
				case UPRIGHT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() + 1, lorann.getY() - 1)) {
						lorann.moveUpRight();
					}
					break;
				case DOWNRIGHT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() + 1, lorann.getY() + 1)) {
						lorann.moveDownRight();
					}
					break;
				case UPLEFT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() - 1, lorann.getY() - 1)) {
						lorann.moveUpLeft();
					}
					break;
				case DOWNLEFT:
					lorann.setDirection(controllerOrder);
					if (contactHero(lorann.getX() - 1, lorann.getY() + 1)) {
						lorann.moveDownLeft();
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
					Sounds.GAMEOVER.stop();
					this.destroySpell();
					this.init();
				} else {
					DeadMonsters.clear();
					model.loadMap(model.getMap().getID());
					model.setMessage("");
					lorann = model.getMap().getHero();
					spell = null;
					model.setScore(scoreLevel);
					model.flush();
				}
				if (clock.isStopped()) {

					clock = new Clock(this);
					clock.start();
				}
				break;
			}
		}
	}

	/*
	 * Overrides the contactHero Method in the implemented interface
	 * 
	 * @param x
	 * 
	 * @param y
	 * 
	 * @return
	 */
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
					Sounds.DOOROPEN.play();
					this.scoreLevel = model.getScore();
					destroySpell();

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
			if (isSpell()) {
				int xHero = lorann.getX();
				int xSpell = spell.getX();
				int yHero = lorann.getY();
				int ySpell = spell.getY();

				if (xHero == xSpell && yHero == ySpell) {
					destroySpell();
				}
			}

			return true;
		}
		return false;

	}

	/*
	 * Overrides the contactMonster Method in the implemented interface
	 * 
	 * @param x
	 * 
	 * @param y
	 * 
	 * @param monster
	 * 
	 * @return
	 */
	public synchronized boolean contactMonster(int x, int y, IMobileElement monster) {
		if (model.getMap().getElement(x, y) == null) {

			if (lorann != null && lorann.getX() == x && lorann.getY() == y) { // If there will be a contact with the
																				// hero.
				gameOver();
			} else if (isSpell()) { // If there is a spell
				if ((spell.getX() == x && spell.getY() == y)
						|| (spell.getX() == monster.getX() && spell.getY() == monster.getY())) { // If there will be a
																									// contact with the
																									// spell
					DeadMonsters.add(monster);
					Sounds.EXPLOSION.play();
					destroySpell();
					model.setScore(model.getScore() + 100);
				}
			}
			for (IMobileElement otherMonster : model.getMap().getMobiles()) {
				if (otherMonster.getX() == x && otherMonster.getY() == y) { // If there will be a contact with other
					return false; // monsters
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/*
	 * Overrides the AIMonster Method in the implemented interface
	 */
	public synchronized void AIMonster() {

		for (IMobileElement monster : model.getMap().getMobiles()) {
			if (lorann != null && model.getMap().getHero() != null) {
				int distX = lorann.getX() - monster.getX();
				int distY = lorann.getY() - monster.getY();

				if (Math.abs(distX) <= 4 && Math.abs(distY) <= 4) { // Si on est dans la zone d'aggro

					// On calcule la position qui correspond à la premiere case de la distance de
					// lorann par rapport au monstre
					if (distY != 0) {
						distY = distY / Math.abs(distY);
					}
					if (distX != 0) {
						distX = distX / Math.abs(distX);
					}

					// Si le monstre est libre dans les deux directions
					if (contactMonster(monster.getX() + distX, monster.getY(), monster)
							&& contactMonster(monster.getX(), monster.getY() + distY, monster)) {
						if (Math.random() <= .50d) {
							monster.setX(monster.getX() + distX);
						} else {
							monster.setY(monster.getY() + distY);
						}

						// Sinon prendre la direction qui est libre
					} else if (contactMonster(monster.getX() + distX, monster.getY(), monster)) {
						monster.setX(monster.getX() + distX);
					} else if (contactMonster(monster.getX(), monster.getY() + distY, monster)) {
						monster.setY(monster.getY() + distY);
					}

				} else { // Le mouvement automatique de l'IA
					switch (monster.getDirection()) {
					case DOWN:
						if (contactMonster(monster.getX(), monster.getY() + 1, monster)) {
							monster.moveDown();

						} else {
							if (!contactMonster(monster.getX(), monster.getY() - 1, monster)) {
								monster.setDirection(ControllerOrder.RIGHT);

							} else {
								monster.moveUp();
							}
						}
						break;
					case UP:
						if (contactMonster(monster.getX(), monster.getY() - 1, monster)) {
							monster.moveUp();
						} else {
							if (!contactMonster(monster.getX(), monster.getY() + 1, monster)) {
								monster.setDirection(ControllerOrder.LEFT);
							} else {
								monster.moveDown();
							}
						}
						break;
					case LEFT:
						if (contactMonster(monster.getX() - 1, monster.getY(), monster)) {
							monster.moveLeft();

						} else {
							if (!contactMonster(monster.getX() + 1, monster.getY(), monster)) {
								monster.setDirection(ControllerOrder.DOWN);
							} else {
								monster.moveRight();
							}
						}
						break;
					case RIGHT:
						if (contactMonster(monster.getX() + 1, monster.getY(), monster)) {
							monster.moveRight();

						} else {
							if (!contactMonster(monster.getX() - 1, monster.getY(), monster)) {
								monster.setDirection(ControllerOrder.UP);
							} else {
								monster.moveLeft();
							}
						}
						break;
					default:
						break;
					}
				}
			}

		}

	}

	/**
	 * Gets the view
	 * 
	 * @return IView
	 */
	public IView getView() {
		return view;
	}

	/**
	 * Verifies if no spell is already created then cast the spell
	 * 
	 */
	public void castSpell() throws IOException {
		if (!isSpell()) {
			model.createSpell("fireball");
			Sounds.SPELL.play();
			model.flush();
		}
	}

	/**
	 * Verifies if no spell is created
	 * 
	 * @return boolean
	 */
	public boolean isSpell() {
		if (spell != null) {
			return true;
		}
		return false;
	}

	/**
	 * Moves the spell according to its direction
	 * 
	 */
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

	/**
	 * Verifies if there is no element blocking the spell from being created
	 * 
	 * @return boolean
	 */
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

	/**
	 * Destroys the spell
	 * 
	 */
	public synchronized void destroySpell() {
		model.getMap().setSpell(null);
		spell = null;
	}

	/**
	 * Destroys the monster
	 * 
	 * @param monster
	 */
	public synchronized void destroyMonster(IMobileElement monster) {
		model.getMap().getMobiles().remove(monster);
	}

}
