package main;

import java.sql.SQLException;

import controller.Controller;
import model.*;
import view.*;


/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws SQLException {
		Model model = new Model();
		model.loadMap(1);
		
		View view = new View(model);
		
		Controller controller = new Controller(view, model);
		
		view.setController(controller);
    }

}
