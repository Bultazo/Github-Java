package model;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import contract.*;
import model.mobileElement.*;
import model.motionLessElement.*;
import model.ModelFacade;
import model.Element.*;

import javax.imageio.ImageIO;

public class Model extends Observable implements IModel {

	private Map map;

	private ModelFacade modelface;

	private String message;

	public Model() {
		this.map = null;
	}

	public Map getMap() {
		return this.map;
	}

	public void loadMap(final int ID) {

		map = new Map(20, 12);
		map.setID(ID);
		modelface = new ModelFacade();
		ResultSet resultSet = null;
		try {
			resultSet = modelface.getElementById(ID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int monsterPlus = 1;
		if (resultSet == null) {
			System.out.println("ajpppppppppppppppppppppppppppppppppppppppppppppp");
		}
		try {
			while (resultSet.next()) {

				String name = resultSet.getString("type");
				if (name.equals("BoneH")) {
					MotionlessElement e = new BoneH();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				} else if (name.equals("BoneC")) {
					MotionlessElement e = new BoneC();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				} else if (name.equals("BoneV")) {
					MotionlessElement e = new BoneV();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				} else if (name.equals("Bourse")) {
					MotionlessElement e = new Purse();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				} else if (name.equals("Clef")) {
					MotionlessElement e = new Key();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				} else if (name.equals("Player")) {
					Hero e = new Hero();
					map.setHero(e);
					map.setHeroPosition(resultSet.getInt("X"), resultSet.getInt("Y"));
					map.getHero().setStateElement(StateElement.WEAK);
				}

				else if (name.equals("MonstreF")) {
					switch (monsterPlus) {
					case (1): {
						MobileElement e = new Monster("monster_1");
						map.getMobiles().add(e);
						e.setX(resultSet.getInt(("X")));
						e.setY(resultSet.getInt("Y"));
						monsterPlus++;
						break;
					}
					case (2): {
						MobileElement e = new Monster(name + "_2");
						map.getMobiles().add(e);
						e.setX(resultSet.getInt(("X")));
						e.setY(resultSet.getInt("Y"));
						monsterPlus++;
						break;
					}
					case (3): {
						MobileElement e = new Monster(name + "_3");
						map.getMobiles().add(e);
						e.setX(resultSet.getInt(("X")));
						e.setY(resultSet.getInt("Y"));
						monsterPlus++;
						break;
					}
					case (4): {
						MobileElement e = new Monster(name + "_4");
						e.setX(resultSet.getInt(("X")));
						e.setY(resultSet.getInt("Y"));
						map.getMobiles().add(e);
						monsterPlus++;
						break;
					}

					}

				} else if (name.equals("Porte")) {
					Door e = new Door();
					map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setMessage("");
	}

	public Observable getObservable() {
		return this;
	}

	public synchronized void flush() {
		if (map.getScore() >= 100 && map.getHero() != null)
			map.getHero().setStateElement(StateElement.STRONG);

		setChanged();
		notifyObservers();
	}

	public int testType(IElement element) {
		if (element instanceof Door)
			return 1;

		if (element instanceof Purse)
			return 2;

		if (element instanceof Monster)
			return 3;

		if (element instanceof Key)
			return 4;

		return 0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		flush();
	}

	public void createSpell(String path, ControllerOrder direction) throws IOException {
		MobileElement spell = new Spell(path, direction);

		map.setSpell(spell);
		switch (map.getHero().getDirection()) {
		case UP:
			map.getSpell().setY(map.getHero().getY() - 1);
			map.getSpell().setX(map.getHero().getX());
			break;

		case DOWN:
			map.getSpell().setY(map.getHero().getY() + 1);
			map.getSpell().setX(map.getHero().getX());
			break;

		case RIGHT:
			map.getSpell().setY(map.getHero().getY());
			map.getSpell().setX(map.getHero().getX() + 1);
			break;

		case LEFT:
			map.getSpell().setY(map.getHero().getY());
			map.getSpell().setX(map.getHero().getX() - 1);
			break;
		default:
			break;
		}

		map.getSpell().setDirection(direction);
	}

	public void setDoor(IElement element) {
		try {
			element.setSprite(new Sprite(ImageIO.read(new File(
					"C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/gate_open.png"))));
			element.setPermeability(Permeability.PENETRABLE);
			element.setStateElement(StateElement.DOOR);
			flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}