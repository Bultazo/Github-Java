package model.Element;

import model.IAnimatedSprite;
import model.ISprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * @author DELL
 *
 */
public class AnimatedSprite extends Sprite implements IAnimatedSprite {

    /**
     * The images
     */
    private Image[] images;
   
    /**
     * The stepNumber
     */
    private int stepNumber;

    /**
     * The step
     */
    private int step;

    /**
     * The main constructor 
     */
    public AnimatedSprite(Image image, String[] images) {
        super(image);
        this.images = new Image[images.length];
        for(int i = 0; i<images.length; i++){
            try {
               this.images[i] = ImageIO.read(new File("C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/"+images[i]+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.step = 0;
    }
    
    // Animation 
    
    /*
     * Overrides the next Method in the implemented interface
     */ 
    public void next()
    {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    // Getters and setters 
    
    /**
     * Gets the image
     * @return Image[]
     */
    public Image[] getImages() {
		return images;
	}


	/**
	 * Set the image array (Animation)
	 * @return void
	 */
	public void setImages(Image[] images) {
        this.images = images;
    }

    /*
     * Overrides the getImage Method in the implemented interface
     */ 
    public Image getImage() {
        return this.images[this.step];
    }
}
