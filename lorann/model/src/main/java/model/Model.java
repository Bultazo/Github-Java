package model;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import contract.*;
import model.mobileElement.*;
import model.motionLessElement.*;
import model.Element.*;
import model.dao.ExampleDAO;
import javax.imageio.ImageIO;

/**
 * @author DELL
 *
 */
public class Model extends Observable implements IModel {

	/**
	 * The map
	 */
	private Map map;

	/**
	 * The score
	 */
	private int score;

	/**
	 * The message
	 */
	private String message;

	/**
	 * The resurrections
	 */
	private int resurrections;

	/**
	 * The main constructor 
	 */
	public Model() {
		this.map = null;
	}

	/**
	 * Loads the map
	 */
	public void loadMap(final int ID) {
		map = new Map(20, 12);
		map.setID(ID);

		ResultSet resultSet = null;

		try {
			resultSet = this.getElementById(ID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int monsterCount = 1;

		try {
			while (resultSet.next()) {

				String type = resultSet.getString("type");
				MotionlessElement e = null;

				switch (type) {
				case ("BoneH"):
					e = new BoneH();
					break;
				case ("BoneC"):
					e = new BoneC();
					break;
				case ("BoneV"):
					e = new BoneV();
					break;
				case ("Bourse"):
					e = new Purse();
					break;
				case ("Clef"):
					e = new Key();
					break;
				case ("Porte"):
					e = new Door();
					map.setDoor(e);
					break;
				case ("Player"):
					Hero h = new Hero(this);
					h.setDirection(ControllerOrder.NOP);
					map.setHero(h);
					map.setHeroPosition(resultSet.getInt("X"), resultSet.getInt("Y"));
					break;

				case ("Monstre"):
					switch (monsterCount) {
					case (1): {
						MobileElement m = new Monster("monster_1", this);
						map.getMobiles().add(m);
						m.setDirection(ControllerOrder.RIGHT);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (2): {
						MobileElement m = new Monster("monster_2", this);
						map.getMobiles().add(m);
						m.setDirection(ControllerOrder.RIGHT);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (3): {
						MobileElement m = new Monster("monster_3", this);
						map.getMobiles().add(m);
						m.setDirection(ControllerOrder.RIGHT);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (4): {
						MobileElement m = new Monster("monster_4", this);
						map.getMobiles().add(m);
						m.setDirection(ControllerOrder.RIGHT);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					}
				}
				map.addElementToMap(e, resultSet.getInt("X"), resultSet.getInt("Y"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setMessage("");
	}

	/**
	 * 
	 * Accesses the database
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getElementById(final int id) throws SQLException {
		return ExampleDAO.getElementById(id);
	}
	
	/**
	 * Refreshes the view
	 */
	public synchronized void flush() {
		setChanged();
		notifyObservers();
	}
	
	
	// Methods
	
	/*
	 * Overrides the testType Method in the implemented interface
	 */ 
	public int testType(IElement element) {
		if (element instanceof Purse) {
			return 2;
		} else if (element instanceof Key) {
			return 4;
		}
		return 0;
	}
	

	/*
	 * Overrides the createSpell Method in the implemented interface
	 */ 
	public void createSpell(String path) throws IOException {
		IMobileElement spell = new Spell(path, this);
		IMobileElement lorann = map.getHero();
		map.setSpell(spell);

		switch (lorann.getDirection()) {
		case UP:
			map.getSpell().setY(lorann.getY() + 1);
			map.getSpell().setX(lorann.getX());
			map.getSpell().setDirection(ControllerOrder.DOWN);
			break;

		case DOWN:
			map.getSpell().setY(lorann.getY() - 1);
			map.getSpell().setX(lorann.getX());
			map.getSpell().setDirection(ControllerOrder.UP);
			break;

		case RIGHT:
			map.getSpell().setY(lorann.getY());
			map.getSpell().setX(lorann.getX() - 1);
			map.getSpell().setDirection(ControllerOrder.LEFT);
			break;

		case LEFT:
			map.getSpell().setY(lorann.getY());
			map.getSpell().setX(lorann.getX() + 1);
			map.getSpell().setDirection(ControllerOrder.RIGHT);
			break;
		default:
			break;
		}
		Sounds.SPELL.play();
	}
	
	/*
	 * Overrides the setOpenDoor Method in the implemented interface
	 */ 
	public void setOpenDoor(IElement element) {
		// TODO Auto-generated method stub
		try {
			element.setSprite(new Sprite(ImageIO.read(new File(
					"C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/gate_open.png"))));
			element.setPermeability(Permeability.PENETRABLE);
			element.setStateElement(StateElement.DOOR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// Getters and setters 
	
	/*
	 * Overrides the getMap Method in the implemented interface
	 */ 
	public Map getMap() {
		return this.map;
	}

	/*
	 * Overrides the getMessage Method in the implemented interface
	 */ 
	public String getMessage() {
		return message;
	}

	/*
	 * Overrides the setMessage Method in the implemented interface
	 */ 
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * Overrides the getResurrections Method in the implemented interface
	 */ 
	public int getResurrections() {
		return resurrections;
	}

	/*
	 * Overrides the setResurrections Method in the implemented interface
	 */ 
	public void setResurrections(int resurrections) {
		this.resurrections = resurrections;
	}

	/*
	 * Overrides the setScore Method in the implemented interface
	 */ 
	public void setScore(int score) {
		this.score = score;
	}

	/*
	 * Overrides the getScore Method in the implemented interface
	 */ 
	public int getScore() {
		return this.score;
	}

}