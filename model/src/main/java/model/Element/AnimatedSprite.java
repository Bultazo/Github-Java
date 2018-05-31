package model.Element;

import contract.IAnimatedSprite;
import contract.ISprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class AnimatedSprite extends Sprite implements IAnimatedSprite {

    private Image[] images;
   
    private int stepNumber;

    private int step;

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


    public Image[] getImages() {
		return images;
	}


	public void setImages(Image[] images) {
        this.images = images;
    }

    public void next()
    {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    public Image getImage() {
        return this.images[this.step];
    }
}
