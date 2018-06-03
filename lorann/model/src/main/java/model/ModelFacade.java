package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observer;

import contract.ControllerOrder;
import model.dao.ExampleDAO;


/**
 * @author DELL
 *
 */
public final class ModelFacade implements IModel{

	/**
	 * The model
	 */
	private Model model;
 
    /**
     * The main constructor 
     */
    public ModelFacade() {
        this.model = new Model();
    }
    
    // All the model methods
    
    public IMap getMap() {
    	return this.model.getMap();
    }

	public void loadMap(int ID) {
		this.model.loadMap(ID);
	}

	public void flush() {
		this.model.flush();
	}

	public void createSpell(String path) throws IOException{
		this.model.createSpell(path);
	}

	public void setOpenDoor(IElement element) {
		this.model.setOpenDoor(element);
	}

	public int testType(IElement element) {
		return this.model.testType(element);
	}
	
	public void addObserver(Observer o) {
		this.model.addObserver(o);
	}
	
	// Database Access
	
	public ResultSet getElementById(final int id) throws SQLException {
		return this.model.getElementById(id);
	}

	public ResultSet getElementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getElementByName(name);

	}
	public ResultSet getAllElements() throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getAllElements();
	}
	
	// Getters and setters
	
	public void setMessage(String message) {
		this.model.setMessage(message);
	}

	public String getMessage() {
		return this.model.getMessage();
	}

	@Override
	public void setResurrections(int resurrections) {
		this.model.setResurrections(resurrections);
		
	}

	@Override
	public int getResurrections() {
		return this.model.getResurrections();
	}

	@Override
	public void setScore(int i) {
		this.model.setScore(i);
	}

	@Override
	public int getScore() {
		return this.model.getScore();
	}
}
