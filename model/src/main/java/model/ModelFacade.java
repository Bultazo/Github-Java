package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade  {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */

    public ResultSet getElementById(final int id) throws SQLException {
        return ExampleDAO.getElementById(id);
    }

    

	public ResultSet getElementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getElementByName(name);
		
	}

	/* (non-Javadoc)
	 * @see model.IModel#getAllElements()
	 */

	public ResultSet getAllElements() throws SQLException {
		// TODO Auto-generated method stub
		return ExampleDAO.getAllElements();
		
	}

}
