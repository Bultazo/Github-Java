 package main;

import java.sql.SQLException;

import controller.Controller;
import controller.ControllerFacade;
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
		
    	ModelFacade model = new ModelFacade(); //On instancie un modèle
		ViewFacade view = new ViewFacade(model); //On lie la vue et le modèle
		ControllerFacade controller = new ControllerFacade(view, model);
		//hello ma gueule

    }

}
