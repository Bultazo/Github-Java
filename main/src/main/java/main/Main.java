package main;

import java.sql.SQLException;

import controller.Controller;
import model.*;
import view.*;


/**
 * <h1>The Class Main.</h1>
 *
 * @author DELL
 * @version 1.0
 */
public abstract class Main {

    public static void main(final String[] args) throws SQLException {
		
    	Model model = new Model(); //On instancie un modèle
		model.loadMap(3); //On charge la map correspondante
		
		ViewFacade view = new ViewFacade(model); //On lie la vue et le modèle
		
		Controller controller = new Controller(view, model);

    }

}
