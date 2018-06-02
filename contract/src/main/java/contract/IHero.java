package contract;
import java.awt.*;

public interface IHero extends IMobileElement {
    
    /**
     * Sets the Image.
     * @param image
     *          The image to set.
     */
    public void setImage(Image image);
    
	/**
     * Gets the Image.
     *
     * @return
     *      Image.
     */
    Image getImage();
    

}
