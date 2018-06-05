/**
 * ModelMock.java
 */
package Mock;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
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
		this.map = null;
	}

	/**
	 * Loads the map
	 * @param ID
	 * @throws IOException 
	 */
	public void loadMapp(final int ID) throws IOException {

		this.map=new MapMock(20,12);
        try {
			map.setHero(new HeroMock(this));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.setHeroPosition(5,5);
        map.setID(ID);
        map.getMobiles().add(new MonsterMock("monster_1", this));
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
	 * @return
	 */ 
	@Override
	public IMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Overrides the setMessage Method in the implemented interface
	 * @param message
	 */ 
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the getMessage Method in the implemented interface
	 * @return
	 */ 
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Overrides the setOpenDoor Method in the implemented interface
	 * @param element
	 */ 
	@Override
	public void setOpenDoor(IElement element) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the setResurrections Method in the implemented interface
	 * @param resurrections
	 */ 
	@Override
	public void setResurrections(int resurrections) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the getResurrections Method in the implemented interface
	 * @return
	 */ 
	@Override
	public int getResurrections() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * Overrides the setScore Method in the implemented interface
	 * @param i
	 */ 
	@Override
	public void setScore(int i) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the getScore Method in the implemented interface
	 * @return
	 */ 
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void loadMap(int ID) {
		// TODO Auto-generated method stub
		
	}
}