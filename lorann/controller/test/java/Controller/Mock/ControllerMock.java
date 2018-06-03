package Controller.Mock;

import contract.*;

import java.io.IOException;

/**
 * @author Romain
 */
public class ControllerMock implements IController {

    private IModel modelMock;

    private IView view;

    private IMobileElement monster;

    public ControllerMock(ViewMock view,ModelMock model) {
        this.setModel(model);
        this.view=view;
    }

    public void moveHero(int x, int y) {
        this.modelMock.getMap().getHero().setX(modelMock.getMap().getHero().getX()+x);
        this.modelMock.getMap().getHero().setY(modelMock.getMap().getHero().getY()+y);
    }

    public void AIMonster() {
        for(IMobileElement mobile : modelMock.getMap().getMobiles()){
            mobile.getX();
        }
    }

    public boolean contactMonster(int x, int y) {
        return modelMock.getMap().getElement(x, y) == null;
    }

    public boolean contactHero(int x, int y) {

        if(modelMock.getMap().getElement(x, y) == null){
            return true;
        }

        else if(modelMock.getMap().getElement(x,y).getStateElement()==StateElement.DOOR){
            return true;
        }

        else if(modelMock.getMap().getElement(x,y).getStateElement()== StateElement.DRAGON)
        {
            return false;
        }

        else{
            return false;
        }


    }

    public void orderPerform(ControllerOrder controllerOrder) throws IOException {

    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final IModel model) {
        this.modelMock =model;
    }

    public IModel getModelMock()
    {
        return  this.modelMock;
    }

}
