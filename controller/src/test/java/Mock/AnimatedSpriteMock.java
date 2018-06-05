package Mock;



import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.IAnimatedSprite;


public class AnimatedSpriteMock extends SpriteMock implements IAnimatedSprite {
	  
	public AnimatedSpriteMock(Image image, String[] images) {
	     	super(image);
	        this.images = new Image[images.length];
	        for(int i = 0; i<images.length; i++){
	            try {
	               this.images[i] = ImageIO.read(new File("sprite/"+images[i]+".png"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        this.step = 0;
	    }
	
    int step;
    Image[] images;

    public void next() {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    public Image getImage() {
        return this.images[this.step];
    }

    public void setImage(Image image) {
        this.images = images;
    }
}
