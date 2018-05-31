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
import model.dao.ExampleDAO;

import javax.imageio.ImageIO;

public class Model extends Observable implements IModel {

	private Map map;

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
					break;
				case ("Player"):
					Hero h = new Hero(this);
					map.setHero(h);
					map.setHeroPosition(resultSet.getInt("X"), resultSet.getInt("Y"));
					break;

				case ("MonstreF"):
					switch (monsterCount) {
					case (1): {
						MobileElement m = new Monster("monster_1");
						map.getMobiles().add(m);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (2): {
						MobileElement m = new Monster("monster_2");
						map.getMobiles().add(m);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (3): {
						MobileElement m = new Monster("monster_3");
						map.getMobiles().add(m);
						m.setX(resultSet.getInt(("X")));
						m.setY(resultSet.getInt("Y"));
						monsterCount++;
						break;
					}
					case (4): {
						MobileElement m = new Monster("monster_4");
						map.getMobiles().add(m);
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

	public synchronized void flush() {
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

	public void createSpell(String path, ControllerOrder direction) throws IOException {
		IMobileElement spell = new Spell(path, direction);
		IMobileElement lorann = map.getHero();
		map.setSpell(spell);

		switch (lorann.getDirection()) {
		case UP:
			map.getSpell().setY(lorann.getY() - 1);
			map.getSpell().setX(lorann.getX());
			break;

		case DOWN:
			map.getSpell().setY(lorann.getY() + 1);
			map.getSpell().setX(lorann.getX());
			break;

		case RIGHT:
			map.getSpell().setY(lorann.getY());
			map.getSpell().setX(lorann.getX() + 1);
			break;

		case LEFT:
			map.getSpell().setY(lorann.getY());
			map.getSpell().setX(lorann.getX() - 1);
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultSet getElementById(final int id) throws SQLException {
		return ExampleDAO.getElementById(id);
	}

	public ResultSet getElementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getElementByName(name);

	}

	public ResultSet getAllElements() throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getAllElements();
	}

}