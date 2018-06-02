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
	private IView view;
	/**
	 * The model
	 */
	private IModel model;
	/**
	 * The clock
	 */
	private Clock clock;
	/**
	 * The move
	 */
	private ClockLorann move;

	/**
	 * The count of lateral boucing of the monster
	 */
	private int monsterCountX = 0;
	/**
	 * The count of vertical bouncing of the monster
	 */
	private int monsterCountY = 0;
	/**
	 * The list of monsters to be killed
	 */
	private ArrayList<IMobileElement> DeadMonsters;

	/**
	 * Lorann
	 */
	private IMobileElement lorann;
	/**
	 * The spell
	 */
	private IMobileElement spell;
	/**
	 * The scoreLevel
	 */
	private int scoreLevel;

	/**
	 * The main constructor
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
	 * Initialize all the needed variables to fresh
	 * 
	 */
	public void init() {
		this.model.loadMap(7); // On charge la première map
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
					clock.setStopped(false);
					clock = new Clock(this);
					clock.start();
				}
				break;
			}
		}
	}

	/*
	 * Overrides the contactHero Method in the implemented interface
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

	public synchronized boolean contactMonster(int x, int y, IMobileElement monster) {
		if (model.getMap().getElement(x, y) == null) {
			if (lorann.getX() == x && lorann.getY() == y) { // If there will be a contact with the hero.
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
																			// monsters
					return false;
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
				if (Math.abs(lorann.getX() - monster.getX()) <= 4 && Math.abs(lorann.getX() - monster.getX()) <= 4) {
					monster.setStateElement(StateElement.MONSTER);
				}
				if (monster.getStateElement() == StateElement.MONSTER) {
					if (lorann.getY() > monster.getY()) {
						if (contactMonster(monster.getX(), monster.getY() + 1, monster)) {
							monster.moveDown();
						}

					} else if (lorann.getY() < monster.getY()) {
						if (contactMonster(monster.getX(), monster.getY() - 1, monster)) {
							monster.moveUp();
						}
					} else {
						if (lorann.getX() < monster.getX()) {
							if (contactMonster(monster.getX() - 1, monster.getY(), monster)) {
								monster.moveLeft();
							}
						} else if (lorann.getX() > monster.getX()) {
							if (contactMonster(monster.getX() + 1, monster.getY(), monster)) {
								monster.moveRight();
							}
						}
					}
				}

				else {
					switch (monster.getDirection()) {
					case DOWN:
						if (contactMonster(monster.getX(), monster.getY() + 1, monster)) {
							monster.moveDown();
							this.monsterCountX = 0;
						} else if (monsterCountY > 1) {
							monster.setDirection(ControllerOrder.RIGHT);
						} else {
							monster.setDirection(ControllerOrder.UP);
							this.monsterCountY++;
						}
						break;
					case UP:
						if (contactMonster(monster.getX(), monster.getY() - 1, monster)) {
							monster.moveUp();
							this.monsterCountX = 0;
						} else if (monsterCountY > 1) {
							monster.setDirection(ControllerOrder.RIGHT);
						} else {
							monster.setDirection(ControllerOrder.DOWN);
							this.monsterCountY++;
						}
						break;
					case LEFT:
						if (contactMonster(monster.getX() - 1, monster.getY(), monster)) {
							monster.moveLeft();
							this.monsterCountY = 0;
						} else if (monsterCountX > 1) {
							monster.setDirection(ControllerOrder.UP);
						} else {
							monster.setDirection(ControllerOrder.RIGHT);
							this.monsterCountX++;
						}
						break;
					case RIGHT:
						if (contactMonster(monster.getX() + 1, monster.getY(), monster)) {
							monster.moveRight();
							this.monsterCountY = 0;
						} else if (monsterCountX > 1) {
							monster.setDirection(ControllerOrder.UP);
						} else {
							monster.setDirection(ControllerOrder.LEFT);
							this.monsterCountX++;
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
			System.out.println(spell.getDirection());
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
	 */
	public synchronized void destroyMonster(IMobileElement monster) {
		model.getMap().getMobiles().remove(monster);
	}

}
