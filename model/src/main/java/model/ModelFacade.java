package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observer;

import contract.ControllerOrder;
import contract.IElement;
import contract.IMap;
import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade  {

	private Model model;
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        this.model = new Model();
    }
    
    public IMap getMap() {
    	return this.model.getMap();
    }

	public void loadMap(int ID) {
		this.model.loadMap(ID);
	}

	public void flush() {
		this.model.flush();
	}

	public void setMessage(String message) {
		this.model.setMessage(message);
	}

	public String getMessage() {
		return this.model.getMessage();
	}

	void createSpell(String path, ControllerOrder direction) throws IOException{
		this.model.createSpell(path, direction);
	}

	void setDoor(IElement element) {
		this.model.setDoor(element);
	}

	int testType(IElement element) {
		return this.model.testType(element);
	}
	
	public void addObserver(Observer o) {
		this.model.addObserver(o);
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
