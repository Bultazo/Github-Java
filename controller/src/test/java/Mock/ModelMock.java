/**
 * ModelMock.java
 */
package Mock;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.ControllerOrder;
import contract.Permeability;
import contract.StateElement;
import model.IElement;
import model.IMap;
import model.IMobileElement;
import model.IModel;


/**
 * @author DELL & Samir
 *
 */
public class ModelMock extends Observable implements IModel {

	/**
	 * The map
	 */
	private MapMock map;

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
	public ModelMock() {

	}

	/**
	 * Loads the map
	 * 
	 * @param ID
	 */
	public void loadMap(int ID) {
		
		try {
			HeroMock hero = new HeroMock(this);
			this.map = new MapMock(20, 12,hero);
			hero.setX(5);
			hero.setY(5);
			this.map.setID(ID);
			this.score = 0;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

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
		if (element instanceof DoorMock) {
			return 2;
		}
		return 0;
	}

	/*
	 * Overrides the createSpell Method in the implemented interface
	 */
	public void createSpell(String path) throws IOException {
		IMobileElement spell = new SpellMock(path, this);
		IMobileElement lorann = map.getHero();
		map.setSpell(spell);
	}

	/*
	 * Overrides the getMap Method in the implemented interface
	 * 
	 * @return
	 */

	public void setOpenDoor(IElement element) {
		element.setPermeability(Permeability.PENETRABLE);
		element.setStateElement(StateElement.DOOR);

	}

	// Getters and setters

	/*
	 * Overrides the getMap Method in the implemented interface
	 */
	public IMap getMap() {
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